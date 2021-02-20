package mx.org.certificatic.springboot.practica23.ribbon.usersmicroservice.client.uppercaseservice.impl;

import java.net.URI;
import java.net.URLEncoder;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import mx.org.certificatic.springboot.practica23.ribbon.usersmicroservice.client.uppercaseservice.IUppercaseService;

@Slf4j
//@Service
public class UppercaseServiceClientRestTemplateLoadBalanced implements IUppercaseService {

	@Autowired
	private RestTemplate loadBalancedRestTemplate;

	@Value("${uppercase-service-name:uppercase-microservice}")
	private String serviceName;

	@Override
	@SneakyThrows
	public String toUppercase(String name, Map<String, String> vars) {
		
		name = URLEncoder.encode(name, "UTF-8").replace("+", "%20");

		// build URI using service-name
		URI uri = URI.create(String.format("http://%s/uppercase-service/toUppercase/%s", serviceName, name));

		// getting map from loadBalanced RestTemplate
		Map<String, Object> mapResponse = loadBalancedRestTemplate.getForObject(uri, Map.class);

		log.info("Service: {}, response: {}", serviceName, mapResponse);

		vars.put("from-uppercase-service", mapResponse.get("from").toString());

		return (String) mapResponse.get("uppercase");
	}

}
