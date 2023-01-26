package com.example.spingboot.domain.dto;

import com.example.spingboot.common.enums.AuditResultEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/3/15 8:57
 */
@Data
public class AuditResultDto implements Serializable {
        private Date auditDate;

        private AuditResultEnum auditStatus;

        private String auditComment;

        private String auditName;

        private Integer auditVersion;


}
