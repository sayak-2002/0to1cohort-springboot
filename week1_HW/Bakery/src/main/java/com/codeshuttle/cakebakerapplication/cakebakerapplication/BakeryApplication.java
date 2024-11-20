package com.codeshuttle.cakebakerapplication.cakebakerapplication;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BakeryApplication implements CommandLineRunner {

	@Autowired
	private CakeBaker cakeBaker;


	public static void main(String[] args) {

		SpringApplication.run(BakeryApplication.class, args);
	}


	@Override
	public void run(String... args) {
		cakeBaker.bakeCake();
	}

	@PostConstruct
	public void bake() {
		cakeBaker.bakeCake();
	}

}
