package com.example.spingboot.dao;

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
 * @date 2022/3/18 9:31
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DealerMapperTest {

        @Autowired
        private DealerMapper dealerMapper;

        @Test
        public void insert() throws Exception {
                Dealer dealer = new Dealer("0006","testDealer","000001");
                dealerMapper.insert(dealer);
        }

        @Test
        public void insertBatch() throws Exception {
                List<Dealer> dealers = new ArrayList<>();
                Dealer dealer1 = new Dealer("0002","testDealer","000001");
                Dealer dealer2 = new Dealer("0003","testDealer","000001");
                Dealer dealer3 = new Dealer("0004","testDealer","000001");
                dealers.add(dealer1);
                dealers.add(dealer2);
                dealers.add(dealer3);
                dealerMapper.insertBatch(dealers);
        }

        @Test
        public void updateByPrimaryKeySelective() throws Exception {
                Dealer dealer3 = new Dealer("0006","testDealer","000001");
                dealerMapper.updateByPrimaryKeySelective(dealer3);
        }

        @Test
        public void updateByPrimaryKey() throws Exception{
                Dealer dealer3 = new Dealer("0004","newDealer","000001");
                dealerMapper.updateByPrimaryKey(dealer3);
        }

        @Test
        public void updateBatch() throws Exception {
                List<Dealer> dealers = new ArrayList<>();
                Dealer dealer1 = new Dealer("0002","testDealer","000001");
                Dealer dealer2 = new Dealer("0003","testDealer","000001");
                Dealer dealer3 = new Dealer("0004","testDealer","000001");
                dealers.add(dealer1);
                dealers.add(dealer2);
                dealers.add(dealer3);
                dealerMapper.updateBatch(dealers);
        }

        @Test
        public void deleteByPrimaryKey() throws Exception {
                dealerMapper.deleteByPrimaryKey("0004");
        }

        @Test
        public void deleteBatch() throws Exception {
                Integer[] a = new Integer[]{1,2};
                dealerMapper.deleteBatch(a);
        }

        @Test//没写xml
        public void selectByPrimaryKey() throws Exception {
                Dealer dealer = dealerMapper.selectByPrimaryKey(6);
        }

        @Test
        public void selectListByVendorId() throws Exception {
                List<Dealer> list = dealerMapper.selectListByVendorId("000001");
        }

        @Test
        public void selectListBySelective() throws Exception {
                DealerVo dealer1 = new DealerVo(null,"new");
                List<Dealer> list = dealerMapper.selectListBySelective(dealer1);

        }

        @Test
        public void selectCountBySelective() throws Exception {
                DealerVo dealerVo = new DealerVo("","test");
                dealerMapper.selectCountBySelective(dealerVo);
        }

        @Test
        public void pageTest() throws Exception {

        }

        @Test
        public void selectSingle() throws Exception {

        }
}
