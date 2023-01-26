package com.example.spingboot.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Master implements Serializable {

        @NotNull(message = "账户ID不能为空")
        @Pattern(regexp = "^(S|V)[0-9]+$",message = "账户ID以大写字母S或V开头和数字组成")
        @Length(min = 5,max = 15,message = "账户ID由5-15个字符组成")
        private String accountId;

        @NotNull(message = "账户密码不能为空")
        @Length(min = 6,max = 16,message = "账户密码由6-16个字符组成")
        private String accountPassword;

        @NotNull(message = "账户类型不能为空")
        private String accountType;

        private String vendorId;

        @NotNull
        @Pattern(regexp = "^[\u4e00-\u9fa5]+$",message = "账户姓名由汉字组成")
        @Length(min = 2,max = 4,message = "账户长度在2-4个字符之内")
        private String accountName;
}
