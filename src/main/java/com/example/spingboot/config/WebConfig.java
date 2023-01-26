package com.example.spingboot.config;

import com.example.spingboot.converter.DateFormatter;
import com.example.spingboot.converter.StringFormatter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/4/24 20:48
 */

@Configuration
public class WebConfig implements WebMvcConfigurer {

        @Override
        public void addFormatters(FormatterRegistry registry) {
                registry.addFormatter(new StringFormatter());
                registry.addFormatter(new DateFormatter());
        }

        @Override
        public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") //添加映射
                        .allowCredentials(true) //是否发送cookie
                        .allowedOriginPatterns("*") //放行原始域
                        .allowedMethods(new String[]{"GET","POST"}) //放行请求方式
                        .allowedHeaders("*") //放行请求头
                        .exposedHeaders("*"); //暴露请求头
        }
}
