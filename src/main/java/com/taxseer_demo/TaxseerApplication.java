package com.taxseer_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaxseerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaxseerApplication.class, args);

		System.out.println("Application Started");
	}

}
