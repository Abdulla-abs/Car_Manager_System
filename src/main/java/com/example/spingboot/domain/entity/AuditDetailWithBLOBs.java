package com.example.spingboot.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/3/9 17:55
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuditDetailWithBLOBs implements Serializable {

        private Integer detailId;

        private String frontPhoto;

        private String framePhoto;

        private String leftPhoto;

        private String rightPhoto;
}
