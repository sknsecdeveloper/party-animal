package com.subh.jpademo.controller.handleException;

import com.subh.jpademo.Dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@ControllerAdvice
@ResponseBody
public class EmployeeExceptionHandler {


    @ExceptionHandler(GeneralException.class)
    public ErrorDto handleEmployeeException(GeneralException exception){

        ErrorDto errorDto = ErrorDto.builder().status("FAIL")
                .errorMsg(exception.getMessage())
                .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .build();

        return errorDto;
    }


}
