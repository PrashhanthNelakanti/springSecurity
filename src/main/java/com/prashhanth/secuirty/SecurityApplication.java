package com.prashhanth.secuirty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SpringBootApplication
public class SecurityApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SecurityApplication.class);
	}

	public static void main(String[] args) {

		SpringApplication.run(SecurityApplication.class, args);
		Process proc = null;
		try {
			ProcessBuilder pb = new ProcessBuilder("bash", "-c","sh /Users/prashhanthsoujanya/Desktop/CodeSpace/springSecurity/src/main/resources/jenkins.sh");
					Process p = pb.start();
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = null;
			while ((line = reader.readLine()) != null)
			{
				System.out.println(line);
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}

}
