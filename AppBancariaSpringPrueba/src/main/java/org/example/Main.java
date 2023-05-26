package org.example;

import org.example.Entity.Banco;
import org.example.Entity.Cliente;
import org.example.Entity.CuentaBancaria;
import org.example.Entity.Tarjeta;
import org.example.Service.BancoService;
import org.example.Service.ClienteService;
import org.example.Service.CuentaBancariaService;
import org.example.Service.TarjetaService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        //BancoService servicioBanco = new BancoService();
        //Banco banco = servicioBanco.crearBancoPreArmado();
        //servicioBanco.menu(banco);

        BancoService bancoService = (BancoService) context.getBean("bancoService");
        CuentaBancariaService cuentaBancariaService = (CuentaBancariaService) context.getBean("cuentaBancariaService");
        ClienteService clienteService = (ClienteService) context.getBean("clienteService");
        TarjetaService tarjetaService = (TarjetaService) context.getBean("tarjetaService");

        Banco banco = (Banco) context.getBean("banco");
        Cliente cliente = (Cliente) context.getBean("cliente");
        CuentaBancaria cuentaBancaria = (CuentaBancaria) context.getBean("cuentaBancaria");
        Tarjeta tarjeta = (Tarjeta) context.getBean("tarjeta");

        Banco bancoArmado = bancoService.crearBancoPreArmado(banco, tarjetaService, tarjeta);
        bancoService.menu(bancoArmado, cuentaBancariaService, clienteService, cliente, tarjetaService, cuentaBancaria, tarjeta);




    }
}