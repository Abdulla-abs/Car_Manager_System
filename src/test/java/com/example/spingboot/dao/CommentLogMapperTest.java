package com.example.spingboot.dao;

import com.example.spingboot.domain.entity.CommentLog;
import com.example.spingboot.domain.vo.CommentLogVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/3/30 16:43
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentLogMapperTest {

        private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        @Autowired
        private CommentLogMapper commentLogMapper;

        @Test//ok
        public void selectListBySelective() throws Exception {
                CommentLogVo commentLogVo = new CommentLogVo(simpleDateFormat.parse("2000-11-17 12:00:00"),null);
                List<CommentLog> list = commentLogMapper.selectListBySelective(commentLogVo);
        }

        @Test//ok
        public void selectCountBySelective() throws Exception {
                CommentLogVo commentLogVo = new CommentLogVo(simpleDateFormat.parse("2000-11-17 12:00:00"),null);
                int count = commentLogMapper.selectCountBySelective(commentLogVo);
        }

        @Test//ok
        public void insert() throws Exception {
                CommentLog commentLog = new CommentLog(1,simpleDateFormat.parse("2001-11-17 12:00:00"),"Test","000001");
                commentLogMapper.insert(commentLog);
        }

        @Test
        public void deleteByPrimaryKey() throws Exception {
                commentLogMapper.deleteByPrimaryKey(1);
        }

        @Test
        public void deleteBatch() throws Exception {
                Integer[] array = new Integer[]{1};
                commentLogMapper.deleteBatch(array);
        }
}
