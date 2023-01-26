package com.example.spingboot.service.impl;

import com.example.spingboot.dao.VehicleStatusMapper;
import com.example.spingboot.domain.dto.SelectDto;
import com.example.spingboot.domain.entity.VehicleStatus;
import com.example.spingboot.service.VehicleStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/4/7 8:35
 */
@Service
@Transactional
public class VehicleStatusServiceImpl implements VehicleStatusService {

        @Autowired
        private VehicleStatusMapper vehicleStatusMapper;

        @Override
        public List<SelectDto> listOptions() throws Exception {
                return vehicleStatusMapper.selectListOption();
        }

        @Override
        public void save(VehicleStatus vehicleStatus) throws Exception {
                vehicleStatusMapper.insert(vehicleStatus);
        }
}
