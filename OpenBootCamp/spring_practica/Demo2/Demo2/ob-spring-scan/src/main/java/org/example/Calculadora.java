package org.example;


import org.springframework.stereotype.Component;

@Component
public class Calculadora {


    public String suma(){
        int a = 5;
        int b = 10;

        return "La suma es " + (a + b);
    }
}
