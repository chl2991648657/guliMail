package pers.cl.gulimall.product.exception;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pers.cl.common.utils.R;

import java.util.HashMap;
import java.util.Map;


@RestControllerAdvice(basePackages = "pers.cl.gulimall.product.controller")
public class GulimallControllerExceptionAdvice {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R handlerValidException(MethodArgumentNotValidException e){
        BindingResult bindResult = e.getBindingResult();

        Map<String,String> errMap= new HashMap<>();
        bindResult.getFieldErrors().forEach((fieldError -> {
            errMap.put(fieldError.getField(),fieldError.getDefaultMessage());

        }));
        return R.error(400,"数据校验错").put("data",errMap);
    }
}
