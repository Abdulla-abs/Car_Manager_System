package com.example.spingboot.service.impl;

import com.example.spingboot.dao.MasterMapper;
import com.example.spingboot.domain.dto.MasterDto;
import com.example.spingboot.domain.entity.Master;
import com.example.spingboot.domain.vo.PageVo;
import com.example.spingboot.service.MasterService;
import com.example.spingboot.utils.PaginationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/4/5 8:59
 */
@Service
@Transactional
public class MasterServiceImpl implements MasterService {

        @Autowired
        private MasterMapper masterMapper;


        @Override
        public void save(Master master) throws Exception {
                masterMapper.insertSelective(master);
        }

        @Override
        public void delete(String id) throws Exception {
                masterMapper.deleteByPrimaryKey(id);
        }

        @Override
        public void update(Master master) throws Exception {
                masterMapper.updateByPrimaryKeySelective(master);
        }

        @Override
        public MasterDto findById(String id) throws Exception {
                return masterMapper.selectByPrimaryKey(id);
        }

        @Override
        public PaginationUtil<Master> queryList(PageVo pageVo) throws Exception {
                PaginationUtil<Master> paginationUtil = null;
                final int total = masterMapper.selectCountAll();
                if (total > 0){
                        List<Master> data = masterMapper.selectListAll(pageVo);
                        paginationUtil = new PaginationUtil<>(pageVo.getPageSize(),pageVo.getCurrentPage(),total,data);
                }
                return paginationUtil;
        }
}
