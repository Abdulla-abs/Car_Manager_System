package com.example.spingboot.common.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/4/14 19:45
 */
@Getter
@AllArgsConstructor
public enum  ResultStatusEnum {
        SUCCESS(1000,"操作成功"),
        FAILED(1001,"接口错误"),
        VALIDATE_FAILED(1002,"参数校验失败"),
        ERROR(1003,"未知错误"),
        NOT_FOUND(1004,"数据未找到"),
        FILE_SIZE_OVERFLOW(1005,"文件过大"),
        REQUEST_TYPE_NOT_SUPPORT(1006,"请求方式错误"),
        USER_NOT_EXIST(2000,"用户不存在"),
        USER_LOGIN_FAILED(2001,"用户名或密码错误"),
        USER_NOT_LOGIN(2002,"用户还未登录"),
        NO_PERMISSION(2003,"权限不足");

        private final Integer value;
        private final String description;

        public static ResultStatusEnum getResultStatusEnum(String value){
                for (ResultStatusEnum resultStatusEnum : ResultStatusEnum.values()) {
                        if (resultStatusEnum.getValue().equals(value)) {
                                return resultStatusEnum;
                        }
                }
                return null;
        }

        @JsonValue
        public Map<String,Object> toJson(){
                Map<String,Object> m = new HashMap<>();
                m.put("value",getValue());
                m.put("description",getDescription());
                return m;
        }

        public static List<Map<String,Object>> toDictionary(){
                List<Map<String,Object>> options = new ArrayList<>();
                for (ResultStatusEnum e : ResultStatusEnum.values()) {
                        Map<String,Object> map = new HashMap<>();
                        map.put("value",e.getValue());
                        map.put("label",e.getDescription());
                        options.add(map);
                }
                return options;
        }
}
