package com.example.movieEureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MovieEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieEurekaApplication.class, args);
	}

}
