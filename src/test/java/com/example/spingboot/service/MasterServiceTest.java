package com.example.spingboot.service;

import com.example.spingboot.dao.MasterMapper;
import com.example.spingboot.domain.dto.MasterDto;
import com.example.spingboot.domain.entity.Master;
import com.example.spingboot.domain.vo.PageVo;
import com.example.spingboot.utils.PaginationUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/4/5 9:07
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MasterServiceTest {

        @Autowired
        private MasterService masterService;

        @Test//ok
        public void save() throws Exception {
                Master master = new Master("000022","adnxijsniabauicb","V","000003","Hello");
                masterService.save(master);
        }

        @Test
        public void delete() throws Exception {
                masterService.delete("000092");
        }

        @Test
        public void update() throws Exception {
                Master master = new Master("000092","adnxijsniabauicb","V","000003","Kitty");
                masterService.update(master);
        }

        @Test
        public void getById() throws Exception {
                MasterDto masterDto = masterService.findById("000092");
        }

        @Test
        public void pageList() throws Exception {
                PageVo pageVo = new PageVo(1,3);
                PaginationUtil<Master> masters = masterService.queryList(pageVo);
        }
}









