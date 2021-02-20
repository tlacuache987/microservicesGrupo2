package mx.org.certificatic.springboot.practica23.ribbon.agemicroservice.client;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RandomServiceLoadBalancedRestTemplateClient implements RandomService {

	@Autowired
	private Random random;

	@Override
	public int getRandomValue() {

		log.info("[@LoadBalanced RestTemplate implementation] generating random value from");

		return random.nextInt(40);
	}

}
