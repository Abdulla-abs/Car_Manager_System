package com.example.spingboot.domain.dto;

import com.example.spingboot.common.enums.AuditResultEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/3/15 8:41
 */
@Data
public class AuditHeadDto implements Serializable {

        private Integer auditId;

        private String periodYm;

        private String periodNo;

        private String dealerCode;

        private String dealerName;

        private Date judgeDate;

        private AuditResultEnum auditStatus;

        private Date auditDate;

        private Date insertDate;

        private Date updateDate;
}
