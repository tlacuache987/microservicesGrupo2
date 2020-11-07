package mx.org.certificatic.springboot.practica19.log.rabbitlistener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import mx.org.certificatic.springboot.practica19.log.model.User;
import mx.org.certificatic.springboot.practica19.log.repository.UserLogRepository;

@Slf4j
@Component
public class UserCreatedLogRabbitListener {

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private UserLogRepository userLogRepository;

	@SneakyThrows
	// Defina listener RabbitListener
	public void handleUserCreatedEvent(String message) {
		log.info("rabbit listener User Created Log Event");
		// Recupere objeto User
		
		// log.info("event: {}", user);

		// Almacene objeto User

		log.info("--------------------------------------------------------------");
	}
}
