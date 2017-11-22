package br.com.rooting.roxana.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.rooting.roxana.annotation.EnableRoxana;

@EnableRoxana
@SpringBootApplication
public class TheAmazingBookStoreApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(TheAmazingBookStoreApplication.class, args);
	}
	
}