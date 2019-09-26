package br.com.gsstrozi.camel.training.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("br.com.gsstrozi.camel")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
