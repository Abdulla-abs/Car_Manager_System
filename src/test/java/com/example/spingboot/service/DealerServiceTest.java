package com.example.spingboot.service;

import com.example.spingboot.domain.entity.Dealer;
import com.example.spingboot.domain.vo.DealerVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/4/7 8:23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DealerServiceTest {

        @Autowired
        private DealerService dealerService;

        //TODO: 此方法已弃用
//        @Test
//        public void save() throws Exception {
//                Dealer dealer = new Dealer("69","abbas","000003");
//                dealerService.save(dealer);
//        }

        @Test
        public void saveList() throws Exception {
                List<Dealer> dealerList = new ArrayList<>();
                Dealer dealer = new Dealer("65","abbas","000003");
                Dealer dealer1 = new Dealer("66","abbas","000003");
                Dealer dealer2 = new Dealer("67","abbas","000003");
                dealerList.add(dealer1);
                dealerList.add(dealer);
                dealerList.add(dealer2);
                dealerService.save(dealerList);
        }

        @Test
        public void pageList() throws Exception {
                DealerVo dealerVo = new DealerVo(null,"abbas");
                dealerService.pageList(dealerVo);
        }

        @Test
        public void findByVendorId() throws Exception {
                final List<Dealer> byVendorId = dealerService.findByVendorId("000003");
        }

        @Test
        public void findByVendorIdForInt() throws Exception {
                final List<Dealer> byVendorId = dealerService.findByVendorId(3);
        }


}
