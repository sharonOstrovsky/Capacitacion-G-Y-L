package org.example.Service;


import org.example.Entity.Banco;
import org.example.Entity.Cliente;
import org.example.Entity.CuentaBancaria;
import org.example.Entity.Tarjeta;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Scanner;

@Component
public class BancoService {


    //CuentaBancariaService cuentaServicio = new CuentaBancariaService();
    //CuentaBancariaService cuentaBancariaService = (CuentaBancariaService) context.getBean("cuentaBancariaService");

    //ClienteService clienteServicio = new ClienteService();
    //ClienteService clienteService = (ClienteService) context.getBean("clienteService");

    //TarjetaService tarjetaServicio = new TarjetaService();
    //TarjetaService tarjetaService = (TarjetaService) context.getBean("tarjetaService");

    public Banco crearBanco(Tarjeta tarjeta, CuentaBancaria cuentaBancaria,TarjetaService tarjetaService , Cliente cliente, ClienteService clienteService,CuentaBancariaService cuentaBancariaService, Banco banco){

        //Banco banco = new Banco();
        //Banco banco = (Banco) context.getBean("banco");
        ArrayList<CuentaBancaria> cuentas = new ArrayList<>();

        while(cuentas.size() != 10){
            Cliente clienteCreado = clienteService.crearCliente(cliente);

            if(esMayorEdad(clienteCreado)){
                CuentaBancaria cuenta = cuentaBancariaService.crearCuenta(tarjeta, clienteCreado, tarjetaService, cuentaBancaria);
                cuentas.add(cuenta);
            }
        }

        banco.setCuentas(cuentas);

        return banco;
    }

    public Banco crearBancoPreArmado(Banco banco, TarjetaService tarjetaService, Tarjeta tarjeta){
        //Banco banco = new Banco();
       // Banco banco = (Banco) context.getBean("banco");
        ArrayList<CuentaBancaria> cuentas = new ArrayList<>();

        Cliente cliente1 = new Cliente("Sharon","Ostrovsky", 39915620, 26,"sharonostro@gmail.com","Boyaca 1853", "Argentina" );
        Cliente cliente2 = new Cliente("Carlos", "Garcia", 18348704, 56, "carlosgrcia@gmail.com", "calle 123", "Argentina");
        Cliente cliente3 = new Cliente("Federico", "Lillo", 384789546, 21, "federico@gmail.com", "calle 4563", "Argentina");
        Cliente cliente4 = new Cliente("Matias", "Perez", 35684567, 29, "matias@hotmail.com", "calle 475", "Argentina" );
        Cliente cliente5 = new Cliente("Gaston", "Prieto", 27364528, 35, "gaston@gmail.com", "calle 987", "Argentina");
        Cliente cliente6 = new Cliente("Patricia", "Dascal", 18098700, 57, "patriciadascal@hotmail.com", "calle 534", "Argentina");
        Cliente cliente7 = new Cliente("Aylen", "Hasman", 40394283, 25, "aylen@gmail.com", "calle 324", "Argentina");
        Cliente cliente8 = new Cliente("Alex", "Harazski", 43233454,23,"alex@gmail.com", "calle 533", "Argentina" );
        Cliente cliente9 = new Cliente("Nicolas", "Garbiero", 20348563, 34, "nicolas@hotmail.com", "calle 434", "Argentina");
        Cliente cliente10 = new Cliente("Alejandra", "Flons", 17345436, 65, "alejandra@hotmail.com", "calle 333", "Argentina");

        CuentaBancaria cuenta1 = new CuentaBancaria("sharon", "sharon", cliente1, tarjetaService.crearTarjeta(tarjeta), 100000);
        CuentaBancaria cuenta2 = new CuentaBancaria("carlos", "carlos", cliente2, tarjetaService.crearTarjeta(tarjeta), 150000);
        CuentaBancaria cuenta3 = new CuentaBancaria("federico", "federico", cliente3, tarjetaService.crearTarjeta(tarjeta), 300000 );
        CuentaBancaria cuenta4 = new CuentaBancaria("m", "m", cliente4, tarjetaService.crearTarjeta(tarjeta), 20000);
        CuentaBancaria cuenta5 = new CuentaBancaria("g", "g", cliente5, tarjetaService.crearTarjeta(tarjeta), 150000);
        CuentaBancaria cuenta6 = new CuentaBancaria("p", "p", cliente6, tarjetaService.crearTarjeta(tarjeta), 50000);
        CuentaBancaria cuenta7 = new CuentaBancaria("aylen", "aylen", cliente7, tarjetaService.crearTarjeta(tarjeta), 40000);
        CuentaBancaria cuenta8 = new CuentaBancaria("alex","alex", cliente8, tarjetaService.crearTarjeta(tarjeta), 60000 );
        CuentaBancaria cuenta9 = new CuentaBancaria("n", "n", cliente9, tarjetaService.crearTarjeta(tarjeta), 70000);
        CuentaBancaria cuenta10 = new CuentaBancaria("a", "a", cliente10, tarjetaService.crearTarjeta(tarjeta), 10000);

        cuentas.add(cuenta1);
        cuentas.add(cuenta2);
        cuentas.add(cuenta3);
        cuentas.add(cuenta4);
        cuentas.add(cuenta5);
        cuentas.add(cuenta6);
        cuentas.add(cuenta7);
        cuentas.add(cuenta8);
        cuentas.add(cuenta9);
        cuentas.add(cuenta10);

        banco.setCuentas(cuentas);

        return banco;

    }


    public void menu(Banco banco, CuentaBancariaService cuentaBancariaService, ClienteService clienteService, Cliente cliente, TarjetaService tarjetaService, CuentaBancaria cuentaBancaria, Tarjeta tarjeta){

        boolean salirDelMenuBanco = false;

        System.out.println("");
        System.out.println("----------BIENVENIDO/A AL BANCO----------");
        System.out.println("");


            do{
                System.out.println("¿Ingresar o Registrarse?");
                String rta = librerias.Validaciones.validarIngresoCadena();
                if(opcionesRegistrar(rta)){
                    registrarse(banco, cuentaBancariaService, clienteService, cliente, tarjetaService, cuentaBancaria, tarjeta);
                }else if(opcionesIngresar(rta)){
                    cuentaBancariaService.ingresarACuenta(banco.getCuentas());
                }else{
                    System.out.println("opcion no valida");
                }
                System.out.println("Desea salir? (s/n)");
                String salir = librerias.Validaciones.validarIngresoCadena();
                if(opcionesSalir(salir)) {
                    salirDelMenuBanco = true;
                }

            }while(!salirDelMenuBanco);
                System.out.println("");
                System.out.println("----------VUELVA PRONTO----------");
                System.out.println("");

    }


    private void registrarse(Banco banco, CuentaBancariaService cuentaBancariaService, ClienteService clienteService, Cliente cliente, TarjetaService tarjetaService, CuentaBancaria cuentaBancaria, Tarjeta tarjeta){
        System.out.println("");
        System.out.println("----------REGISTRARSE----------");
        System.out.println("");

        ArrayList<CuentaBancaria> cuentasAux = new ArrayList<>();
        Cliente clienteCreado = clienteService.crearCliente(cliente);
        if(!esMayorEdad(clienteCreado)){
            System.out.println("Lo siento, debe ser mayor de edad para crear una cuenta");
        }else{
            CuentaBancaria cuenta = cuentaBancariaService.crearCuenta(tarjeta, clienteCreado, tarjetaService, cuentaBancaria);
            cuentasAux = banco.getCuentas();
            cuentasAux.add(cuenta);
            banco.setCuentas(cuentasAux);
        }


        System.out.println("");
        System.out.println("----------CUENTA REGISTRADA----------");
        System.out.println("");
    }


    private boolean esMayorEdad(Cliente cliente){
        int edad = cliente.getEdad();
        return edad >= 18;
    }

    private boolean opcionesRegistrar(String ingresoUsuario){
        return ingresoUsuario.equalsIgnoreCase("registrarse") || ingresoUsuario.equalsIgnoreCase("r");
    }

    private boolean opcionesIngresar(String ingresoUsuario){
        return ingresoUsuario.equalsIgnoreCase("ingresar") || ingresoUsuario.equalsIgnoreCase("i");
    }

    private boolean opcionesSalir(String ingresoUsuario){
        return ingresoUsuario.equalsIgnoreCase("si") || ingresoUsuario.equalsIgnoreCase("s");
    }
}


