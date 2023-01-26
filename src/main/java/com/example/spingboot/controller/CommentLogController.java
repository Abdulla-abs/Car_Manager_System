package com.example.spingboot.controller;

import com.example.spingboot.common.enums.ResultStatusEnum;
import com.example.spingboot.domain.vo.CommentLogVo;
import com.example.spingboot.domain.vo.ResultVo;
import com.example.spingboot.service.CommentLogService;
import com.example.spingboot.utils.PaginationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/4/24 21:44
 */
@RestController
@RequestMapping("commentLog")
public class CommentLogController {

        @Autowired
        private CommentLogService commentLogService;

        @GetMapping("/list")
        public ResultVo list(CommentLogVo commentLogVo) throws Exception {
                PaginationUtil data = commentLogService.pageList(commentLogVo);
                return new ResultVo(data);
        }

        @GetMapping("/delete")
        public ResultVo delete(Integer[] arrays) throws Exception {
                ResultVo resultVo = new ResultVo();
                if (arrays != null) {
                        commentLogService.delete(arrays);
                }else {
                        resultVo = new ResultVo(ResultStatusEnum.VALIDATE_FAILED,"没有可删除的数据");
                }
                return resultVo;
        }


}
