package com.demo.controllers;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 * Created by pingping on 7/8/18.
 */
@Controller
public class FileUploadController {


    @RequestMapping("/uploadfiles")
    public String upload(@RequestParam("formFile") MultipartFile[] multipartFiles, HttpServletRequest request, HttpServletResponse response) throws Exception {


        for(MultipartFile multiPartFile : multipartFiles){

            if( multiPartFile.getSize() < 1 ){
                throw new Exception("no file upload :" +multiPartFile);
            }

            System.out.println(multiPartFile.getSize() + " : "+ multiPartFile.getBytes().length);
            System.out.println(multiPartFile.getOriginalFilename() + "\t:\t" + multiPartFile.getContentType());
//            /Users/pingping/devapps/servers/apache-tomcat-7.0.8/bin
            System.out.println(System.getProperty("user.dir"));
            multiPartFile.transferTo(new File("/Users/pingping/devworks/nine.demo.spring/temp/"+ multiPartFile.getOriginalFilename()));
        }

        return "success";
    }
}
