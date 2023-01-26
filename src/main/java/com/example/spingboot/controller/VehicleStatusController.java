package com.example.spingboot.controller;

import com.example.spingboot.domain.dto.SelectDto;
import com.example.spingboot.domain.entity.VehicleStatus;
import com.example.spingboot.domain.vo.ResultVo;
import com.example.spingboot.service.VehicleStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/4/23 14:33
 */

@RestController
@RequestMapping("/vehicleStatus")
public class VehicleStatusController {

        @Autowired
        private VehicleStatusService vehicleStatusService;

        @PostMapping("/save")
        public ResultVo save(@Valid VehicleStatus vehicleStatus) throws Exception {
                vehicleStatusService.save(vehicleStatus);
                return new ResultVo();
        }

        @GetMapping("/listOptions")
        public ResultVo listOptions() throws Exception {
                List<SelectDto> list = vehicleStatusService.listOptions();
                return new ResultVo(list);
        }
}
