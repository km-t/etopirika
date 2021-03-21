package spring.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import spring.persistence.entity.MyException;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(JsonMappingException.class)
    public String error(JsonMappingException e, Model model) {
        return addModelAndReturnError(e, model);
    }

    @ExceptionHandler(JsonProcessingException.class)
    public String error(JsonProcessingException e, Model model) {
        return addModelAndReturnError(e, model);
    }

    @ExceptionHandler(MyException.class)
    public String error(MyException e, Model model) {
        return addModelAndReturnError(e, model);
    }

    private String addModelAndReturnError(Throwable e, Model model) {
        model.addAttribute("exception", e.getClass()+e.getMessage());
        return "error";
    }
}
