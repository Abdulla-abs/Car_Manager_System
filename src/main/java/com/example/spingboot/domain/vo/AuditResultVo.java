package com.example.spingboot.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/3/15 8:56
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuditResultVo extends PageVo  implements Serializable {
        private Integer auditId;

        private Integer detailId;

}
