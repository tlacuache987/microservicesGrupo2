package mx.org.certificatic.springboot.practica10.retry.service.impl;

import java.net.URI;

import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import lombok.Setter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import mx.org.certificatic.springboot.practica10.retry.controller.model.StatusResponse;
import mx.org.certificatic.springboot.practica10.retry.service.IBusinessService;
import mx.org.certificatic.springboot.practica10.retry.service.exception.FailingServiceException;

@Slf4j
public class BusinessService implements IBusinessService {
	
	// Define propiedades Rest Template y String failingServiceURL
	private RestTemplate restTemplate;
	private String failingServiceURL;

	
	private @Setter int retries;
	private @Setter int attempts;

	// Inyecta propiedades Rest Template y String failingServiceURL por constructor
	public BusinessService(RestTemplate restTemplate, String failingServiceURL) {
		this.restTemplate = restTemplate;
		this.failingServiceURL = failingServiceURL;
	}

	@SneakyThrows
	@Override
	public StatusResponse perform() {

		// Implementa
		String statusCode = attempts < retries - 1 ? "500" : "200";
		attempts++;
		
		URI uri = new URI(failingServiceURL + statusCode);
		
		try {
			
			return restTemplate.getForObject(uri, StatusResponse.class);
			
		} catch (HttpServerErrorException ex) {
			log.info("URI: {} returns {} status code.", uri.toString(), ex.getRawStatusCode());
			throw new FailingServiceException(ex.getMessage());
		}
	}
}
