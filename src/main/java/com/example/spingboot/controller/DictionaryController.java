package com.example.spingboot.controller;

import com.example.spingboot.common.enums.AuditResultEnum;
import com.example.spingboot.common.enums.VehicleClassEnum;
import com.example.spingboot.common.enums.VehicleStatusEnum;
import com.example.spingboot.domain.vo.ResultVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/4/24 22:47
 */

@RestController
@RequestMapping("/dict")
public class DictionaryController {

        @GetMapping("/listOptions/{key}")
        public ResultVo listOptions(@PathVariable String key){
                Object data = null;
                if (key.equals("AuditResult")) {
                        data = AuditResultEnum.toDictionary();
                }else if (key.equals("VehicleStatus")){
                        data = VehicleStatusEnum.toDictionary();
                }else if (key.equals("VehicleClass")){
                        data = VehicleClassEnum.toDictionary();
                }

                return new ResultVo(data);
        }
}
