package com.example.spingboot.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/3/9 18:03
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleStatus implements Serializable {

        @NotNull(message = "车辆状况编号不为空")
        @Pattern(regexp = "^[A-Z]{5}$",message = "车辆状况编号由5位大写字母组成")
        private String vehicleStatusCode;

        @NotNull(message = "车辆状况名称不为空")
        @Pattern(regexp = "^[\u4e00-\u9fa5]{2,20}$",message = "车辆状况名称由2-20位汉族组成")
        private String vehicleStatusName;
}
