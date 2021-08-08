package com.prashhanth.secuirty;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEncryptableProperties
public class SecuirtyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecuirtyApplication.class, args);
	}

}
