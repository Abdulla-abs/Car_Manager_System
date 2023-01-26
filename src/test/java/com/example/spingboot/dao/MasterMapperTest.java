package com.example.spingboot.dao;

import com.example.spingboot.domain.dto.MasterDto;
import com.example.spingboot.domain.entity.Master;
import com.example.spingboot.domain.vo.MasterVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
public class MasterMapperTest {
        @Autowired
        private MasterMapper masterMapper;

        @Test
        public void m1() throws Exception {
                BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
                String pwd = encoder.encode("123456");

                List<Master> masters = new ArrayList<>();
                Master master = new Master("V00001", pwd, "O", null, "LongName");
//                Master master2 = new Master("000004", pwd, "O", null, "LongName");
                masters.add(master);
//                masters.add(master2);
                masterMapper.insertBatch(masters);

//                masterMapper.insert(master);
//                masterMapper.insertSelective(master);
        }

        @Test
        public void updateByPrimaryKeySelective() throws Exception {
                Master master = new Master("V00001", new BCryptPasswordEncoder().encode("123456"), "N", null, "NewName");
                masterMapper.updateByPrimaryKeySelective(master);
        }

        @Test
        public void updateByPrimaryKey() throws Exception {
                Master master = new Master("000003", "2001112", "O", null, "NewName");
                masterMapper.updateByPrimaryKey(master);
        }

        @Test
        public void updateBatch() throws Exception {
                List<Master> masters = new ArrayList<>();
                Master master = new Master("000003", "1111111", "O", null, "NewName");
                Master master2 = new Master("000004", "1111112", "O", null, "NewName");
                masters.add(master);
                masters.add(master2);
                masterMapper.updateBatch(masters);
        }

        @Test
        public void deleteByPrimaryKey() throws Exception {
                masterMapper.deleteByPrimaryKey("000003");
        }

        @Test
        public void deleteBatch() throws Exception {
                Integer[] array = new Integer[]{3, 4};
                masterMapper.deleteBatch(array);
        }

        @Test
        public void pageTest() throws Exception {
                MasterVo masterVo = new MasterVo();
                masterVo.setCurrentPage(2);
                masterVo.setPageSize(8);
                List<Master> masters = masterMapper.selectListAll(masterVo);
                System.out.println(masters);
        }

        @Test
        public void selectSingle() throws Exception {
                MasterDto master = masterMapper.selectByPrimaryKey("000001");
        }
}
