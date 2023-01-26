package com.example.spingboot.common.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public enum VehicleClassEnum {
        NEW("N","新车"),
        SECOND_HAND("O","二手车");

        private final String value;
        private final String description;

        public static VehicleClassEnum getVehicleClassEnum(String value) {
                for (VehicleClassEnum e :
                        VehicleClassEnum.values()) {
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
                for (VehicleClassEnum e : VehicleClassEnum.values()) {
                        Map<String,Object> map = new HashMap<>();
                        map.put("value",e.getValue());
                        map.put("label",e.getDescription());
                        options.add(map);
                }
                return options;
        }
}
