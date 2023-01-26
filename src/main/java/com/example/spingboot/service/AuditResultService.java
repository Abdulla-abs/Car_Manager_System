package com.example.spingboot.service;

import com.example.spingboot.domain.dto.AuditResultDto;
import com.example.spingboot.domain.entity.AuditResult;
import com.example.spingboot.domain.vo.AuditResultVo;
import org.springframework.stereotype.Service;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/4/11 21:32
 */
public interface AuditResultService {

        AuditResultDto getById(AuditResultVo auditResultVo) throws Exception;

        void update(AuditResult auditResult) throws Exception;
}
