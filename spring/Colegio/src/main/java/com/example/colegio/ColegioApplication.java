package com.example.colegio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ColegioApplication {

	public static void main(String[] args) {
		ApplicatioContext  context = SpringApplication.run(ColegioApplication.class, args);
	}

}
