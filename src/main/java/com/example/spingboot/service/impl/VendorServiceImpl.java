package com.example.spingboot.service.impl;

import com.example.spingboot.dao.VendorMapper;
import com.example.spingboot.domain.entity.Vendor;
import com.example.spingboot.domain.vo.PageVo;
import com.example.spingboot.domain.vo.VendorVo;
import com.example.spingboot.service.VendorService;
import com.example.spingboot.utils.PaginationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/4/5 9:18
 */
@Service
@Transactional
public class VendorServiceImpl implements VendorService {

        @Autowired
        private VendorMapper vendorMapper;

        @Override
        public void save(List<Vendor> vendors) throws Exception {
                if (vendors.size() > 1){
                        vendorMapper.insertBatch(vendors);
                }else {
                        vendorMapper.insertSelective(vendors.get(0));
                }
        }

        @Override
        public PaginationUtil<Vendor> pageList(VendorVo vendorVo) throws Exception {
                PaginationUtil<Vendor> paginationUtil = null;
                final int total = vendorMapper.selectCountAll();
                if (total > 0){
                        List<Vendor> vendors = vendorMapper.selectListBySelective(vendorVo);
                        paginationUtil = new PaginationUtil<>(vendorVo.getPageSize(),vendorVo.getCurrentPage(),vendors.size(),vendors);
                }
                return paginationUtil;
        }
}
