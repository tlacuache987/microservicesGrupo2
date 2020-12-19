package mx.org.certificatic.springboot.practica13.compensatingtransactions.checkout.queue.producers;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import mx.org.certificatic.springboot.practica13.compensatingtransactions.checkout.queue.CheckoutMicroserviceQueues;
import mx.org.certificatic.springboot.practica13.compensatingtransactions.checkout.queue.event.ReservationCheckoutWithdrawalEvent;

@Slf4j
// Define Bean de servicio
@Service
public class CheckoutMicroserviceQueueProducer {

	// Inyecta JMS Template
	@Autowired
	private JmsTemplate jmsTemplate;

	// Inyecta Supplier<String> secureRandomUUID
	@Autowired
	private Supplier<String> secureRandomUUID;

	public void reservationCheckoutWithdrawal(String user, int ticketOrderId, double amount, String creditCardNumber) {

		// Implementa
		
		ReservationCheckoutWithdrawalEvent event = new ReservationCheckoutWithdrawalEvent(
				secureRandomUUID.get(), user, ticketOrderId, amount, creditCardNumber);

		log.info("---");
		log.info(
				"[Tickets Microservice] sending 'reservation checkout withdrawal' event for ticket order Id {} to queue {}.",
				event.getTicketOrderId(), CheckoutMicroserviceQueues.RESERVE_WITHDRAWAL_QUEUE);
		log.info("---");
		
		jmsTemplate.convertAndSend(CheckoutMicroserviceQueues.RESERVE_WITHDRAWAL_QUEUE, event);
	}
	
}