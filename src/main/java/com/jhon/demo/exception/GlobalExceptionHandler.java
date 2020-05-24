package com.jhon.demo.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.BindException;
import java.util.HashMap;
import java.util.List;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {


    @ResponseBody
    @ExceptionHandler(value = {BindException.class, MethodArgumentNotValidException.class})
    public HashMap validationExceptionHandler(MethodArgumentNotValidException exception) {

        BindingResult result = exception.getBindingResult();
        HashMap<String, String> hashMap = new HashMap<>();

        if (result.hasErrors()) {

            List<ObjectError> errors = result.getAllErrors();
            errors.forEach(p -> {

                FieldError fieldError = (FieldError) p;
                log.error("Data check failure : " +
                        "object{" + fieldError.getObjectName() + "}," +
                        "field{" + fieldError.getField() + "}," +
                        "errorMessage{" + fieldError.getDefaultMessage() + "}");

                hashMap.put(fieldError.getObjectName() + "." + fieldError.getField(), fieldError.getDefaultMessage());

            });

        }

        return hashMap;
    }
}
