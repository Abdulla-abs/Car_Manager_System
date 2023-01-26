package com.example.spingboot.service;

import com.example.spingboot.domain.entity.CommentLog;
import com.example.spingboot.domain.vo.CommentLogVo;
import com.example.spingboot.utils.PaginationUtil;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/4/7 18:09
 */
public interface CommentLogService {

        void save(CommentLog commentLog) throws Exception;

        PaginationUtil<CommentLog> pageList(CommentLogVo commentLogVo) throws Exception;

        /**
         * @param logIdArrays
         * @throws Exception
         */
        void delete(Integer[] logIdArrays) throws Exception;

}
