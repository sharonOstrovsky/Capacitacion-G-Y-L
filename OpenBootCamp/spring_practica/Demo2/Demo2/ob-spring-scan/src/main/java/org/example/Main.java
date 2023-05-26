package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context =  new ClassPathXmlApplicationContext("beans.xml");

        //Primer Ejemplo


        Calculadora calculadora = (Calculadora) context.getBean("calculadora");

        System.out.println(calculadora.suma());

        //Segundo Ejemplo
        SaludoInicial saludoInicial = (SaludoInicial) context.getBean("saludoInicial");

        System.out.printf(saludoInicial.SaludoInicial());

    }
}