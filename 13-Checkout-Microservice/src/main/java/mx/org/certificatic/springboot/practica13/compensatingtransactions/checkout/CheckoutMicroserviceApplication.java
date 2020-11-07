package mx.org.certificatic.springboot.practica13.compensatingtransactions.checkout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import mx.org.certificatic.springboot.practica13.compensatingtransactions.checkout.appdemo.service.AppDemoService;

@SpringBootApplication
public class CheckoutMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CheckoutMicroserviceApplication.class, args);
	}

	// Inyecte AppDemoService appDemoService;

	// Define bean CommandLineRunner para perfil "reserve-checkout-withdrawal"

}
