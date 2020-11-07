package mx.org.certificatic.springboot.practica15.eventsourcing.events.domainevents;

import java.math.BigDecimal;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import mx.org.certificatic.springboot.practica15.eventsourcing.domain.Account;
import mx.org.certificatic.springboot.practica15.eventsourcing.events.DomainEvent;
import mx.org.certificatic.springboot.practica15.eventsourcing.events.exception.AccountException;
import mx.org.certificatic.springboot.practica15.eventsourcing.holder.AccountHolder;

@Data
//descomenta @EqualsAndHashCode(callSuper = true)
//descomenta @ToString(callSuper = true)
public class MoneyWithdrawalEvent /* descomenta extends DomainEvent */ {

	private static final long serialVersionUID = 1L;

	private BigDecimal money;
	private int accountNo;

	// Define constructor

	// @Override
	public void process() {
		// Impementa
	}
}
