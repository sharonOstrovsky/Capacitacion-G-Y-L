package com.example.AppBancariaSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppBancariaSpringApplication {

	public static void main(String[] args) {

		//SpringApplication.run(AppBancariaSpringApplication.class, args);
		ApplicationContext context = SpringApplication.run(AppBancariaSpringApplication.class, args);


		BancoService servicoBanco = new BancoService();
		Banco banco = servicoBanco.crearBancoPreArmado();
		servicoBanco.menu(banco);
	}

}


/*
public PrincipalServicio( ApplicationContext context) {
        usuarioSv = (UsuarioServicio) context.getBean("usuarioServicio");
        cuentaSv = (CuentaServicio) context.getBean("cuentaServicio");
        usuarios = new ArrayList<>();
    }
 */