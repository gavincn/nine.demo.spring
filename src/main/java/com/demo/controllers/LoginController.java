package com.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by pingping on 三月/8/15.
 */
@Controller
public class LoginController  {


    @RequestMapping(value="/reg/{name:\\w+}-{age:\\d+}", method = {RequestMethod.GET})
    public ModelAndView regUrlTest(@PathVariable(value="name") String name, @PathVariable(value="age") Integer age){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", name);
        modelAndView.addObject("age", age);
        modelAndView.setViewName("regurltest");
        return modelAndView;
    }

    @RequestMapping(value = "login")
    public ModelAndView login(HttpServletRequest request,HttpServletResponse response)throws Exception {
        request.getSession().setAttribute("user","liu");
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", "login");
        mv.setViewName("index");
        return mv;
    }

//    @ExceptionHandler(Throwable.class)
//    public String handleException(Throwable t) {
//        return "redirect:/errors/500.jsp";
//    }
//
//    @ExceptionHandler(Exception.class)
//    public String handleException1(Throwable t) {
//        return "redirect:/WEB-INF/views/errors/error.jsp";
//    }
}
