package com.example.spingboot.service.impl;

import com.example.spingboot.dao.DealerMapper;
import com.example.spingboot.domain.entity.Dealer;
import com.example.spingboot.domain.vo.DealerVo;
import com.example.spingboot.domain.vo.PageVo;
import com.example.spingboot.service.DealerService;
import com.example.spingboot.utils.PaginationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/4/7 8:15
 */
@Service
@Transactional
public class DealerServiceImpl implements DealerService {

        @Autowired
        private DealerMapper dealerMapper;


        @Override
        public void save(List<Dealer> dealers) throws Exception {
                if (dealers.size() > 1){
                        dealerMapper.insertBatch(dealers);
                }else {
                        dealerMapper.insertSelective(dealers.get(0));
                }
        }

        @Override
        public PaginationUtil<Dealer> pageList(DealerVo dealerVo) throws Exception {
                PaginationUtil<Dealer> paginationUtil = null;
                int count = dealerMapper.selectCountBySelective(dealerVo);
                if (count > 0){
                        List<Dealer> dealers = dealerMapper.selectListBySelective(dealerVo);
                        paginationUtil = new PaginationUtil<>(dealerVo.getPageSize(),dealerVo.getCurrentPage(),count,dealers);
                }
                return paginationUtil;
        }

        @Override
        public List<Dealer> findByVendorId(String id) throws Exception {
                return dealerMapper.selectListByVendorId(id);
        }

        @Override
        public List<Dealer> findByVendorId(Integer id) throws Exception {
                return dealerMapper.selectListByVendorId(id);
        }
}
