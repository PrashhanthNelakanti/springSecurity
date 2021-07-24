package com.prashhanth.secuirty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEncryptableProperties
public class SecuirtyApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SecuirtyApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(SecuirtyApplication.class, args);
	}

}
