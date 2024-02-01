package com.igt.coding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.igt.coding.bets.BetController;

@SpringBootApplication
//@ComponentScan(basePackageClasses = BetController.class)
public class IgtProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(IgtProjectApplication.class, args);
	}

}
