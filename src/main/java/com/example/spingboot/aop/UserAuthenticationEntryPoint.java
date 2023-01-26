package com.example.spingboot.aop;

import com.example.spingboot.common.enums.ResultStatusEnum;
import com.example.spingboot.domain.vo.ResultVo;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author abbas
 * @description: 需要认证用户时调用
 * @date 2022/5/13 20:11
 */
@Component
public class UserAuthenticationEntryPoint implements AuthenticationEntryPoint {

        @Override
        public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
                new ResultVo(ResultStatusEnum.USER_NOT_LOGIN).out(response);
        }
}
