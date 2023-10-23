package com.tpi.tpf;

import com.tpi.tpf.db.DB;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TpfApplication {

	public static void main(String[] args) throws Exception {
		DB.crearDB();
		SpringApplication.run(TpfApplication.class, args);
	}

}
