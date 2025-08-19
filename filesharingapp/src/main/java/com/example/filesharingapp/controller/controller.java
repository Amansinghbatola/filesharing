package com.example.filesharingapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping()

public class controller {

    @GetMapping("/files")
    public String login (){
        return "home";
    }
     @GetMapping("/files")
    public String files (){
        return "list.files";
    }
     @GetMapping("/files")
    public String share(){
        return "share.files";
    }
    
}
