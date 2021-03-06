package mx.org.certificatic.springboot.practica23.ribbon.agemicroservice.client;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Primary
@Component
public class RandomServiceClient implements RandomService {

	@Autowired
	private Random random;

	@Override
	public int getRandomValue() {

		log.info("[local implementation] generating random value from");

		return random.nextInt(40);
	}

}
