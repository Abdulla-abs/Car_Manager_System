package com.example.spingboot.controller;

import com.example.spingboot.domain.dto.MasterDto;
import com.example.spingboot.domain.entity.Dealer;
import com.example.spingboot.domain.entity.Master;
import com.example.spingboot.domain.entity.Vendor;
import com.example.spingboot.domain.vo.ResultVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/4/19 8:27
 */
@RestController
@RequestMapping("api/v1/demo")
public class DemoController2 {

        @RequestMapping("/getUser")
        public ResultVo getUser(String accountId) throws Exception {
                Master master = new Master();
                master.setAccountId(accountId);
                master.setAccountName("abbas");
                ResultVo resultVo = new ResultVo(master);
                return resultVo;
        }

        @PostMapping("/getDemo")
        public ResultVo getDemo(String dealerId){
                Dealer dealer = new Dealer();
                dealer.setDealerCode("250");
                dealer.setVendorId(dealerId);
                return new ResultVo(dealer);
        }

        @RequestMapping("/getUserDto")
        public MasterDto getUserDot(String accountId) throws Exception {
                MasterDto masterDto = new MasterDto();
                masterDto.setAccountId("hhhh");
                masterDto.setAccountName("abdullah");
                return masterDto;
        }

        @GetMapping("/demo/{id}")
        public ResultVo demo(@PathVariable String id){
                int a = 6 / 0;
                ResultVo<Dealer> dealerResultVo = new ResultVo<>();
                dealerResultVo.setMsg("请求成功 id:"+id);
                return dealerResultVo;
        }

        @PostMapping("/demo2")
        public ResultVo demo2(Vendor vendor){
                ResultVo<Vendor> vendorResultVo = new ResultVo();
                vendorResultVo.setData(vendor);
                return vendorResultVo;
        }

        @PostMapping("/demo3")
        public ResultVo demo3(@RequestBody List<Vendor> vendors){
                ResultVo<List<Vendor>> resultVo = new ResultVo<>();
                resultVo.setData(vendors);
                return resultVo;
        }


}
