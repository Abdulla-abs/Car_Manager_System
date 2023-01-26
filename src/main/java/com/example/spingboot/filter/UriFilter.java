package com.example.spingboot.filter;

import com.example.spingboot.common.enums.ResultStatusEnum;
import com.example.spingboot.domain.vo.ResultVo;
import com.example.spingboot.utils.AesUtil;
import com.example.spingboot.utils.JwtUtil;
import com.example.spingboot.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author abbas
 * @description: JWT登录认证过滤器
 * @date 2022/5/14 16:07
 */

@Component
public class UriFilter extends OncePerRequestFilter {

        @Autowired
        private JwtUtil jwtUtil;

        @Autowired
        private RedisUtil redisUtil;

        @Autowired
        private AesUtil aesUtil;

        @Override
        protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
                String uri = request.getRequestURI();

                if (uri.indexOf("/login") == 0) {
                        filterChain.doFilter(request,response);
                }else {
                        /**
                         * 从请求头获取token，如果token未过期且有效，
                         * 将从redis缓存当中读取用户消息写入上下文
                         * 生成新的token再缓存
                         * 将token添加到响应头，发回客户端
                         * 将请求转发给控制器
                         * 若token无效或过期，将拒绝访问
                         */
                        boolean access = true; //默认允许访问
                        String accessToken = request.getHeader("token"); //拿到token
                        accessToken = aesUtil.decrypt(accessToken); //aes 解密token
                        //若token未过期
                        if (!jwtUtil.isExpires(accessToken)) {
                                //拿到用户id
                                String username = jwtUtil.getUsername(accessToken);
                                //拿到redis当中的token
                                String validityToken = redisUtil.getToken(username);
                                //如果token有效
                                if (jwtUtil.validityToken(accessToken,validityToken)) {
                                        //重新生成token
                                        String token = jwtUtil.generateTaken(username);
                                        //保存到redis缓存
                                        redisUtil.save(username,token);
                                        //读取身份，写入上下文
                                        Authentication authentication = redisUtil.getAuthentication(username);
                                        SecurityContextHolder.getContext()
                                                .setAuthentication(authentication);

                                        response.setHeader("token",token);
                                        filterChain.doFilter(request,response);
                                }else { //token无效
                                        access = false;
                                }
                        }else {
                                access = false;
                        }
                        //拒绝访问
                        if (!access){
                                ResultVo resultVo = new ResultVo(ResultStatusEnum.USER_NOT_LOGIN);
                                resultVo.out(response);
                        }
                }
        }
}
