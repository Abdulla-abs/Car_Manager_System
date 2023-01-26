package com.example.spingboot.config;

import com.example.spingboot.aop.UserAuthenticationEntryPoint;
import com.example.spingboot.aop.UserLoginFailureHandler;
import com.example.spingboot.aop.UserLoginSuccessHandler;
import com.example.spingboot.aop.UserLogoutSuccessHandler;
import com.example.spingboot.filter.LoginUsernamePasswordAuthenticationFilter;
import com.example.spingboot.filter.UriFilter;
import com.example.spingboot.utils.AesUtil;
import com.example.spingboot.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsUtils;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/5/10 8:38
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

        @Autowired
        private UserDetailsService userDetailsService;

        @Autowired
        private UserLoginFailureHandler userLoginFailureHandler;

        @Autowired
        private UserLoginSuccessHandler userLoginSuccessHandler;

        @Autowired
        private UserAuthenticationEntryPoint userAuthenticationEntryPoint;

        @Autowired
        private UserLogoutSuccessHandler userLogoutSuccessHandler;

        @Autowired
        private UriFilter uriFilter;

        @Autowired
        private AesUtil aesUtil;

        @Autowired
        private RedisUtil redisUtil;

        @Override
        protected void configure(HttpSecurity http) throws Exception {
                http.csrf().disable();

                http.headers().frameOptions().disable();

                http.cors();

                http.authorizeRequests() //请示授权
                        .requestMatchers(CorsUtils::isPreFlightRequest).permitAll() //跨域配置
                        .antMatchers("/login")
                        .permitAll()
                        .anyRequest().authenticated()
                        .and().formLogin()
                        .successHandler(userLoginSuccessHandler)
                        .failureHandler(userLoginFailureHandler)
                        .and()
                        .exceptionHandling().authenticationEntryPoint(userAuthenticationEntryPoint)
                        .and().logout().permitAll()
                        .logoutSuccessHandler(userLogoutSuccessHandler)
                        .and()
                        .addFilterBefore(uriFilter, UsernamePasswordAuthenticationFilter.class)
                        .addFilterAt(authenticationFilter(),UsernamePasswordAuthenticationFilter.class); //自定义身份过滤器
        }

        @Bean
        public PasswordEncoder passwordEncoder(){
                return new BCryptPasswordEncoder();
        }

        @Bean
        @Override
        protected AuthenticationManager authenticationManager() throws Exception {
                return super.authenticationManager();
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
                auth.userDetailsService(userDetailsService)
                        .passwordEncoder(passwordEncoder());
        }

        LoginUsernamePasswordAuthenticationFilter authenticationFilter() throws Exception {
                LoginUsernamePasswordAuthenticationFilter filter = new LoginUsernamePasswordAuthenticationFilter();

                filter.setAuthenticationManager(authenticationManager());
                filter.setAesUtil(aesUtil);
                filter.setRedisUtil(redisUtil);

                filter.setAuthenticationSuccessHandler(userLoginSuccessHandler);
                filter.setAuthenticationFailureHandler(userLoginFailureHandler);
                return filter;
        }
}
