package com.example.spingboot.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/3/9 17:46
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuditDetail implements Serializable {
        private Integer detailId;

        @NotNull(message = "检查ID不能为空")
        private Integer auditId;

        @NotNull(message = "厂商不能为空")
        @Length(min = 4,max = 20,message = "厂商由4-20位字符组成")
        private String maker;

        @NotNull(message = "车型不能为空")
        @Pattern(regexp = "^[A-Z0-9]{2,20}$",message = "车型由2-20位大写字母和数字组成")
        private String vehicleCategory;

        @NotNull(message = "条码不能为空")
        @Pattern(regexp = "^[A-Z0-9]{8}$",message = "条码由8位大写字母和数字组成")
        private String barCode;

        @NotNull(message = "车辆颜色不能为空")
        private String color;

        @NotNull(message = "车辆区分不能为空")
        private String vehicleClass;

        @NotNull(message = "牌照不能为空")
        @Pattern(regexp = "^[\u4e00-\u9fa5][A-Z0-9]{6}$",message = "行驶证由8-50位大写字母和数字组成")
        private String numberPlate;

        @NotNull(message = "车辆状况不能为空")
        private String vehicleInspection;

        private String vehicleStatus;

}
