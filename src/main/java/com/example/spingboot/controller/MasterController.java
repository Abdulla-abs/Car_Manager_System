package com.example.spingboot.controller;

import com.example.spingboot.domain.dto.MasterDto;
import com.example.spingboot.domain.entity.Master;
import com.example.spingboot.domain.vo.PageVo;
import com.example.spingboot.domain.vo.ResultVo;
import com.example.spingboot.service.MasterService;
import com.example.spingboot.utils.PaginationUtil;
import com.example.spingboot.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/4/22 8:53
 */
@RestController
@RequestMapping("/master")
public class MasterController {

        @Autowired
        private MasterService masterService;

        @PostMapping("/save")
        public ResultVo save(@Valid Master master) throws Exception {
                BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                String pwd = passwordEncoder.encode(master.getAccountPassword());
                master.setAccountPassword(pwd);
                masterService.save(master);
                ResultVo resultVo = new ResultVo();
                return resultVo;
        }

        @GetMapping("/delete/{id}")
        public ResultVo delete(@PathVariable String id) throws Exception {
                masterService.delete(id);
                return new ResultVo();
        }

        @GetMapping("/get/{id}")
        public ResultVo getById(@PathVariable String id) throws Exception {
                MasterDto data = masterService.findById(id);
                ResultVo resultVo = new ResultVo(data);
                return resultVo;
        }

        @GetMapping("/list")
        public ResultVo list(PageVo query) throws Exception {
                PaginationUtil data = masterService.queryList(query);
                ResultVo<PaginationUtil> resultVo = new ResultVo<>(data);
                return resultVo;
        }
}
