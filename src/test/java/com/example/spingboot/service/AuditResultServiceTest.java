package com.example.spingboot.service;

import com.example.spingboot.domain.dto.AuditResultDto;
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
 * @date 2022/4/11 21:36
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AuditResultServiceTest {

        @Autowired
        private AuditResultService auditResultService;

        @Test
        public void getById() throws Exception {
                AuditResultDto byId = auditResultService.getById(new AuditResultVo(null, 2));
        }

        @Test
        public void update() throws Exception {
                auditResultService.update(new AuditResult(1,1,new Date(),1,1,"1","test",1));
        }
}
