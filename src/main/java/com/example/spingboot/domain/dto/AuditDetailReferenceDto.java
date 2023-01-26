package com.example.spingboot.domain.dto;

import com.example.spingboot.domain.entity.AuditDetailWithBLOBs;
import lombok.Data;

import java.io.Serializable;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/3/15 8:54
 */
@Data
public class AuditDetailReferenceDto extends AuditDetailWithBLOBs implements Serializable {

        private String numberPlate;

        private String vehicleInspection;

        private String color;

}
