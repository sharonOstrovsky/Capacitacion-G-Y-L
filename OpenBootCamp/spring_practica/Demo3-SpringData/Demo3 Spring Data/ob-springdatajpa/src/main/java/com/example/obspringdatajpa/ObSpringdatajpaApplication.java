package com.example.obspringdatajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ObSpringdatajpaApplication {

	public static void main(String[] args) {

		//SpringApplication.run(ObSpringdatajpaApplication.class, args);
		ApplicationContext context = SpringApplication.run(ObSpringdatajpaApplication.class, args);

		CocheRepository repository = context.getBean(CocheRepository.class);

		System.out.println("Encontrar");
		System.out.println("Total de vehiculos es : "+ repository.count());
		System.out.println("------------------");

		//Insertar el vehiculo
		Coche mazda = new Coche(null, "Mazda", "CX30", 2022);
		repository.save(mazda);

		//Buscar datos guardados
		System.out.println(repository.findAll());

	}

}
