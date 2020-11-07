package mx.org.certificatic.springboot.practica15.eventsourcing.events.exception;

public class JournalException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public JournalException(String message) {
		super(message);
	}
}
