package spring.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(NullPointerException.class)
    public String error(NullPointerException e, Model model) {
        model.addAttribute("exception", e.getClass());
        return "error";
    }

    @ExceptionHandler(IndexOutOfBoundsException.class)
    public String error(IndexOutOfBoundsException e, Model model) {
        model.addAttribute("exception", e.getClass());
        return "error";
    }
}
