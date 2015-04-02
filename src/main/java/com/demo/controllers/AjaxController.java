package com.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by pingping on 三月/11/15.
 */
@Controller
public class AjaxController {

    @RequestMapping(value = "/ajax")
    @ResponseBody
    public String getData(HttpServletRequest request,HttpServletResponse response)throws Exception{

        return "{json:'json1'}";
    }
}
