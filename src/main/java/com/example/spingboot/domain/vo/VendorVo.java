package com.example.spingboot.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/3/15 8:26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendorVo extends PageVo implements Serializable {

        private String vendorId;

        private String vendorName;


}
