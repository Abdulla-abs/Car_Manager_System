package com.example.spingboot.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/3/15 8:15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageVo {

        private Integer currentPage;

        private Integer pageSize;
}
