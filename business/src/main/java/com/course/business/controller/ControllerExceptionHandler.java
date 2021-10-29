package com.course.business.controller;

import com.course.server.exception.ValidatorException;
import com.course.server.vo.ResponseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ControllerExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @ExceptionHandler(value = ValidatorException.class)
    @ResponseBody
    public ResponseVO validatorExceptionHandler(ValidatorException e) {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setSuccess(false);
        LOG.warn(e.getMessage());
        responseVO.setMessage("请求参数异常!");
        return responseVO;
    }

}
