package mx.org.certificatic.springboot.practica25.hystrix.sentencemicroservice.client.impl;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import mx.org.certificatic.springboot.practica25.hystrix.sentencemicroservice.client.IVerbServiceClient;

@Slf4j
@Service
public class VerbServiceClient implements IVerbServiceClient {

	@Value("${verb-microservice.service-name:verb-microservice}")
	private String serviceName;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	@SneakyThrows
	// Define comando Hystrix
	public String getVerb() {
		URI uri = new URI(String.format("http://%s/word", serviceName));

		log.info("calling service URI {}", uri.toURL());

		return restTemplate.getForObject(uri, String.class);
	}

	public String defaultVerb(Throwable ex) {
		log.info("Fallback method entered, exception {}: {}", ex.getClass().getSimpleName(), ex.getMessage());
		log.error("exception", ex);
		return "(some verb)";
	}

}
