package com.example.spingboot.service;

import com.example.spingboot.domain.dto.AuditHeadDto;
import com.example.spingboot.domain.entity.AuditHead;
import com.example.spingboot.domain.entity.Dealer;
import com.example.spingboot.domain.vo.AuditHeadVo;
import com.example.spingboot.utils.PaginationUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/4/7 8:50
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuditHeaderServiceTest {

        @Autowired
        private AuditHeaderService auditHeaderService;

        @Test
        public void save() throws Exception{
                auditHeaderService.save(new AuditHead(56,"YM","No","000056","abbas",new Date(),"000005",new Date(),"abbas",new Date()));
        }

        @Test
        public void pageList() throws Exception{
                final PaginationUtil<AuditHeadDto> paginationUtil = auditHeaderService.pageList(new AuditHeadVo(null,null,null,"abbas",null,null,null,null,null));
        }

        @Test
        public void listPeriodByPeriodYm() throws Exception{
                String[] strings = auditHeaderService.listPeriodByPeriodYm("2000-01-01");
        }

        @Test
        public void listAuditByDealer() throws Exception{
                List<Dealer> dealers = new ArrayList<>();
                dealers.add(new Dealer("33","abbas","000042"));
                final Integer[] integer = auditHeaderService.listAuditByDealer(dealers);
        }
}
