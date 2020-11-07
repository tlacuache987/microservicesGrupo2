package mx.org.certificatic.springboot.practica19.user.observer;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import mx.org.certificatic.springboot.practica19.user.events.UserCreatedEvent;

@Slf4j
@Component
public class UserCreatedListener {

	// Inyecte Bean RabbitTemplate rabbitTemplate.

	// Inyecte Bean FanoutExchange fanoutExchange

	// Inyecte ObjectMapper objectMapper

	@SneakyThrows
	// Manejador de evento UserCreatedEvent
	public void handleUserCreatedEvent(UserCreatedEvent uce) {
		//log.info("sending User Created Event to {}", fanoutExchange.getName());

		// Implemente
		
		log.info("--------------------------------------------------------------");
	}
}
