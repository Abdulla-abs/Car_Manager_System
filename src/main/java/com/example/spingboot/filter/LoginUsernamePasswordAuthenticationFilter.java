package com.example.spingboot.filter;

import com.example.spingboot.utils.AesUtil;
import com.example.spingboot.utils.RedisUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author abbas
 * @description: 登录过滤器
 * @date 2022/5/14 20:33
 */

public class LoginUsernamePasswordAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

        /**
         * 过滤器无法交给容器，这里仅采用set、get
         */
        private AesUtil aesUtil;
        private RedisUtil redisUtil;

        public LoginUsernamePasswordAuthenticationFilter() {
                super(new AntPathRequestMatcher("/login","POST"));
        }

        @Override
        public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
                String username = getUsername(request);
                String password = getPassword(request);
                //生成认证token
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,password);
                //提交AuthenticationManager认证
                return super.getAuthenticationManager().authenticate(authenticationToken);
        }

        protected String getUsername(HttpServletRequest request){
                return request.getParameter("username");
        }

        private String getPassword(HttpServletRequest request){
                String username = request.getParameter("username");
                String encrypt = request.getParameter("password");   //拿到加密的密码

                String validityPassword = redisUtil.getPassword(username); //拿到redis当中的密码
                //若二者相同 密码无效
                if (encrypt.equals(validityPassword)){
                        return null;
                }
                //密码更新进黑名单
                redisUtil.setPassword(username,encrypt);
                String content = aesUtil.decrypt(encrypt); //解密
                return aesUtil.getPassword(content); //还原密码返回
        }

        public void setAuthenticationManager(AuthenticationManager authenticationManager) {
                super.setAuthenticationManager(authenticationManager);
        }

        public AesUtil getAesUtil() {
                return aesUtil;
        }

        public void setAesUtil(AesUtil aesUtil) {
                this.aesUtil = aesUtil;
        }

        public RedisUtil getRedisUtil() {
                return redisUtil;
        }

        public void setRedisUtil(RedisUtil redisUtil) {
                this.redisUtil = redisUtil;
        }
}
