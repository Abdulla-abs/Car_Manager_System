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
public enum AuditResultEnum {
        UNIMPLEMENTED(0,"未实施"),
        BACK(1,"退回"),
        QUALIFIED(2,"合格"),
        UNQUALIFIED(3,"不合格");

        private final Integer value;
        private final String description;

        public static AuditResultEnum getAuditResultEnum(Integer value) {
                for (AuditResultEnum e :
                        AuditResultEnum.values()) {
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
                for (AuditResultEnum e : AuditResultEnum.values()) {
                        Map<String,Object> map = new HashMap<>();
                        map.put("value",e.getValue());
                        map.put("label",e.getDescription());
                        options.add(map);
                }
                return options;
        }
}
