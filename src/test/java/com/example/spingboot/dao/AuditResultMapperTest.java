package com.example.spingboot.dao;

import com.example.spingboot.domain.entity.AuditResult;
import com.example.spingboot.domain.vo.AuditResultVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/3/30 22:55
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuditResultMapperTest {

        @Autowired
        private AuditResultMapper auditResultMapper;

        @Test
        public void selectByPrimaryKey() throws Exception {
                AuditResultVo auditResultVo = new AuditResultVo();
                auditResultVo.setAuditId(1);
                auditResultVo.setDetailId(1);
                auditResultMapper.selectByPrimaryKey(auditResultVo);
        }

        @Test
        public void insert() throws Exception {
                AuditResult auditResult = new AuditResult(1,1,new Date(),1,1,"a","a",1);
                auditResultMapper.insert(auditResult);
        }

        @Test
        public void updateByPrimaryKeySelective() throws Exception {
                AuditResult auditResult = new AuditResult(1,1,new Date(),1,1,"a","a",1);
                auditResultMapper.updateByPrimaryKeySelective(auditResult);
        }
}
