package mx.org.certificatic.springboot.practica15.eventsourcing.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.org.certificatic.springboot.practica15.eventsourcing.events.DomainEvent;

@Component
public class DomainEventProcessor {

	@Autowired
	private JsonFileJournal processorJournal;

	public void process(DomainEvent domainEvent) {

		// Implementa
	}

	public void reset() {
		// Implementa
	}

	public void recover() {

		// Implementa
	}
}
