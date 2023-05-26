package org.example;

import org.example.Entity.Banco;
import org.example.Entity.Cliente;
import org.example.Entity.CuentaBancaria;
import org.example.Entity.Tarjeta;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        Banco banco = (Banco) context.getBean("banco");
        CuentaBancaria cuentaBancaria = (CuentaBancaria) context.getBean("cuentaBancaria");
        Cliente cliente = (Cliente) context.getBean("cliente");
        Tarjeta tarjeta = (Tarjeta) context.getBean("tarjeta");

       // ArrayList<CuentaBancaria> cuentas = new ArrayList<>();
        ArrayList arrayList = (ArrayList) context.getBean("arrayList");
        CuentaBancaria cuenta = new CuentaBancaria("sharon", "1996", null, null, 100);
        arrayList.add(cuenta);
        banco.setCuentas(arrayList);


        System.out.println(banco.getCuentas());

    }
}