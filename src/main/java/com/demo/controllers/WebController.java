package com.demo.controllers;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by pingping on 三月/6/15.
 */
@Controller
@Component
//@RequestMapping(value = "/demo") // xxx/demo/default  || xxx/demo/hello
public class WebController {

    //headers = "Accept=application/json"
    @RequestMapping(value = "/default", method = RequestMethod.GET)
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse httpServletResponse) throws Exception {
        System.out.println("this is default");
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", "Hello default!");
        mv.setViewName("hello");
        return mv;
    }

    @RequestMapping(value = "/hello")
    public ModelAndView hello(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("this is hello");
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", "Hello world!");
        mv.setViewName("hello");
        return mv;
    }

    /**
     * @param request
     * @param response
     * @return view name
     * @throws Exception
     */
    //xxx/hello?type=submit
    @RequestMapping(value = "/hello1", params = "type=submit")
    public String submit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "success";
    }

    //xxx/hello?type=inquire
    @RequestMapping(value = "/hello1", params = "type!=submit")
    public String list(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        return "forward:/order/add";
//        return "redirect:/login.jsp";
        return "success";
    }

    @RequestMapping(value = "/databind", method = RequestMethod.POST)
    public ModelAndView databind(HttpServletRequest request, HttpServletResponse response,
                                 @RequestParam("name") String name
                                 /*,@RequestParam(value="formFile", required=false) MultipartFile file*/) throws Exception {

        ModelAndView mv = new ModelAndView();
        if (request instanceof MultipartHttpServletRequest) {
            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
            MultipartFile multipartFile = multipartHttpServletRequest.getFile("formFile");
            mv.addObject("fileName",multipartFile.getOriginalFilename());
        }

        String password = ServletRequestUtils.getStringParameter(request, "password");
//        String name = ServletRequestUtils.getStringParameter(request, "name");
//        System.out.println("this is web controller databind--" + name + "\t" + password);

        mv.addObject("name", name);
        mv.addObject("password", password);
        mv.setViewName("main");

//        return "forward:/order/add";
//        return "redirect:/login.jsp";
        return mv;
    }
}
