package com.hyj.util.exception;

import javax.servlet.http.HttpServletRequest;

import com.hyj.util.common.enums.ErrorCode;
import com.hyj.util.web.ResData;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * Global exception handler<br><br>
 *
 * <b>0.0.4: </b>Add method argumentExceptionHandler
 *
 * @author lshaci
 * @since 0.0.3
 * @version 0.0.4
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResData handler(HttpServletRequest request, Exception e) {
        log.error("GlobalExceptionHandler err:" + e);
        return new ResData(ErrorCode.SYS_ERR.code, ErrorCode.SYS_ERR.desc);
    }

}
