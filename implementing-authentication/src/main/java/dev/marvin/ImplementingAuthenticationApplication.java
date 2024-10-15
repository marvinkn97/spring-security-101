package dev.marvin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class ImplementingAuthenticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImplementingAuthenticationApplication.class, args);
	}

}
