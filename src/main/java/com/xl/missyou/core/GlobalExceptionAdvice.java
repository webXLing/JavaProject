package com.xl.missyou.core;

import com.xl.missyou.core.configuration.ExceptionCodeConfig;
import com.xl.missyou.exception.http.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionAdvice {

    @Autowired
    private ExceptionCodeConfig exceptionCodeConfig;
    // 处理未知异常
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    // 一个类要被序列化 属性上必须要有getter  500
    public UnifyResponse handleException(HttpServletRequest request,Exception e) {
        String requestURI = request.getRequestURI();
        String method = request.getMethod();
        System.out.println("handleException:" + e);
        UnifyResponse unifyResponse = new UnifyResponse(9999,"系统错误",requestURI + " " + method +"/"+e);
        return unifyResponse;
    }

    // 处理http异常
    @ExceptionHandler(HttpException.class)
    public ResponseEntity handleHttpException(HttpServletRequest request,HttpException e) {
        System.out.println("handleHttpException:"+e);
        String requestURI = request.getRequestURI();
        String method = request.getMethod();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        UnifyResponse unifyResponse = new UnifyResponse(e.getCode(),exceptionCodeConfig.getMessage(e.getCode()),requestURI + " " + method +"/"+e);
        HttpStatus httpCode = HttpStatus.resolve(e.getHttpStatusCode());
        ResponseEntity<UnifyResponse> responseEntity = new ResponseEntity<>(unifyResponse,httpHeaders,httpCode);
        return responseEntity;
    }
}
