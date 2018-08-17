package com.example.fond.exceptions;

import org.slf4j.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
    private  static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EmptyListException.class)
    public String  handleEmptyListException(EmptyListException ex) {
        logger.error(ex.getMessage());
        return ex.getMessage();
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "пожалуйста напишите имя человека")
    @ExceptionHandler(NullFirstNameException.class)
    public void  handleNullFirstName() {
        logger.error("проблема в том что не написали Имя (firstName)");
    }

}
