package mx.org.certificatic.springboot.practica15.eventsourcing.events.exception;

public class AccountException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AccountException(String message) {
		super(message);
	}
}
