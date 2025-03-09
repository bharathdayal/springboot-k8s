package com.example.demo;

import com.example.demo.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableCaching
public class DemoApplication {

   //@SpringBootApplication(exclude= {SecurityAutoConfiguration.class,DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})

	public static void main(String[] args) {
		System.out.println("DEMO APP STARTED");

		SpringApplication.run(DemoApplication.class, args);
	}

}
