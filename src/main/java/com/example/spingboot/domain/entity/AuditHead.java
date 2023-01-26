package com.example.spingboot.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/3/9 17:41
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuditHead implements Serializable {
        private Integer auditId;

        @NotNull(message = "检查年月不能为空")
        @Pattern(regexp = "^[0-9]{6}$",message = "检查的年月格式为YYYY MM")
        private String periodYm;

        @NotNull(message = "检查编号不能为空")
        @Pattern(regexp = "^[0-9]{2}$",message = "检查编号为2位数字")
        private String periodNo;

        @NotNull(message = "经销商代码不能为空")
        private String dealerCode;

        private String dealerName;

        @NotNull(message = "合格判断日期不能为空")
        private Date judgeDate;

        private String insertUser;

        private Date insertDate;

        private String updateUser;

        private Date updateDate;
}
