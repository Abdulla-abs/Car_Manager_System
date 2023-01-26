package com.example.spingboot.controller;

import com.example.spingboot.domain.entity.Vendor;
import com.example.spingboot.domain.vo.ResultVo;
import com.example.spingboot.domain.vo.VendorVo;
import com.example.spingboot.service.VendorService;
import com.example.spingboot.utils.PaginationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/4/23 12:37
 */
@RestController
@RequestMapping("/vendor")
@Validated
public class VendorController {

        @Autowired
        private VendorService vendorService;

        @PostMapping("/save")
        public ResultVo save(@Valid @RequestBody List<Vendor> vendors) throws Exception {
                vendorService.save(vendors);
                return new ResultVo();
        }

        @GetMapping("/list")
        public ResultVo list(VendorVo vendorVo) throws Exception {
                PaginationUtil data = vendorService.pageList(vendorVo);
                return new ResultVo(data);
        }
}
