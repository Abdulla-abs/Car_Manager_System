package com.example.spingboot.domain.vo;

import com.alibaba.fastjson.JSON;
import com.example.spingboot.common.enums.ResultStatusEnum;
import lombok.Data;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/4/14 19:53
 */
@Data
public class ResultVo<T> {

        private Integer code;
        private String msg;
        private T data;

        //成功
        public ResultVo(){
                this.code = ResultStatusEnum.SUCCESS.getValue();
                this.msg = ResultStatusEnum.SUCCESS.getDescription();
        }

        //查询
        public ResultVo(T data){
                if (data == null){
                        this.code = ResultStatusEnum.NOT_FOUND.getValue();
                        this.msg = ResultStatusEnum.NOT_FOUND.getDescription();
                }else {
                        this.code = ResultStatusEnum.SUCCESS.getValue();
                        this.msg = ResultStatusEnum.SUCCESS.getDescription();
                        this.data = data;
                }
        }

        //异常
        public ResultVo(ResultStatusEnum resultStatusEnum){
                this.code = resultStatusEnum.getValue();
                this.msg = resultStatusEnum.getDescription();
        }

        //数据校验错误
        public ResultVo(ResultStatusEnum resultStatusEnum,T data){
                this.code = resultStatusEnum.getValue();
                this.msg = resultStatusEnum.getDescription();
                this.data = data;
        }

        public void out(HttpServletResponse response) throws IOException {
                response.setContentType("text/json;charset=utf-8");
                response.getWriter().write(JSON.toJSONString(this));
        }

}
