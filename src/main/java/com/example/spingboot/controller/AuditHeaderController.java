package com.example.spingboot.controller;

import com.example.spingboot.domain.dto.MasterDto;
import com.example.spingboot.domain.entity.AuditHead;
import com.example.spingboot.domain.vo.AuditHeadVo;
import com.example.spingboot.domain.vo.ResultVo;
import com.example.spingboot.service.AuditHeaderService;
import com.example.spingboot.utils.PaginationUtil;
import com.example.spingboot.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/4/24 21:55
 */

@RestController
@RequestMapping("/auditHeader")
public class AuditHeaderController {

        @Autowired
        private AuditHeaderService auditHeaderService;

        @PostMapping("/save")
        public ResultVo save(@Valid AuditHead auditHead) throws Exception {
                MasterDto user = UserUtil.getUser();
                auditHead.setInsertUser(user.getAccountId());
                auditHead.setUpdateUser(user.getAccountId());
                auditHead.setInsertDate(new Date());
                auditHead.setUpdateDate(new Date());
                auditHeaderService.save(auditHead);
                return new ResultVo();
        }

        @PostMapping("/update")
        public ResultVo update(AuditHead auditHead) throws Exception {
                MasterDto user = UserUtil.getUser();
                auditHead.setInsertUser(user.getAccountId());
                auditHead.setUpdateUser(user.getAccountId());

                auditHeaderService.save(auditHead);
                return new ResultVo();
        }

        @GetMapping("/list")
        public ResultVo list(AuditHeadVo query) throws Exception {
                PaginationUtil data = auditHeaderService.pageList(query);
                return new ResultVo();
        }

        @GetMapping("/list/{periodYm}")
        public ResultVo list(@PathVariable String periodYm) throws Exception {
                String[] data = auditHeaderService.listPeriodByPeriodYm(periodYm);
                return new ResultVo(data);
        }




}
