package com.example.spingboot.domain.dto;

import com.example.spingboot.common.enums.AuditResultEnum;
import com.example.spingboot.common.enums.VehicleClassEnum;
import com.example.spingboot.common.enums.VehicleStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/3/15 8:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuditDetailDto implements Serializable {
        private Integer detailId;

        private Integer auditId;

        private String maker;

        private String vehicleCategory;

        private String barCode;

        private VehicleClassEnum vehicleClass;

        private VehicleStatusEnum vehicleStatus;

        private AuditResultEnum auditStatus;

        private String auditorName;

        private Date updateDate;

}
