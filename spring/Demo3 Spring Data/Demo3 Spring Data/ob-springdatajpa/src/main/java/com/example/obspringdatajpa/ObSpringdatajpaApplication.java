package com.example.obspringdatajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ObSpringdatajpaApplication {

	public static void main(String[] args) {

		//SpringApplication.run(ObSpringdatajpaApplication.class, args);
		ApplicationContext context = SpringApplication.run(ObSpringdatajpaApplication.class, args);

		CacheRepository repository = context.getBean(CacheRepository.class);

		System.out.println("Encontrar");
		//System.out.println("Total de vehiculos es : "+ repository.count());
		System.out.println("------------------");

		//Insertar el vehiculo
		Coche vehiculo = new Coche("BMW", "VC30", 2023);
		repository.save(vehiculo);
		//List<String> autos = (List<String>) new Coche();
		//autos = (List<String>) repository.findAll(new Coche());

		//repository.findAll();
		//System.out.println(repository.findAll(new Coche()));

		Clients cliArg = new Clients("Damian", "Bettini", "Calle");
		repository.save(cliArg);


		//Buscar datos guardados





	}

}
