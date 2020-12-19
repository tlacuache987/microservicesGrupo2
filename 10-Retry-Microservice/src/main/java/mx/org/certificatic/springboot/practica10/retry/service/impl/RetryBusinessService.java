package mx.org.certificatic.springboot.practica10.retry.service.impl;

import java.util.concurrent.atomic.AtomicInteger;

import mx.org.certificatic.springboot.practica10.retry.controller.model.StatusResponse;
import mx.org.certificatic.springboot.practica10.retry.service.IBusinessService;
import mx.org.certificatic.springboot.practica10.retry.service.exception.ServiceException;

//Cambie de abstract a final
public final class RetryBusinessService implements IBusinessService {

	// Define propiedad Target Object
	private final IBusinessService proxiedBusinessService;

	private final int maxAttempts;
	private final long delay;
	private final AtomicInteger attempts;

	// Inyecta propiedades por constructor excepto attempts, en el constructor
	// inicializa el atomic integer.
	public RetryBusinessService(IBusinessService proxiedBusinessService, int maxAttempts, 
			long delay) {
		this.proxiedBusinessService = proxiedBusinessService;
		this.maxAttempts = maxAttempts;
		this.delay = delay;
		this.attempts = new AtomicInteger();
	}

	// Define metodo attempts
	public int attempts() {
		return this.attempts.intValue();
	}

	@Override
	public StatusResponse perform() throws ServiceException {
		// Implemente
		do {
			
			try {
				
				return this.proxiedBusinessService.perform();
				
			} catch (ServiceException ex) {
				
				if(this.attempts.incrementAndGet() >= this.maxAttempts) {
					throw ex;
				}
				
				try {
					Thread.sleep(delay);
				} catch (InterruptedException ie) {
					// ignore
				}
			}
			
		} while(true);
		
	}

	// Implementa metodo setRetries
	@Override
	public void setRetries(int retries) {
		this.proxiedBusinessService.setRetries(retries);
	}
	
	// Implementa metodo setAttempts
	@Override
	public void setAttempts(int i) {
		this.proxiedBusinessService.setAttempts(i);
		this.attempts.set(0);
	}

}
