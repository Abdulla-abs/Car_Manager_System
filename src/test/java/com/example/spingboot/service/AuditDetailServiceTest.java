package com.example.spingboot.service;

import com.example.spingboot.domain.dto.AuditDetailReferenceDto;
import com.example.spingboot.domain.entity.AuditDetail;
import com.example.spingboot.domain.entity.AuditDetailWithBLOBs;
import com.example.spingboot.domain.vo.AuditDetailVo;
import com.example.spingboot.domain.vo.PageVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/4/10 14:54
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AuditDetailServiceTest {

        @Autowired
        private AuditDetailService auditDetailService;

        @Test
        public void save() throws Exception {
                auditDetailService.save(new AuditDetail(null,1,"车厂","H01","11122","黑色","N","GAK2002","111111","CVSIN"));
        }

        @Test
        public void saveOthers() throws Exception {
                auditDetailService.saveOthers(new AuditDetailWithBLOBs(2,"path","path","path","path"));
        }

        @Test
        public void pageList() throws Exception {
                AuditDetailVo auditDetailVo = new AuditDetailVo();
                auditDetailVo.setPageSize(1);
                auditDetailVo.setCurrentPage(1);
                auditDetailService.pageList(auditDetailVo);
        }
        
        @Test
        public void getDetailReferenceById() throws Exception {
                final AuditDetailReferenceDto detailReferenceById = auditDetailService.getDetailReferenceById(2);
        }
}
