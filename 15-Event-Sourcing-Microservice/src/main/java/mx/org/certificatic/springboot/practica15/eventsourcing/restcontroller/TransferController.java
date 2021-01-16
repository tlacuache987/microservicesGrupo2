package mx.org.certificatic.springboot.practica15.eventsourcing.restcontroller;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.org.certificatic.springboot.practica15.eventsourcing.domain.Account;
import mx.org.certificatic.springboot.practica15.eventsourcing.events.domainevents.MoneyTransferEvent;
import mx.org.certificatic.springboot.practica15.eventsourcing.holder.AccountHolder;
import mx.org.certificatic.springboot.practica15.eventsourcing.processor.DomainEventProcessor;

@RestController
@RequestMapping("/transfer")
public class TransferController {

	@Autowired
	private DomainEventProcessor domainEventProcessor;

	@GetMapping("/from/{tenantFrom}/to/{tenantTo}/amount/{amount}")
	public String accountOf(@PathVariable String tenantFrom,
			@PathVariable String tenantTo,
			@PathVariable BigDecimal amount) {

		// Implementa
		
		Account tenantAccountFrom = AccountHolder.getAccount(tenantFrom);
		Account tenantAccountTo = AccountHolder.getAccount(tenantTo);
		
		if(tenantAccountFrom != null && tenantAccountTo != null){
			
			MoneyTransferEvent moneyTransfer = new MoneyTransferEvent(
					AccountHolder.nextEventId(),
					new Date().getTime(),
					tenantAccountFrom.getAccountNo(),
					tenantAccountTo.getAccountNo(),
					amount);

			domainEventProcessor.process(moneyTransfer);
			
			return String.format("Transfer of $ %s, from %s to %s done !",
					amount, tenantAccountFrom.getOwner(), tenantAccountTo.getOwner());
		}
		
		return "Cannot transfer money !";
	}
}
