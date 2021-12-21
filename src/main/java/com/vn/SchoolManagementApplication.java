package com.vn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.vn.properties.AppProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class SchoolManagementApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SchoolManagementApplication.class, args);
	}

	@Autowired
	AppProperties appProperties;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Global variable: ");
		System.out.println("\t App name: " + appProperties.getName());
		System.out.println("\t Created date: " + appProperties.getCreatedDate());
	}
}
