package mx.org.certificatic.springboot.practica13.compensatingtransactions.tickets.queue.listeners;

import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import mx.org.certificatic.springboot.practica13.compensatingtransactions.checkout.queue.producers.CheckoutMicroserviceQueueProducer;
import mx.org.certificatic.springboot.practica13.compensatingtransactions.tickets.queue.TicketsMicroserviceQueues;
import mx.org.certificatic.springboot.practica13.compensatingtransactions.tickets.queue.event.CancelTicketReservationEvent;
import mx.org.certificatic.springboot.practica13.compensatingtransactions.tickets.queue.event.TicketReservationEvent;

@Slf4j
// Define Bean
@Component
public class TicketsQueueListener {

	@Autowired
	private CheckoutMicroserviceQueueProducer checkoutMicroserviceQueueProducer;

	private boolean ticketReservation = true;

	private boolean ticketReservationCompensation = true;

	// Define JMS Listener de queue TicketsMicroserviceQueues.TICKET_RESERVATION_QUEUE
	@JmsListener(destination = TicketsMicroserviceQueues.TICKET_RESERVATION_QUEUE)
	public void ticketReservation(@Payload TicketReservationEvent reservationEvent,
			@Headers MessageHeaders headers,
			Message message,
			Session session) {

		// Implementa
		
		log.info("---");
		log.info("[Tickets Microservice] applying 'ticket reservation' event for ticket order Id {}.",
				reservationEvent.getTicketOrderId());

		if (!successTicketReservation()) {
			log.info(
					"[Tickets Microservice] 'ticket reservation' for ticket order Id {} process failed nothing to compensate.",
					reservationEvent.getTicketOrderId());
			log.info("---");
		} else {
			log.info("[Tickets Microservice] 'ticket reservation' for ticket order Id {} success!.",
					reservationEvent.getTicketOrderId());
			log.info("---");

			checkoutMicroserviceQueueProducer.reservationCheckoutWithdrawal(
					reservationEvent.getUser(), 
					reservationEvent.getTicketOrderId(),
					reservationEvent.getTotal(), 
					"1234-5678-3456-7890");
		}
	}

	// Define JMS Listener de queue TicketsMicroserviceQueues.CANCEL_TICKET_RESERVATION_QUEUE
	@JmsListener(destination = TicketsMicroserviceQueues.CANCEL_TICKET_RESERVATION_QUEUE)
	public void ticketReservationCompenstation(@Payload CancelTicketReservationEvent reservationEvent,
			@Headers MessageHeaders headers,
			Message message,
			Session session) {

		// Implementa
		
		log.info("---");
		log.info(
				"[Tickets Microservice] applying compensation for 'cancel ticket reservation compensation' event for ticket order Id {}.",
				reservationEvent.getTicketOrderId(), TicketsMicroserviceQueues.CANCEL_TICKET_RESERVATION_QUEUE);

		if (!successTicketReservationCompensation()) {
			log.info(
					"[Tickets Microservice] compensation for 'cancel ticket reservation compensation' event for ticket order Id {} "
					+ "process failed, save event and compensate as soon as possible.", reservationEvent.getTicketOrderId());
			log.info("---");
		} else {
			log.info(
					"[Tickets Microservice] compensation for 'cancel ticket reservation compensation' event for ticket order Id {} "
					+ "success!.", reservationEvent.getTicketOrderId());
			log.info("---");
		}
	}

	private boolean successTicketReservation() {
		return ticketReservation;
	}

	private boolean successTicketReservationCompensation() {
		return ticketReservationCompensation;
	}

}