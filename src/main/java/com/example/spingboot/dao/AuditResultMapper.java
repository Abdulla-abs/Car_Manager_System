package com.example.spingboot.dao;

import com.example.spingboot.domain.dto.AuditResultDto;
import com.example.spingboot.domain.vo.AuditResultVo;
import com.example.spingboot.domain.entity.AuditResult;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/3/15 9:31
 */
public interface AuditResultMapper extends BaseDao<AuditResult, AuditResultVo, AuditResultDto> {

        AuditResultDto selectByPrimaryKey(AuditResultVo keys) throws Exception;
}
