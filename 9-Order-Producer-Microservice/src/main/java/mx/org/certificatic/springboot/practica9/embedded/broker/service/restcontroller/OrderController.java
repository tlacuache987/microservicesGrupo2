package mx.org.certificatic.springboot.practica9.embedded.broker.service.restcontroller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.org.certificatic.springboot.practica9.embedded.broker.service.model.Order;
import mx.org.certificatic.springboot.practica9.embedded.broker.service.producer.OrderProducer;

// Define Bean Rest Controller
public class OrderController {

	private static int i = 1;

	// Inyecta OrderProducer

	// Implementa handler method "/place-order"
	
}