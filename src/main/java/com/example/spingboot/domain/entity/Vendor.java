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
 * @date 2022/3/9 17:39
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vendor implements Serializable {

        @NotNull(message = "供应商ID不能为空")
        @Pattern(regexp = "^V[0-9]+",message = "供应商ID以大写字母V开头和数字组成")
        @Length(min = 4,max = 15,message = "供应商ID由4-15位字符组成")
        private String vendorId;

        @Pattern(regexp = "^([\u4e00-\u9fa5]|[A-z])+[\u4e00-\u9fa5A-z0-9]+$",message = "供应商名字由汉字或字母开头和数字组成")
        private String vendorName;

        private  Integer deleteFlag;

        public Vendor(String vendorId, String vendorName) {
                this.vendorId = vendorId;
                this.vendorName = vendorName;
        }
}
