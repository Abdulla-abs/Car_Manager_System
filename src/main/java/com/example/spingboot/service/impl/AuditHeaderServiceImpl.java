package com.example.spingboot.service.impl;

import com.example.spingboot.dao.AuditHeadMapper;
import com.example.spingboot.domain.dto.AuditHeadDto;
import com.example.spingboot.domain.entity.AuditHead;
import com.example.spingboot.domain.entity.Dealer;
import com.example.spingboot.domain.vo.AuditHeadVo;
import com.example.spingboot.service.AuditHeaderService;
import com.example.spingboot.utils.PaginationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/4/7 8:44
 */
@Service
@Transactional
public class AuditHeaderServiceImpl implements AuditHeaderService {

        @Autowired
        private AuditHeadMapper auditHeadMapper;

        @Override
        public void save(AuditHead auditHead) throws Exception {
                if (auditHead.getAuditId() == null){
                        auditHeadMapper.insertSelective(auditHead);
                }else {
                        auditHeadMapper.updateByPrimaryKeySelective(auditHead);
                }
        }

        @Override
        public PaginationUtil<AuditHeadDto> pageList(AuditHeadVo auditHeadVo) throws Exception {
                PaginationUtil<AuditHeadDto> paginationUtil = null;
                int count = auditHeadMapper.selectCountBySelective(auditHeadVo);
                if (count > 0){
                        List<AuditHeadDto> auditHeadDtos = auditHeadMapper.selectListBySelective(auditHeadVo);
                        paginationUtil = new PaginationUtil<>(auditHeadVo.getPageSize(),auditHeadVo.getCurrentPage(),count,auditHeadDtos);
                }
                return paginationUtil;
        }

        @Override
        public String[] listPeriodByPeriodYm(String period) throws Exception {
                return auditHeadMapper.selectByPeriodYm(period);
        }

        @Override
        public Integer[] listAuditByDealer(List<Dealer> dealers) throws Exception {
                return auditHeadMapper.selectByDealer(dealers);
        }
}
