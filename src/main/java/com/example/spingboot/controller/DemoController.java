package com.example.spingboot.controller;

import com.example.spingboot.domain.entity.Master;
import com.example.spingboot.domain.vo.ResultVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/4/14 20:45
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

        @RequestMapping(value = "/getUser",method = RequestMethod.GET)
        public ResultVo getUser(){
                Master master = new Master();
                master.setAccountId("1");
                master.setAccountName("abbas");
                ResultVo resultVo = new ResultVo(master);
                return resultVo;
        }
}
