package com.zero.exception.common.handler;

import com.zero.exception.common.exception.BizException;
import com.zero.exception.common.enums.CommonEnum;
import com.zero.exception.common.model.ResultBodyModel;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    public ResultBodyModel bizExceptionHandler(HttpServletRequest req, BizException e) {
        log.error("biz exception！the reason is：{}", e.getErrorMsg());
        return ResultBodyModel.error(e.getErrorCode(), e.getErrorMsg());
    }

    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public ResultBodyModel exceptionHandler(HttpServletRequest req, NullPointerException e) {
        log.error("null exception！the reason is：", e);
        return ResultBodyModel.error(CommonEnum.BODY_NOT_MATCH);
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultBodyModel exceptionHandler(HttpServletRequest req, Exception e) {
        log.error("unknown Exception！the reason is:", e);
        return ResultBodyModel.error(CommonEnum.INTERNAL_SERVER_ERROR);
    }
}

