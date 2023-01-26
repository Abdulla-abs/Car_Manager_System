package com.example.spingboot.dao;

import com.example.spingboot.domain.dto.AuditHeadDto;
import com.example.spingboot.domain.vo.AuditHeadVo;
import com.example.spingboot.domain.entity.AuditHead;
import com.example.spingboot.domain.entity.Dealer;

import java.util.List;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/3/15 9:22
 */
public interface AuditHeadMapper extends BaseDao<AuditHead, AuditHeadVo, AuditHeadDto> {

        String[] selectByPeriodYm(String periodYm) throws Exception;

        Integer[] selectByDealer(List<Dealer> dealers) throws Exception;
}
