package com.prashhanth.secuirty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableJpaRepositories(basePackageClasses = {UserRepo.class})
public class SecuirtyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecuirtyApplication.class, args);
	}

}
