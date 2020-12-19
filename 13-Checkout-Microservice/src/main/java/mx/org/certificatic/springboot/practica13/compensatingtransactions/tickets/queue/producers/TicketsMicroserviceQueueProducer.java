package mx.org.certificatic.springboot.practica13.compensatingtransactions.tickets.queue.producers;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import mx.org.certificatic.springboot.practica13.compensatingtransactions.tickets.queue.TicketsMicroserviceQueues;
import mx.org.certificatic.springboot.practica13.compensatingtransactions.tickets.queue.event.CancelTicketReservationEvent;

@Slf4j
// Defina Bean de servicio
@Service
public class TicketsMicroserviceQueueProducer {

	// Inyecte JMS Template
	@Autowired
	private JmsTemplate jmsTemplate;

	// Inyecte Supplier<String> secureRandomUUID;
	@Autowired
	private Supplier<String> secureRandomUUID;

	public void cancelTicketReservation(int ticketOrderId) {

		// Implemente
		
		CancelTicketReservationEvent event = new CancelTicketReservationEvent(
				secureRandomUUID.get(), 
				ticketOrderId);

		log.info("---");
		log.info(
				"[Checkout Microservice] sending 'cancel ticket reservation' event for ticket order Id {} to queue {}.",
				event.getTicketOrderId(), TicketsMicroserviceQueues.CANCEL_TICKET_RESERVATION_QUEUE);
		log.info("---");

		jmsTemplate.convertAndSend(TicketsMicroserviceQueues.CANCEL_TICKET_RESERVATION_QUEUE, event);
	}
}