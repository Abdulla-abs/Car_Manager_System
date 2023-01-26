package com.example.spingboot.utils;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author abbas
 * @description: 对称加密
 * @date 2022/5/14 20:12
 */

@Component
@Data
@ConfigurationProperties(prefix = "aes")
public class AesUtil {

        private String aesKey;

        /**
         * 加密
         * @param content 明文数据
         * @return 加密数据
         */
        public String encrypt(String content){
                if (!StrUtil.isEmpty(content)) {
                        SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES,aesKey.getBytes());
                        String encryptHex = aes.encryptHex(content);
                        return encryptHex;
                }
                return null;
        }

        /**
         * 解密
         * @param encrypt 加密数据
         * @return 解密数据
         */
        public String decrypt(String encrypt){
                if (!StrUtil.isEmpty(encrypt)) {
                     SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES,aesKey.getBytes());
                     String content = aes.decryptStr(encrypt, CharsetUtil.CHARSET_UTF_8);
                     return content;
                }
                return null;
        }

        /**
         * 判断密码是否有效
         * @param context 明文
         * @return 是否有效
         */
        public boolean validityPassword(String context){
                if (context != null && context.indexOf(",")>0 ){
                        int index = context.indexOf(",");

                        try {
                                Long timestamp = Long.parseLong(context.substring(index+1));
                                Long now = System.currentTimeMillis();
                                if (timestamp >= now){
                                        return true;
                                }
                        } catch (NumberFormatException e) {
                                return false;
                        }
                }
                return false;
        }

        /**
         * 获取密码
         * @param content 明文
         * @return 密码
         */
        public String getPassword(String content){
                if (validityPassword(content)) {
                        int index = content.indexOf(",");
                        return content.substring(0,index);
                }
                return null;
        }
}
