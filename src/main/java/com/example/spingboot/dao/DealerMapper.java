package com.example.spingboot.dao;

import com.example.spingboot.domain.vo.DealerVo;
import com.example.spingboot.domain.entity.Dealer;

import java.util.List;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/3/15 9:22
 */
public interface DealerMapper extends BaseDao<Dealer, DealerVo,Dealer> {

        List<Dealer> selectListByVendorId(String vendorId) throws Exception;

        List<Dealer> selectListByVendorId(Integer vendorId) throws Exception;
}
