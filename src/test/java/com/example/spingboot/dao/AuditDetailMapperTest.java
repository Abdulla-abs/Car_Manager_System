package com.example.spingboot.dao;

import com.example.spingboot.common.enums.VehicleClassEnum;
import com.example.spingboot.domain.dto.AuditDetailDto;
import com.example.spingboot.domain.dto.AuditDetailReferenceDto;
import com.example.spingboot.domain.entity.AuditDetail;
import com.example.spingboot.domain.entity.AuditDetailWithBLOBs;
import com.example.spingboot.domain.vo.AuditDetailVo;
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
 * @date 2022/3/30 21:39
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AuditDetailMapperTest {

        @Autowired
        private AuditDetailMapper auditDetailMapper;

        @Test
        public void insertSelective() throws Exception {
                AuditDetail auditDetail = new AuditDetail(1,1,"maker","O","bar","green","c","plate","insp","a");
                auditDetailMapper.insertSelective(auditDetail);
        }

        @Test
        public void updateByPrimaryKeySelective() throws Exception {
                AuditDetail auditDetail = new AuditDetail(1,1,"new","O","bar","green","c","plate","insp","a");
                auditDetailMapper.updateByPrimaryKeySelective(auditDetail);
        }

        @Test
        public void updateBLOBsByPrimaryKey() throws Exception {
                AuditDetailWithBLOBs auditDetailWithBLOBs = new AuditDetailWithBLOBs(2,"ff",null,null,null);
                auditDetailMapper.updateBLOBsByPrimaryKey(auditDetailWithBLOBs);

        }

        @Test
        public void selectListBySelective() throws Exception {
//                List<AuditDetailDto> auditDetailDtos = new ArrayList<>();
//                AuditDetailDto auditDetailDto = new AuditDetailDto(1,1,"maker","a","aa","a",new VehicleClassEnum);
                AuditDetailVo auditDetailVo = new AuditDetailVo(new Integer[]{1},null,null,null,null,null,null,null,null,null,null);

                List<AuditDetailDto> auditDetailDtos = auditDetailMapper.selectListBySelective(auditDetailVo);
        }

        @Test
        public void selectCountBySelective() throws Exception {
                AuditDetailVo auditDetailVo = new AuditDetailVo(new Integer[]{1,2},null,null,null,null,"CSTVN",null,null,null,null,null);
                int count = auditDetailMapper.selectCountBySelective(auditDetailVo);
        }

        @Test
        public void selectReferenceByPrimaryKey() throws Exception {
                AuditDetailReferenceDto auditDetailReferenceDto = auditDetailMapper.selectReferenceByPrimaryKey(1);
        }

}
