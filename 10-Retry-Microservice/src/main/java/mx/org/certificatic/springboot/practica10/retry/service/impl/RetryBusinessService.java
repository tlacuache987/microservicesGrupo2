package mx.org.certificatic.springboot.practica10.retry.service.impl;

import java.util.concurrent.atomic.AtomicInteger;

import mx.org.certificatic.springboot.practica10.retry.controller.model.StatusResponse;
import mx.org.certificatic.springboot.practica10.retry.service.IBusinessService;
import mx.org.certificatic.springboot.practica10.retry.service.exception.ServiceException;

//Cambie de abstract a final
public abstract class RetryBusinessService implements IBusinessService {

	// Define propiedad Target Object

	private final int maxAttempts = 0;
	private final long delay = 0;
	private final AtomicInteger attempts = null;

	// Inyecta propiedades por constructor excepto attempts, en el constructor
	// inicializa el atomic integer.
	

	// Define metodo attempts

	@Override
	public StatusResponse perform() throws ServiceException {
		// Implemente
		return null;
	}

	// Implementa metodo setRetries
	
	// Implementa metodo setAttempts
}
