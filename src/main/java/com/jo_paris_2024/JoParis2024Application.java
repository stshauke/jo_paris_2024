package com.jo_paris_2024;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JoParis2024Application {

	public static void main(String[] args) {
		SpringApplication.run(JoParis2024Application.class, args);}
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	
}
}
