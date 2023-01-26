package com.example.spingboot.domain.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/3/15 8:18
 */
@Data
public class SelectDto implements Serializable {

        private String value;

        private String label;

}
