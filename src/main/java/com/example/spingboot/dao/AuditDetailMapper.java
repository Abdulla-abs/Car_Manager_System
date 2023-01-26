package com.example.spingboot.dao;

import com.example.spingboot.domain.dto.AuditDetailDto;
import com.example.spingboot.domain.dto.AuditDetailReferenceDto;
import com.example.spingboot.domain.vo.AuditDetailVo;
import com.example.spingboot.domain.entity.AuditDetail;
import com.example.spingboot.domain.entity.AuditDetailWithBLOBs;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/3/15 9:27
 */
public interface AuditDetailMapper extends BaseDao<AuditDetail, AuditDetailVo, AuditDetailDto> {

        void updateBLOBsByPrimaryKey(AuditDetailWithBLOBs auditDetailWithBLOBs) throws Exception;

        AuditDetailReferenceDto selectReferenceByPrimaryKey(Integer id) throws Exception;

}
