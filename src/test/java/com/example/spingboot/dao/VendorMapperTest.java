package com.example.spingboot.dao;

import com.example.spingboot.domain.entity.Vendor;
import com.example.spingboot.domain.vo.VendorVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/3/25 16:41
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class VendorMapperTest {

        @Autowired
        private VendorMapper vendorMapper;

        //单个插入测试
        @Test
        public void insert() throws Exception {
                Vendor vendor = new Vendor();
                vendor.setVendorName("vendor1");
                vendor.setVendorId("000008");
                vendorMapper.insert(vendor);
        }

        //单个插入部分不完整
        @Test
        public void insertSelective() throws Exception {
                Vendor vendor = new Vendor();
                vendor.setVendorId("000002");
                vendor.setVendorName("vendor2");
                vendorMapper.insertSelective(vendor);
        }

        //批量插入
        @Test
        public void insertBatch() throws Exception {
                Vendor vendor = new Vendor("000003","vendor",0);
                Vendor vendor2 = new Vendor("000004","vendor",0);
                Vendor vendor3 = new Vendor("000005","vendor",0);
                List<Vendor> vendors = new ArrayList<>();
                vendors.add(vendor);
                vendors.add(vendor2);
                vendors.add(vendor3);
                vendorMapper.insertBatch(vendors);
        }

        //根据主键更新
        @Test
        public void updateByPrimaryKey() throws Exception {
                Vendor vendor3 = new Vendor("000005","newVendor",0);
                vendorMapper.updateByPrimaryKey(vendor3);
        }

        //主键更新部分
        @Test
        public void updateByPrimaryKeySelective() throws Exception {
                Vendor vendor = new Vendor();
                vendor.setVendorId("000005");
                vendor.setVendorName("newVendor2");
                vendorMapper.updateByPrimaryKeySelective(vendor);
        }

        //批量更新
        @Test
        public void updateBatch() throws Exception {
                Vendor vendor = new Vendor("000003","NewVendor",0);
                Vendor vendor2 = new Vendor("000004","NewVendor",0);
                Vendor vendor3 = new Vendor("000005","NewVendor",0);
                List<Vendor> vendors = new ArrayList<>();
                vendors.add(vendor);
                vendors.add(vendor2);
                vendors.add(vendor3);
                vendorMapper.updateBatch(vendors);
        }

        //单个删除
        @Test
        public void deleteByPrimaryKey() throws Exception {
//                vendorMapper.deleteByPrimaryKey("000005");
                vendorMapper.deleteByPrimaryKey(5);
        }

        //批量删除
        @Test
        public void deleteBatch() throws Exception {
                Integer[] array = new Integer[]{5,3};
                vendorMapper.deleteBatch(array);
        }

        //根据主键查找
        @Test
        public void selectByPrimaryKey() throws Exception {
                vendorMapper.selectByPrimaryKey(5);
        }

        //分页查找全部
        @Test
        public void selectListAll() throws Exception {
                VendorVo vendorVo = new VendorVo();
                vendorVo.setCurrentPage(2);
                vendorVo.setPageSize(5);
                List<Vendor> vendors = vendorMapper.selectListAll(vendorVo);
        }

        @Test
        public void selectCount() throws Exception {
                int count = vendorMapper.selectCountAll();
        }

        @Test
        public void selectListBySelective() throws Exception {
                VendorVo vendorVo = new VendorVo();
                vendorVo.setVendorName("vendor");
                vendorVo.setPageSize(8);
                vendorVo.setCurrentPage(1);
                List<Vendor> vendors = vendorMapper.selectListBySelective(vendorVo);
        }
}
