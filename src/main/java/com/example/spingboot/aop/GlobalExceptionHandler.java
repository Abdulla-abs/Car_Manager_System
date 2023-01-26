package com.example.spingboot.aop;

import com.example.spingboot.common.enums.ResultStatusEnum;
import com.example.spingboot.domain.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/4/20 10:50
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

        @ExceptionHandler(value = Exception.class)
        public ResultVo handlerAllException(Exception e){
                log.info(e.getMessage(),e);
                return new ResultVo(ResultStatusEnum.ERROR);
        }

        @ExceptionHandler(value = BindException.class)
        public ResultVo handlerValidationException(BindException e){
                List<String> data = new ArrayList<>();
                BindingResult bindingResult = e.getBindingResult();
                List<FieldError> errors = bindingResult.getFieldErrors();
                for (FieldError error : errors) {
                        data.add(error.getDefaultMessage());
                }
                ResultVo resultVo = new ResultVo(ResultStatusEnum.VALIDATE_FAILED,data);
                return resultVo;
        }

        @ExceptionHandler(value = ConstraintViolationException.class)
        public ResultVo handlerValidationException(ConstraintViolationException e){
                List<String> data = new ArrayList<>();
                for (ConstraintViolation<?> constraintViolation : e.getConstraintViolations()) {
                        data.add(constraintViolation.getMessage());
                }
                ResultVo resultVo = new ResultVo(ResultStatusEnum.VALIDATE_FAILED,data);
                return resultVo;
        }

        //请求方式错误拦截
        @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
        public ResultVo handlerRequestTypeErrorException(HttpRequestMethodNotSupportedException e){
                return new ResultVo(ResultStatusEnum.REQUEST_TYPE_NOT_SUPPORT);
        }
}
