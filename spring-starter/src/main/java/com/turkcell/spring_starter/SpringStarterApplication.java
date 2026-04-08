package com.turkcell.spring_starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //Annotation => Bulunduğu class,fonk,değişkene özellik kazandıran yapıdır.springBootApplication => Spring Boot uygulaması olduğunu belirtir.
public class SpringStarterApplication {
     //Entrypoint
	public static void main(String[] args) {
		SpringApplication.run(SpringStarterApplication.class, args);
	}

}
