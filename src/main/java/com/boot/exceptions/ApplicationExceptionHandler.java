package com.boot.exceptions;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static com.boot.constants.Constant.Urls.ERROR_PAGE;

@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(value = UserAuthorizationException.class)
    public String handleException(UserAuthorizationException exception, Model model) {
        model.addAttribute("exception", exception.getMessage());
        return ERROR_PAGE;
    }

}
