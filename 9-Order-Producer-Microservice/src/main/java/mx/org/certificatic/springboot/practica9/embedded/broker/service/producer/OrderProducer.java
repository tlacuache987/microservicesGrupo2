package mx.org.certificatic.springboot.practica9.embedded.broker.service.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import mx.org.certificatic.springboot.practica9.embedded.broker.service._config.ActiveMQConfig;
import mx.org.certificatic.springboot.practica9.embedded.broker.service.model.Order;

@Slf4j
// Define como Bean de Servicio
public class OrderProducer {

	// Injecta JMS Template

	public void send(Order order) {
		log.info("sending order {} to queue {}.", order.getId(), /* Cola ORDER_QUEUE */ null);
		// Envia el mensaje order mediante jms template a la cola ORDER_QUEUE
	}
}