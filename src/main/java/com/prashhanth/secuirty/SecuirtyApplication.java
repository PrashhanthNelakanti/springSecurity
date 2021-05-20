package com.prashhanth.secuirty;

import com.prashhanth.secuirty.repo.UserRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {UserRepo.class})
public class SecuirtyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecuirtyApplication.class, args);
	}

}
