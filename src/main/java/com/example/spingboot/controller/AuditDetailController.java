package com.example.spingboot.controller;

import com.example.spingboot.domain.dto.AuditDetailReferenceDto;
import com.example.spingboot.domain.dto.MasterDto;
import com.example.spingboot.domain.entity.AuditDetail;
import com.example.spingboot.domain.entity.AuditDetailWithBLOBs;
import com.example.spingboot.domain.entity.Dealer;
import com.example.spingboot.domain.vo.AuditDetailVo;
import com.example.spingboot.domain.vo.ResultVo;
import com.example.spingboot.service.AuditDetailService;
import com.example.spingboot.service.AuditHeaderService;
import com.example.spingboot.service.DealerService;
import com.example.spingboot.utils.PaginationUtil;
import com.example.spingboot.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/4/24 22:09
 */
@RestController
@RequestMapping("/auditDetail")
public class AuditDetailController {

        @Autowired
        private AuditDetailService auditDetailService;

        @Autowired
        private AuditHeaderService auditHeaderService;

        @Autowired
        private DealerService dealerService;

        @PostMapping("/save")
        public ResultVo save(@Valid AuditDetail auditDetail) throws Exception {
                auditDetailService.save(auditDetail);
                return new ResultVo();
        }

        @PostMapping("/saveOthers")
        public ResultVo saveOther(AuditDetailWithBLOBs auditDetailWithBLOBs) throws Exception {
                auditDetailService.saveOthers(auditDetailWithBLOBs);
                return new ResultVo();
        }

        @GetMapping("/list")
        public ResultVo list(AuditDetailVo query) throws Exception {
                if (query.getAuditIds() == null) {
                        MasterDto user = UserUtil.getUser();
                        if (user.getVendorId() != null) {
                                List<Dealer> dealers = dealerService.findByVendorId(user.getVendorId());
                                Integer[] listAuditByDealer = auditHeaderService.listAuditByDealer(dealers);
                                if (listAuditByDealer.length>0) {
                                        query.setAuditIds(listAuditByDealer);
                                }
                        }
                }

                PaginationUtil data = auditDetailService.pageList(query);
                return new ResultVo(data);
        }

        @GetMapping("list/{id}")
        public ResultVo getReference(@PathVariable Integer id) throws Exception {
                AuditDetailReferenceDto data = auditDetailService.getDetailReferenceById(id);
                return new ResultVo(data);
        }










}
