package com.example.spingboot.service;

import com.example.spingboot.domain.dto.MasterDto;
import com.example.spingboot.domain.entity.Master;
import com.example.spingboot.domain.vo.PageVo;
import com.example.spingboot.utils.PaginationUtil;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/4/5 8:55
 */
public interface MasterService {

        void save(Master master) throws Exception;

        void delete(String id) throws Exception;

        void update(Master master) throws Exception;

        MasterDto findById(String id) throws Exception;

        PaginationUtil<Master> queryList(PageVo pageVo) throws Exception;

}
