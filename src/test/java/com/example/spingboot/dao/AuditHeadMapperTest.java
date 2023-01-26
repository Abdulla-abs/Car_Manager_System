package com.example.spingboot.dao;

import com.example.spingboot.domain.entity.AuditHead;
import com.example.spingboot.domain.entity.Dealer;
import com.example.spingboot.domain.vo.AuditHeadVo;
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
 * @date 2022/3/30 19:07
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AuditHeadMapperTest {

        @Autowired
        private AuditHeadMapper auditHeadMapper;

        @Test
        public void selectByPeriodYm() throws Exception {
                String[] s = auditHeadMapper.selectByPeriodYm("200111");
        }
        @Test
        public void selectByDealer() throws Exception {
                List<Dealer> dealers = new ArrayList<>();
                Dealer dealer = new Dealer("1111",null,null,null);
                dealers.add(dealer);
                auditHeadMapper.selectByDealer(dealers);
        }
        @Test//ok
        public void insertSelective() throws Exception {
                AuditHead auditHead = new AuditHead(1,"200111","44","1111","jia",new Date(),"1311",new Date(),"64666",new Date());
                auditHeadMapper.insertSelective(auditHead);
        }

        @Test//ok
        public void updateByPrimaryKeySelective() throws Exception {
                AuditHead auditHead = new AuditHead(1,"200111","44","1111","new",new Date(),"1311",new Date(),"64666",new Date());
                auditHeadMapper.updateByPrimaryKeySelective(auditHead);
        }

        @Test
        public void selectListBySelective() throws Exception {
                AuditHeadVo auditHeadVo = new AuditHeadVo("200111",null,null,null,null,null,null,null,null);
                auditHeadMapper.selectListBySelective(auditHeadVo);
        }

        @Test
        public void selectCountBySelective() throws Exception {
                AuditHeadVo auditHeadVo = new AuditHeadVo(null,null,"1111",null,null,null,null,null,null);
                auditHeadMapper.selectCountBySelective(auditHeadVo);
        }
}
