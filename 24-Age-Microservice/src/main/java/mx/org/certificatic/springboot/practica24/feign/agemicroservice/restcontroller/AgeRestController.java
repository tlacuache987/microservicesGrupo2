package mx.org.certificatic.springboot.practica24.feign.agemicroservice.restcontroller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import mx.org.certificatic.springboot.practica24.feign.agemicroservice.MyListener;
import mx.org.certificatic.springboot.practica24.feign.agemicroservice.client.IRandomServiceClient;

@Slf4j
@RestController
public class AgeRestController {

	@Autowired
	private IRandomServiceClient randomServiceClient;

	@Autowired
	private Environment env;

	@GetMapping("/age")
	public Map<String, Object> age() {

		log.info("sending age");

		Map<String, Object> map = new LinkedHashMap<>();

		map.put("age", randomServiceClient.next().get("random"));
		map.put("from", "http://" + env.getProperty("spring.application.name") + ":" + MyListener.APPLICATION_PORT);

		return map;
	}
}
