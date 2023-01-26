package com.example.spingboot.service;

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
 * @date 2022/4/7 8:36
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class VehicleStatusServiceTest {

        @Autowired
        private VehicleStatusService vehicleStatusService;

        @Test
        public void listOptions() throws Exception {
                final List<SelectDto> list = vehicleStatusService.listOptions();
        }

        @Test
        public void save() throws Exception {
                vehicleStatusService.save(new VehicleStatus("25","abbas"));
        }
}
