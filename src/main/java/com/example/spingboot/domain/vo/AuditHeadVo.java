package com.example.spingboot.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/3/15 8:36
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuditHeadVo extends PageVo implements Serializable {

        private String periodYm;

        private String periodNo;

        private String dealerCode;

        private String dealerName;

        private Date updateDateFrom;

        private Date updateDateTo;

        private Date auditDateFrom;

        private Date auditDateTo;

        private Integer auditStatus;
}
