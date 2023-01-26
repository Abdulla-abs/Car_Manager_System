package com.example.spingboot.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/3/9 18:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuditResult implements Serializable {

        private Integer auditId;

        private Integer detailId;

        private Date auditDate;

        @NotNull(message = "判定状态不能为空")
        private Integer auditStatus;

        @NotNull(message = "判定备注不能为空")
        @Length(min = 10,max = 200,message = "判定备注由10-200位字符组成")
        private Integer auditComment;

        private String auditorId;

        private String auditorName;

        private Integer auditVersion;
}
