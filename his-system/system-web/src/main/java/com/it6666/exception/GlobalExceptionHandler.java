package com.it6666.exception;

import com.it6666.vo.AjaxResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * description: 全局异常处理
 * date: 2020-09-03 23:54
 * author: 30315
 * version: 1.0
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 当系统出现MethodArgumentNotValidException这个异常时，会调用下面的方法
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public AjaxResult jsonErrorHandler(MethodArgumentNotValidException e) {
        List<Map<String, Object>> list = new ArrayList<>();
        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
        for (ObjectError allError : allErrors) {
            Map<String, Object> map = new HashMap<>();
            map.put("defaultMessage", allError.getDefaultMessage());
            map.put("objectName", allError.getObjectName());
            //注意，这里面拿到具体的某一个属性
            FieldError fieldError = (FieldError) allError;
            map.put("field", fieldError.getField());
            list.add(map);
        }
        return AjaxResult.fail("后端数据校验异常", list);
    }
}