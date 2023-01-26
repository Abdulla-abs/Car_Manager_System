package com.example.spingboot.aop;

import com.example.spingboot.common.enums.ResultStatusEnum;
import com.example.spingboot.domain.vo.ResultVo;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author abbas
 * @description: 用户登录失败
 * @date 2022/5/13 20:15
 */
@Component
public class UserLoginFailureHandler implements AuthenticationFailureHandler {

        @Override
        public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
                new ResultVo(ResultStatusEnum.USER_LOGIN_FAILED).out(response);
        }
}
