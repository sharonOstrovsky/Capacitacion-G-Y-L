package Service;

import Entity.Banco;
import Entity.Cliente;
import Entity.CuentaBancaria;

import java.util.ArrayList;
import java.util.Scanner;


public class BancoService {

    CuentaBancariaService cuentaServicio = new CuentaBancariaService();
    ClienteService clienteServicio = new ClienteService();
    TarjetaService tarjetaServicio = new TarjetaService();


    public Banco crearBanco(){

        Banco banco = new Banco();
        ArrayList<CuentaBancaria> cuentas = new ArrayList<>();

        while(cuentas.size() != 10){
            Cliente cliente = clienteServicio.crearCliente();
            if(esMayorEdad(cliente)){
                CuentaBancaria cuenta = cuentaServicio.crearCuenta(cliente);
                cuentas.add(cuenta);
            }
        }

        banco.setCuentas(cuentas);

        return banco;
    }

    public Banco crearBancoPreArmado(){
        Banco banco = new Banco();
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

        CuentaBancaria cuenta1 = new CuentaBancaria("sharon", "sharon", cliente1, tarjetaServicio.crearTarjeta(), 100000);
        CuentaBancaria cuenta2 = new CuentaBancaria("carlos", "carlos", cliente2, tarjetaServicio.crearTarjeta(), 150000);
        CuentaBancaria cuenta3 = new CuentaBancaria("federico", "federico", cliente3, tarjetaServicio.crearTarjeta(), 300000 );
        CuentaBancaria cuenta4 = new CuentaBancaria("m", "m", cliente4, tarjetaServicio.crearTarjeta(), 20000);
        CuentaBancaria cuenta5 = new CuentaBancaria("g", "g", cliente5, tarjetaServicio.crearTarjeta(), 150000);
        CuentaBancaria cuenta6 = new CuentaBancaria("p", "p", cliente6, tarjetaServicio.crearTarjeta(), 50000);
        CuentaBancaria cuenta7 = new CuentaBancaria("aylen", "aylen", cliente7, tarjetaServicio.crearTarjeta(), 40000);
        CuentaBancaria cuenta8 = new CuentaBancaria("alex","alex", cliente8, tarjetaServicio.crearTarjeta(), 60000 );
        CuentaBancaria cuenta9 = new CuentaBancaria("n", "n", cliente9, tarjetaServicio.crearTarjeta(), 70000);
        CuentaBancaria cuenta10 = new CuentaBancaria("a", "a", cliente10, tarjetaServicio.crearTarjeta(), 10000);

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


    public void menu(Banco banco){

        boolean salirDelMenuBanco = false;

        System.out.println("");
        System.out.println("----------BIENVENIDO/A AL BANCO----------");
        System.out.println("");


            do{
                System.out.println("¿Ingresar o Registrarse?");
                String rta = librerias.Validaciones.validarIngresoCadena();
                if(opcionesRegistrar(rta)){
                    registrarse(banco);
                }else if(opcionesIngresar(rta)){
                    cuentaServicio.ingresarACuenta(banco.getCuentas());
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


    private void registrarse(Banco banco){
        System.out.println("");
        System.out.println("----------REGISTRARSE----------");
        System.out.println("");

        ArrayList<CuentaBancaria> cuentasAux = new ArrayList<>();
        Cliente cliente = clienteServicio.crearCliente();
        if(!esMayorEdad(cliente)){
            System.out.println("Lo siento, debe ser mayor de edad para crear una cuenta");
        }else{
            CuentaBancaria cuenta = cuentaServicio.crearCuenta(cliente);
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


