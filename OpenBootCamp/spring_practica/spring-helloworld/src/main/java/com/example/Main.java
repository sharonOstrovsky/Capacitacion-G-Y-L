package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        //EJEMPLO 1: como obtener beans de spring

        //OPCION 1: crear un objeto de forma normal
        //CalculatorService service = new CalculatorService();

        //OPCION 2: Recibir un objeto de Spring
        Calculadora calculadora = (Calculadora) context.getBean("calculadora");

        String texto =  calculadora.holaMundo();
        System.out.println(texto);

        Calculadora calculadora2 = (Calculadora) context.getBean("calculadora");
        String texto2 =  calculadora.holaMundo();
        System.out.println(texto2);

        //EJEMPLO 2: cargar un bean dentro de otro bean
        GestorFacturas gestor = (GestorFacturas) context.getBean("gestorFacturas");
        System.out.println(gestor.calculadora.holaMundo());

        //CONCEPTO 3: scope o alcance
        //los beans por defecto son singleton, se crea el objeto y se reutiliza para toda la aplicacion
        //podemos cambiarlo a scope="prototype" si queremos que se cree un nuevo objeto cada vez
        //verificarlo viendo como se ejecura varias veces un constructor
    }
}
