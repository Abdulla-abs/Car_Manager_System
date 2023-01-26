package com.example.spingboot.controller;

import com.example.spingboot.domain.dto.AuditResultDto;
import com.example.spingboot.domain.dto.MasterDto;
import com.example.spingboot.domain.entity.AuditResult;
import com.example.spingboot.domain.vo.AuditResultVo;
import com.example.spingboot.domain.vo.ResultVo;
import com.example.spingboot.service.AuditResultService;
import com.example.spingboot.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/4/24 22:39
 */
@RestController
@RequestMapping("/auditResult")
public class AuditResultController {
        @Autowired
        private AuditResultService auditResultService;


        @GetMapping("/get")
        public ResultVo get(AuditResultVo auditResultVo) throws Exception {
                AuditResultDto data = auditResultService.getById(auditResultVo);
                return new ResultVo(data);
        }

        @PostMapping("/update")
        public ResultVo update(@Valid AuditResult auditResult) throws Exception {
                MasterDto user = UserUtil.getUser();
                auditResult.setAuditDate(new Date());
                auditResult.setAuditorId(user.getAccountId());
                auditResult.setAuditorName(user.getAccountName());
                auditResultService.update(auditResult);
                return new ResultVo();
        }
}
