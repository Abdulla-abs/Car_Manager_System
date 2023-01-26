package com.example.spingboot.service;

import com.example.spingboot.domain.dto.AuditHeadDto;
import com.example.spingboot.domain.entity.AuditHead;
import com.example.spingboot.domain.entity.Dealer;
import com.example.spingboot.domain.vo.AuditHeadVo;
import com.example.spingboot.utils.PaginationUtil;

import java.util.List;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/4/7 8:40
 */
public interface AuditHeaderService {

        void save(AuditHead auditHead) throws Exception;

        PaginationUtil<AuditHeadDto> pageList(AuditHeadVo auditHeadVo) throws Exception;

        String[] listPeriodByPeriodYm(String period) throws Exception;

        Integer[] listAuditByDealer(List<Dealer> dealers) throws Exception;
        
}
