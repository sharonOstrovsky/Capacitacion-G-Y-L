package com.example.springdeploy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ResumeController {

    @GetMapping("/resume/index")
    public String index(){
        return "index.html";
    }

    @GetMapping("/sharon/cv")
    public String resume(){
        return "resume.html";
    }

    @GetMapping("/sharon")
    public String presentacion(){
        return "presentacion.html";
    }
}
