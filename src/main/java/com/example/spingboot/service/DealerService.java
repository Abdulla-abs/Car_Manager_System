package com.example.spingboot.service;

import com.example.spingboot.domain.entity.Dealer;
import com.example.spingboot.domain.vo.DealerVo;
import com.example.spingboot.domain.vo.PageVo;
import com.example.spingboot.utils.PaginationUtil;

import java.util.List;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/4/7 8:11
 */
public interface DealerService {

        void save(List<Dealer> dealers) throws Exception;

        PaginationUtil<Dealer> pageList(DealerVo dealerVo) throws Exception;

        List<Dealer> findByVendorId(String id) throws Exception;

        List<Dealer> findByVendorId(Integer id) throws Exception;

}
