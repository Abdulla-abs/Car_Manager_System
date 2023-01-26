package com.example.spingboot.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/4/5 8:48
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginationUtil<T> {

        private Integer pageSize;
        private Integer currentPage;
        private Integer total;
        private List<T> data;
}
