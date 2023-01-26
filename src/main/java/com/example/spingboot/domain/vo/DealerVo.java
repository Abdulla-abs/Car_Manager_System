package com.example.spingboot.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/3/15 8:28
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DealerVo extends PageVo  implements Serializable {

        private String dealerCode;

        private String dealerName;
}
