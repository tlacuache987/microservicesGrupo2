package mx.org.certificatic.springboot.practica15.eventsourcing.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.org.certificatic.springboot.practica15.eventsourcing.holder.AccountHolder;
import mx.org.certificatic.springboot.practica15.eventsourcing.processor.DomainEventProcessor;

@RestController
public class SystemController {

	@Autowired
	private DomainEventProcessor domainEventProcessor;

	@GetMapping("/recover/transactions")
	public String recover() {

		// Implementa
		AccountHolder.resetState();
		
		domainEventProcessor.recover();
		
		return "System recovered !";
	}

	@GetMapping("/reset/soft/transactions")
	public String softReset() {

		// Implementa
		AccountHolder.resetState();

		return "System had soft reset";
	}

	@GetMapping("/reset/hard/transactions")
	public String hardReset() {

		// Implementa
		AccountHolder.resetState();
		domainEventProcessor.reset();

		return "System had hard reset";
	}
}
