package com.example.c23;

import com.example.c23.db.DB;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class C23IntegradoraTpiApplication {

	public static void main(String[] args) throws Exception {

		DB.crearDB();
		SpringApplication.run(C23IntegradoraTpiApplication.class, args);
	}

}
