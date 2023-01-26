package com.example.spingboot.service.impl;

import com.example.spingboot.dao.AuditDetailMapper;
import com.example.spingboot.dao.AuditResultMapper;
import com.example.spingboot.domain.dto.AuditDetailDto;
import com.example.spingboot.domain.dto.AuditDetailReferenceDto;
import com.example.spingboot.domain.entity.AuditDetail;
import com.example.spingboot.domain.entity.AuditDetailWithBLOBs;
import com.example.spingboot.domain.entity.AuditResult;
import com.example.spingboot.domain.vo.AuditDetailVo;
import com.example.spingboot.service.AuditDetailService;
import com.example.spingboot.utils.PaginationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/4/8 9:25
 */
@Service
@Transactional
public class AuditDetailServiceImp implements AuditDetailService {

        @Autowired
        private AuditDetailMapper auditDetailMapper;

        @Autowired
        private AuditResultMapper auditResultMapper;

        @Override
        public void save(AuditDetail auditDetail) throws Exception {
                if (auditDetail.getDetailId() == null) {
                        auditDetailMapper.insertSelective(auditDetail);
                        AuditResult auditResult = new AuditResult();
                        auditResult.setAuditId(auditDetail.getAuditId());
                        auditResult.setDetailId(auditDetail.getDetailId());
                        auditResultMapper.insert(auditResult);
                } else {
                        auditDetailMapper.updateByPrimaryKeySelective(auditDetail);
                }
        }

        @Override
        public void saveOthers(AuditDetailWithBLOBs auditDetailWithBLOBs) throws Exception {
                auditDetailMapper.updateBLOBsByPrimaryKey(auditDetailWithBLOBs);
        }

        @Override
        public PaginationUtil<AuditDetailDto> pageList(AuditDetailVo auditDetailVo) throws Exception {
                PaginationUtil<AuditDetailDto> paginationUtil = null;
                int count = auditDetailMapper.selectCountBySelective(auditDetailVo);
                if (count > 0) {
                        List<AuditDetailDto> auditDetailDtos = auditDetailMapper.selectListBySelective(auditDetailVo);
                        paginationUtil = new PaginationUtil<AuditDetailDto>(auditDetailVo.getPageSize(),auditDetailVo.getCurrentPage(),count,auditDetailDtos);
                }
                return paginationUtil;
        }

        @Override
        public AuditDetailReferenceDto getDetailReferenceById(Integer id) throws Exception {
                return auditDetailMapper.selectReferenceByPrimaryKey(id);
        }
}
