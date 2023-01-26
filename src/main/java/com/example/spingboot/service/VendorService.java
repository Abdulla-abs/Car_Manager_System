package com.example.spingboot.service;

import com.example.spingboot.domain.entity.Vendor;
import com.example.spingboot.domain.vo.PageVo;
import com.example.spingboot.domain.vo.VendorVo;
import com.example.spingboot.utils.PaginationUtil;

import java.util.List;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/4/5 9:17
 */
public interface VendorService {

        void save(List<Vendor> vendors) throws Exception;

        PaginationUtil<Vendor> pageList(VendorVo vendorVo) throws Exception;

}
