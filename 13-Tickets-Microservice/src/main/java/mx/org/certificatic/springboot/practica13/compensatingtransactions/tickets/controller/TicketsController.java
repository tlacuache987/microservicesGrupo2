package mx.org.certificatic.springboot.practica13.compensatingtransactions.tickets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import mx.org.certificatic.springboot.practica13.compensatingtransactions.tickets.appdemo.service.AppDemoService;

@RestController
public class TicketsController {

	@Autowired
	private AppDemoService appDemoService;
	
	@PostMapping("/reserve-ticket")
	public String reserveTicket(@RequestBody TicketReserve ticketReserve) {
		
		appDemoService.reserveTicket(
				ticketReserve.getUser(), 
				ticketReserve.getTicketId(), 
				ticketReserve.getConcert(), 
				ticketReserve.getPlace(),
				ticketReserve.getFolio(),
				ticketReserve.getCost(),
				ticketReserve.getCost() * 0.05D, 
				0D, 
				ticketReserve.getCost() * 1.05D);
		
		return String.format("Ticket Id %s reserved", ticketReserve.getTicketId());
	}
}

@Data
class TicketReserve {
	private String user;
	private int ticketId;
	private String concert;
	private String place;
	private String folio;
	private double cost;
}
