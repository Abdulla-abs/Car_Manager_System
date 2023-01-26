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
 * @date 2022/3/9 17:57
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dealer implements Serializable {

        @NotNull(message = "经销商代码不为空")
        @Pattern(regexp = "^[0-9]{5}+$",message = "经销商代码由五位数字组成")
        private String dealerCode;

        @NotNull(message = "经销商名字不能为空")
        @Pattern(regexp = "^([\u4e00-\u9fa5]|[A-Z])+[\u4e00-\u9fa5A-z0-9]+$",
        message = "经销商名称由汉族或字母开头和数字组成")
        private String dealerName;

        @NotNull(message = "供应商ID不能为空")
        private String vendorId;

        private Integer deleteFlag;

        public Dealer(String dealerCode, String dealerName, String vendorId) {
                this.dealerCode = dealerCode;
                this.dealerName = dealerName;
                this.vendorId = vendorId;
        }
}
