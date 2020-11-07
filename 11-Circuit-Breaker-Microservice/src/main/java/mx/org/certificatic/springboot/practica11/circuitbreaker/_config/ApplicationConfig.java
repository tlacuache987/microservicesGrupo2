package mx.org.certificatic.springboot.practica11.circuitbreaker._config;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import mx.org.certificatic.springboot.practica11.circuitbreaker.service.IBusinessService;
import mx.org.certificatic.springboot.practica11.circuitbreaker.service.exception.FailingServiceException;
import mx.org.certificatic.springboot.practica11.circuitbreaker.service.impl.BusinessService;
import mx.org.certificatic.springboot.practica11.circuitbreaker.service.impl.CircuitBreakerBusinessService;

@Configuration
public class ApplicationConfig {

	// Define Bean Rest template

	// Inyecta propiedad String failingServiceURL

	// Define Bean IBusinessService noCircuitBreakerBusinessService
	// de tipo concreto BusinessService

	
	
	// Defina Bean CircuitBreakerConfig circuitBreakerConfig
	
	// Defina Bean CircuitBreakerRegistry circuitBreakerRegistry
	
	// Defina Bean CircuitBreaker circuitBreaker
	
	// Define Bean IBusinessService circuitBreakerBusinessService
	// de tipo concreto CircuitBreakerBusinessService



}
