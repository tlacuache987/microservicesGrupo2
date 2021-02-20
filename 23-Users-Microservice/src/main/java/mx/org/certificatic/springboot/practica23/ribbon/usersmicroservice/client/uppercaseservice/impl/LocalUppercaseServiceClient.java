package mx.org.certificatic.springboot.practica23.ribbon.usersmicroservice.client.uppercaseservice.impl;

import java.util.Map;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import mx.org.certificatic.springboot.practica23.ribbon.usersmicroservice.client.uppercaseservice.IUppercaseService;

@Slf4j
//@Service
public class LocalUppercaseServiceClient implements IUppercaseService {

	@Override
	@SneakyThrows
	public String toUppercase(String name, Map<String, String> vars) {

		log.info("generating uppercase value for {}", name);

		vars.put("from-uppercase-service", "LOCAL");

		return name.toUpperCase();
	}

}
