package com.c22.entrenador;

import com.c22.entrenador.dao.DBH2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class C22ServerSpringBootH2Application {

	public static void main(String[] args) {
		DBH2.cargarDB();
		SpringApplication.run(C22ServerSpringBootH2Application.class, args);
	}

}
