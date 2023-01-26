package com.example.spingboot.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

/**
 * @author abbas
 * @description: redis工具类
 * @date 2022/5/14 14:57
 */

@Component
public class RedisUtil {

        @Autowired
        private RedisTemplate<String,String> strRedisTemplate;

        @Autowired
        private RedisTemplate<Object,Object> redisTemplate;

        /**
         * 缓存token
         * @param key ?
         * @param token ?
         */
        public void save(String key,String token){
                key += "_token";
                strRedisTemplate.opsForValue().set(key,token);
        }

        /**
         * 缓存token
         * @param key ?
         * @param authentication ?
         */
        public void save(String key, Authentication authentication){
                redisTemplate.opsForValue().set(key,authentication);
        }

        /**
         * 拿token
         * @param key ?
         * @return ?
         */
        public String getToken(String key){
                key += "_token";
                return strRedisTemplate.opsForValue().get(key);
        }

        /**
         * 拿身份
         * @param key ?
         * @return ?
         */
        public Authentication getAuthentication(String key){
                return (Authentication) redisTemplate.opsForValue().get(key);
        }

        /**
         * 删
         * @param key ?
         */
        public void delete(String key){
                redisTemplate.delete(key);
                strRedisTemplate.delete(key);
        }

        ////////////////////////////////////////////////////aes加密/////////////////////////////////

        /**
         * 缓存密码
         * @param key
         * @param password
         */
        public void setPassword(String key,String password){
                key += "_password";
                strRedisTemplate.opsForValue().set(key,password);
        }

        /**
         * 获取密码
         * @param key
         * @return
         */
        public String getPassword(String key){
                key += "_password";
                return strRedisTemplate.opsForValue().get(key);
        }

}
