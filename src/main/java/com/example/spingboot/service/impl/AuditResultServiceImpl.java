package com.example.spingboot.service.impl;

import com.example.spingboot.dao.AuditResultMapper;
import com.example.spingboot.domain.dto.AuditResultDto;
import com.example.spingboot.domain.entity.AuditResult;
import com.example.spingboot.domain.vo.AuditResultVo;
import com.example.spingboot.service.AuditResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/4/11 21:34
 */
@Service
@Transactional
public class AuditResultServiceImpl implements AuditResultService {

        @Autowired
        private AuditResultMapper auditResultMapper;

        @Override
        public AuditResultDto getById(AuditResultVo auditResultVo) throws Exception {
                return auditResultMapper.selectByPrimaryKey(auditResultVo);
        }

        @Override
        public void update(AuditResult auditResult) throws Exception {
                auditResult.setAuditVersion(auditResult.getAuditVersion()+1);
                auditResultMapper.updateByPrimaryKeySelective(auditResult);
        }
}
