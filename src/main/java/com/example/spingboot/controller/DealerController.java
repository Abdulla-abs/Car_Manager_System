package com.example.spingboot.controller;

import com.example.spingboot.domain.entity.Dealer;
import com.example.spingboot.domain.vo.DealerVo;
import com.example.spingboot.domain.vo.ResultVo;
import com.example.spingboot.service.DealerService;
import com.example.spingboot.utils.PaginationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/4/23 13:52
 */
@RestController
@RequestMapping("/dealer")
@Validated
public class DealerController {

        @Autowired
        private DealerService dealerService;

        @PostMapping("/save")
        public ResultVo save(@Valid @RequestBody List<Dealer> dealers) throws Exception {
                dealerService.save(dealers);
                return new ResultVo();
        }

        @GetMapping("/list")
        public ResultVo list(DealerVo dealerVo) throws Exception {
                PaginationUtil data = dealerService.pageList(dealerVo);
                return new ResultVo(data);
        }
}
