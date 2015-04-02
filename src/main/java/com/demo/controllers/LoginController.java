package com.demo.controllers;

import com.demo.handler.UserHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by pingping on 三月/8/15.
 * "/tologin" ＝ "tologin" 不需要使用上下文根,但请求时需要使用/web/login
 */
@Controller
public class LoginController  {

    private Logger logger = LogManager.getLogger("logger");

//    @Qualifier("UserSecurityHandler")
//    @Autowired
//    private UserHandler userHandler;

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
        logger.entry();

        String name = request.getParameter("name");
        String pwd = request.getParameter("password");
        String fileName = request.getParameter("formFile");

        logger.debug(name+":"+pwd);
//        UserSecurityHandler userHandler = new UserSecurityHandler();
//        ApplicationUtil applicationUtil = new ApplicationUtil();
//        UserHandler userHandler = (UserHandler) applicationUtil.getBean("UserSecurityHandler");

        WebApplicationContext context = (WebApplicationContext)request.getServletContext().getAttribute("org.springframework.web.servlet.FrameworkServlet.CONTEXT.springMVC");
        UserHandler userHandler = (UserHandler) context.getBean("UserSecurityHandler");
        boolean isValid = userHandler.isValid(name, pwd);

        if(isValid) {
            request.getSession().setAttribute("user", name);
            ModelAndView mv = new ModelAndView();
            mv.addObject("message", "login");
            mv.addObject("name", name);

            if (request instanceof MultipartHttpServletRequest) {
                MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
                MultipartFile multipartFile = multipartHttpServletRequest.getFile("formFile");
                mv.addObject("fileName",multipartFile.getOriginalFilename());
            }

            mv.setViewName("main");
            logger.exit();
            return mv;
        }else{
            throw new Exception("InValid User!");
        }
    }

    @RequestMapping(value = "tologin")
    public String redirtLogin1(HttpServletRequest request,HttpServletResponse response){
        logger.debug("tologin1");
        return "login";
//        return "redirect:/index.jsp";
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
