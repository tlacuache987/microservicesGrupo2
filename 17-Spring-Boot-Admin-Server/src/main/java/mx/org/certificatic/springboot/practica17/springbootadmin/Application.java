package mx.org.certificatic.springboot.practica17.springbootadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
// Enable Spring Boot Admin Server
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
