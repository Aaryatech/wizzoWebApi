package com.ats.wizzo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling

public class WizzoWebApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WizzoWebApiApplication.class, args);
	}
}
