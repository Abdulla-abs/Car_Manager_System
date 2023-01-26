package com.example.spingboot.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/3/15 8:45
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuditDetailVo extends PageVo  implements Serializable {
        private Integer[] auditIds;

        private Integer detailId;

        private String maker;

        private String vehicleCategory;

        private String barCode;

        private String vehicleClass;

        private  String vehicleStatus;

        private String auditStatus;

        private String auditorName;

        private Date updateDateFrom;

        private Date updateDateTo;

}
