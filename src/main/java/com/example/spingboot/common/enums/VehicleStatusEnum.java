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
 * @date 2022/3/11 9:10
 */

@Getter
@AllArgsConstructor
public enum  VehicleStatusEnum {
        CVSST("CVSST","在库"),
        CVSSC("CVSSC","顾客销售"),
        CVSSD("CVSSD","转让给其他经销商"),
        CVSDU("CVSDU","样车"),
        CVSMT("CVSMT","修理中"),
        CVSSA("CVSSA","未入库"),
        CVSAU("CVSAU","拍卖"),
        CVSTP("CVSTP","外部保管"),
        CVSIN("CVSIN","公司用车"),
        CVSOT("CVSOT","其他");

        private final String value;
        private final String description;

        public static VehicleStatusEnum getVehicleStatusEnum(String value) {
                for (VehicleStatusEnum e :
                        VehicleStatusEnum.values()) {
                        if (e.getValue().equals(value)) return e;
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
                for (VehicleStatusEnum e : VehicleStatusEnum.values()) {
                        Map<String,Object> map = new HashMap<>();
                        map.put("value",e.getValue());
                        map.put("label",e.getDescription());
                        options.add(map);
                }
                return options;
        }
}
