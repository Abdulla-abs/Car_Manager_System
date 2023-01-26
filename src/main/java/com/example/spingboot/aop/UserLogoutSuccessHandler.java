package com.example.spingboot.aop;

import com.example.spingboot.common.enums.ResultStatusEnum;
import com.example.spingboot.domain.vo.ResultVo;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author abbas
 * @description: 登出成功
 * @date 2022/5/13 20:21
 */
@Component
public class UserLogoutSuccessHandler implements LogoutSuccessHandler {

        @Override
        public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                SecurityContextHolder.clearContext();
                new ResultVo(ResultStatusEnum.USER_NOT_LOGIN).out(response);
        }
}
