package com.example.spingboot.service;

import com.example.spingboot.domain.dto.AuditDetailDto;
import com.example.spingboot.domain.dto.AuditDetailReferenceDto;
import com.example.spingboot.domain.entity.AuditDetail;
import com.example.spingboot.domain.entity.AuditDetailWithBLOBs;
import com.example.spingboot.domain.vo.AuditDetailVo;
import com.example.spingboot.utils.PaginationUtil;

/**
 * @description: TODO
 * @date 2022/4/8 9:21
 */
public interface AuditDetailService {

        void save(AuditDetail auditDetail) throws Exception;

        void saveOthers(AuditDetailWithBLOBs auditDetailWithBLOBs) throws Exception;

        PaginationUtil<AuditDetailDto> pageList(AuditDetailVo auditDetailVo) throws Exception;

        AuditDetailReferenceDto getDetailReferenceById(Integer id) throws Exception;

}
