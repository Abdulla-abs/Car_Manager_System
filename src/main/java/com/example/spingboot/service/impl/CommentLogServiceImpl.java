package com.example.spingboot.service.impl;

import com.example.spingboot.dao.CommentLogMapper;
import com.example.spingboot.domain.entity.CommentLog;
import com.example.spingboot.domain.vo.CommentLogVo;
import com.example.spingboot.service.CommentLogService;
import com.example.spingboot.utils.PaginationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/4/7 18:13
 */
@Service
@Transactional
public class CommentLogServiceImpl implements CommentLogService {

        @Autowired
        private CommentLogMapper commentLogMapper;

        @Override
        public void save(CommentLog commentLog) throws Exception {
                commentLogMapper.insert(commentLog);
        }

        @Override
        public PaginationUtil<CommentLog> pageList(CommentLogVo commentLogVo) throws Exception {
                PaginationUtil<CommentLog> paginationUtil = null;
                int count = commentLogMapper.selectCountBySelective(commentLogVo);
                if (count>0) {
                        List<CommentLog> commentLogs = commentLogMapper.selectListBySelective(commentLogVo);
                        paginationUtil = new PaginationUtil<>(commentLogVo.getPageSize(),commentLogVo.getCurrentPage(),count,commentLogs);
                }
                return paginationUtil;
        }

        @Override
        public void delete(Integer[] logIdArrays) throws Exception {
                if (logIdArrays.length > 1) {
                        commentLogMapper.deleteBatch(logIdArrays);
                }else {
                        commentLogMapper.deleteByPrimaryKey(logIdArrays[0]);
                }
        }
}
