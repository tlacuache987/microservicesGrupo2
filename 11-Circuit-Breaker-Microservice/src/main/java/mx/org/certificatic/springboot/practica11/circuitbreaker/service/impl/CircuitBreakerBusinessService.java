package mx.org.certificatic.springboot.practica11.circuitbreaker.service.impl;

import java.util.function.Supplier;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.vavr.control.Try;
import mx.org.certificatic.springboot.practica11.circuitbreaker.controller.model.StatusResponse;
import mx.org.certificatic.springboot.practica11.circuitbreaker.service.IBusinessService;
import mx.org.certificatic.springboot.practica11.circuitbreaker.service.exception.ServiceException;

public class CircuitBreakerBusinessService implements IBusinessService {

	// Defina Target object IBusinessService businessService
	private IBusinessService proxiedBusinessService;

	// Defina propiedad Circuit Breaker
	private CircuitBreaker circuitBreaker;

	// Defina propiedad Supplier<StatusResponse> decoratedSupplier
	private Supplier<StatusResponse> decoratedSupplier;

	// Inyecte por constructor propiedades IBusinessService businessService, CircuitBreaker circuitBreaker
	// En el constructor decore el Supplier mediante CircuitBreaker.decorateSupplier(this.circuitBreaker, this.businessService::perform);
	public CircuitBreakerBusinessService(IBusinessService proxiedBusinessService, CircuitBreaker circuitBreaker) {
		this.proxiedBusinessService = proxiedBusinessService;
		this.circuitBreaker = circuitBreaker;
		
		this.decoratedSupplier = CircuitBreaker.decorateSupplier(this.circuitBreaker, 
				this.proxiedBusinessService::perform);
	}

	@Override
	public StatusResponse perform() throws ServiceException {
		// implemente
		return Try.ofSupplier(this.decoratedSupplier)
				  .recover(this::fallback)
				  .get();
	}

	// Defina metodo fallback
	public StatusResponse fallback(Throwable ex) {
		return new StatusResponse(200, "DEFAULT RESPONSE");
	}

}
