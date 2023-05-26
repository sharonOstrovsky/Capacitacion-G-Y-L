package com.example.springdeploy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HellowController {

 //   @GetMapping("/saludo")
 //   public String saludo(){
 //       return "hola!";
 //   }

    @GetMapping("/index")
    public String index(){
        return "index.html";
    }
}
