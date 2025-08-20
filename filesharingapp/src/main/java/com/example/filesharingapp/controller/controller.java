package com.example.filesharingapp.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;;

import com.example.filesharingapp.dto.filedto;
import com.example.filesharingapp.service.service;


@Controller
@RequestMapping()

public class controller {

     @Autowired
    private service fileService;
    private filedto model;

 

    @GetMapping()
    public String login() {
        return "home";
    }


        @GetMapping("/home")
    public String listFiles( filedto model) {
            model.addAttribute("files", fileService.getAllFiles());
            return "list-files";
    }

    


     @PostMapping("/upload")
     public String uploadFile(@RequestParam("file") MultipartFile file,
             @RequestParam("uploadedBy") String uploadedBy) throws IOException {
         fileService.uploadFile(file, uploadedBy);
         return "redirect:/files/home";
     }



       @GetMapping("/share/{id}")
    public String shareFile(@PathVariable("id") int id, filedto model) {
        ResponseEntity<?> fileModel = fileService.shareFile(id);
        if(fileModel.hasBody()) {
            String currentUrl = ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString();
            model.addAttribute("shareUrl", currentUrl);                       
            model.addAttribute("file", fileModel.getBody());
            return "share-file"; 
        }
        else {
            return "redirect:/files";
        }
    }


    @GetMapping("/download/{id}")
     public ResponseEntity<?> downloadFile(@PathVariable("id") int id) {
        return fileService.getFile(id);
    }



}