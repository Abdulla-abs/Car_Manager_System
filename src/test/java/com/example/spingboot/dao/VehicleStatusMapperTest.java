package com.example.spingboot.dao;

import com.example.spingboot.domain.dto.SelectDto;
import com.example.spingboot.domain.entity.VehicleStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/3/30 18:15
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class VehicleStatusMapperTest {

        @Autowired
        private VehicleStatusMapper vehicleStatusMapper;

        @Test
        public void selectListOption() throws Exception {
                List<SelectDto> list = vehicleStatusMapper.selectListOption();
        }

        @Test
        public void insert() throws Exception {
                VehicleStatus vehicleStatus = new VehicleStatus("CVSST","在库");
                vehicleStatusMapper.insert(vehicleStatus);
        }
}
