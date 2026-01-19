package com.dev; // It should be here not here com.markdev.app

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


//@EnableJpaRepositories(basePackages = "com.markdev.repository")
//@EntityScan(basePackages = "com.markdev.model")
//@SpringBootApplication(scanBasePackages = "com.markdev")

@SpringBootApplication
public class SpringbootApp implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootApp.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("\nYour application is now running!\n");
		
		
	}
}
