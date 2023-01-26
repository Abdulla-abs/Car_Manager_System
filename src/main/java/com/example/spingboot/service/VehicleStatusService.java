package com.example.spingboot.service;

import com.example.spingboot.domain.dto.SelectDto;
import com.example.spingboot.domain.entity.VehicleStatus;

import java.util.List;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/4/7 8:33
 */
public interface VehicleStatusService {

        List<SelectDto> listOptions() throws Exception;

        void save(VehicleStatus vehicleStatus) throws Exception;

}
