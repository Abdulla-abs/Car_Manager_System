package com.example.spingboot.dao;

import com.example.spingboot.domain.dto.SelectDto;
import com.example.spingboot.domain.entity.VehicleStatus;

import java.util.List;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/3/15 10:24
 */
public interface VehicleStatusMapper extends BaseDao<VehicleStatus,VehicleStatus,VehicleStatus> {

        List<SelectDto> selectListOption() throws Exception;
}
