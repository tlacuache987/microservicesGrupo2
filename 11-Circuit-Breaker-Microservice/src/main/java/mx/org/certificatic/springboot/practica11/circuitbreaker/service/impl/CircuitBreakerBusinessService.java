package mx.org.certificatic.springboot.practica11.circuitbreaker.service.impl;

import java.util.function.Supplier;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.vavr.control.Try;
import mx.org.certificatic.springboot.practica11.circuitbreaker.controller.model.StatusResponse;
import mx.org.certificatic.springboot.practica11.circuitbreaker.service.IBusinessService;
import mx.org.certificatic.springboot.practica11.circuitbreaker.service.exception.ServiceException;

public class CircuitBreakerBusinessService implements IBusinessService {

	// Defina Target object IBusinessService businessService

	// Defina propiedad Circuit Breaker

	// Defina propiedad Supplier<StatusResponse> decoratedSupplier

	// Inyecte por constructor propiedades IBusinessService businessService, CircuitBreaker circuitBreaker
	// En el constructor decore el Supplier mediante CircuitBreaker.decorateSupplier(this.circuitBreaker, this.businessService::perform);

	@Override
	public StatusResponse perform() throws ServiceException {
		
		// implemente
		return null;
	}

	// Defina metodo fallback

}
