package com.wynk.project.lazyserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan({ "com.wynk.project" })
public class LazyServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LazyServerApplication.class, args);
	}
}
