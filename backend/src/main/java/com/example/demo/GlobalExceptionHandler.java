package com.example.demo;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class GlobalExceptionHandler {
    // MethodArgumentNotValidException:方式参数不合法异常
    // MethodArgumentNotValidException.class：类字面量
    @ExceptionHandler(MethodArgumentNotValidException.class)
    // handlerValidation：处理校验（的方法）
  
    public ResponseEntity<Map<String,String>> handlerValidation(MethodArgumentNotValidException ex){
        // 造一个空 Map
        Map<String,String> errors = new HashMap<>();
        // getBindingResult():获取绑定结果
        // getFieldErrors()：获取字段错误列表
        // FieldError是e的数据类型
        for(FieldError e : ex.getBindingResult().getFieldErrors()){
            // e.getField():获取错误字段
            // e.getDefaultMessage()：获取默认错误信息
            errors.put(e.getField(),e.getDefaultMessage());
        }
        return ResponseEntity.badRequest().body(errors);
    }
}
