package com.example.spingboot.service;

import com.example.spingboot.dao.VendorMapper;
import com.example.spingboot.domain.entity.Vendor;
import com.example.spingboot.domain.vo.PageVo;
import com.example.spingboot.domain.vo.VendorVo;
import com.example.spingboot.utils.PaginationUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/4/5 9:21
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class VendorServiceTest {

        @Autowired
        private VendorService vendorService;

//        @Test
//        public void save() throws Exception {
//                Vendor vendor = new Vendor("000005","Hello");
//                vendorService.save(vendor);
//        }

        @Test
        public void saveList() throws Exception {
                List<Vendor> vendors = new ArrayList<>();
                Vendor vendor = new Vendor("000011","Hello");
                Vendor vendor1 = new Vendor("000012","Hello");
                Vendor vendor2 = new Vendor("000013","Hello");
                vendors.add(vendor);
                vendors.add(vendor1);
                vendors.add(vendor2);
                vendorService.save(vendors);
        }

        @Test
        public void pageList() throws Exception {
                VendorVo vendorVo = new VendorVo();
                vendorVo.setCurrentPage(1);
                vendorVo.setPageSize(2);
                vendorVo.setVendorName("Hello");
                final PaginationUtil<Vendor> paginationUtil = vendorService.pageList(vendorVo);
        }


}
