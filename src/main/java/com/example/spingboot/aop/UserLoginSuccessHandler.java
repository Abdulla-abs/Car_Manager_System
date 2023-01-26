package com.example.spingboot.aop;

import com.example.spingboot.domain.dto.MasterDto;
import com.example.spingboot.domain.vo.ResultVo;
import com.example.spingboot.utils.JwtUtil;
import com.example.spingboot.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author abbas
 * @description: 登录成功
 * @date 2022/5/13 20:17
 */
@Component
public class UserLoginSuccessHandler implements AuthenticationSuccessHandler {

        @Autowired
        private RedisUtil redisUtil;

        @Autowired
        private JwtUtil jwtUtil;

        @Override
        public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                //获取用户
                MasterDto user = (MasterDto) authentication.getPrincipal();
                //写入上下文
                SecurityContextHolder.getContext().setAuthentication(authentication);
                //保存到redis
                redisUtil.save(user.getAccountId(),authentication);
                //生成token
                String token = jwtUtil.generateTaken(user.getAccountId());
                //保存到redis
                redisUtil.save(user.getAccountId(),token);

                response.setHeader("token",token);

                ResultVo resultVo = new ResultVo(user);
                resultVo.out(response);
        }
}
