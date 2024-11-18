package com.codeshuttle.cakebakerapplication.cakebakerapplication;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CakebakerapplicationApplication {

	@Autowired
	private CakeBaker cakeBaker;


	public static void main(String[] args) {

		SpringApplication.run(CakebakerapplicationApplication.class, args);
	}

	@PostConstruct
	public void bake() {
		cakeBaker.bakeCake();
	}

}
