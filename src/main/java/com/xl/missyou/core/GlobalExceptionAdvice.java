package com.xl.missyou.core;

import com.xl.missyou.core.configuration.ExceptionCodeConfig;
import com.xl.missyou.exception.http.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.util.List;

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

    // 处理bean 的异常  参数异常
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public UnifyResponse handleBeanValidatorException(HttpServletRequest request,MethodArgumentNotValidException e) {
        String requestURI = request.getRequestURI();
        String method = request.getMethod();
        System.out.println("handleException:" + e);


        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
        String errMessage = this.getErrMessage(allErrors);
        UnifyResponse unifyResponse = new UnifyResponse(10001,errMessage,requestURI + " " + method +"/"+e);

        return unifyResponse;
    }

    /**
     * url 上的参数校验异常
     * @param requst
     * @return
     * 参数错误code 100001
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public UnifyResponse handleConstraintViolationException(HttpServletRequest request, ConstraintViolationException e){
        System.out.println("url 上的参数校验异常");
//        Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations(); //集合
//        for (ConstraintViolation constraintViolation : constraintViolations) {
//            ConstraintViolation constraintViolation1 = constraintViolation;
//            constraintViolation1.getMessage() // 错误信息
//        }
        String requestURI = request.getRequestURI();
        String method = request.getMethod();
        String message = e.getMessage();
        return new UnifyResponse(10001,message,requestURI + " " + method +"/"+e);
    }


    public String getErrMessage(List<ObjectError> allErrors){
        StringBuilder stringBuilder = new StringBuilder();
        allErrors.forEach(objectError ->
                stringBuilder.append(objectError.getDefaultMessage()).append(';')
        );
        return stringBuilder.toString();

    }
}
