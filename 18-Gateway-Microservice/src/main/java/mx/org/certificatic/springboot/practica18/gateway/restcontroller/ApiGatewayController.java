package mx.org.certificatic.springboot.practica18.gateway.restcontroller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import mx.org.certificatic.springboot.practica18.gateway.aggregates.DesktopProductAggregate;
import mx.org.certificatic.springboot.practica18.gateway.aggregates.IProductAggregate;
import mx.org.certificatic.springboot.practica18.gateway.aggregates.MobileProductAggregate;
import mx.org.certificatic.springboot.practica18.gateway.client.ImageMicroserviceClient;
import mx.org.certificatic.springboot.practica18.gateway.client.PriceMicroserviceClient;

// Define RestController
@RestController
public class ApiGatewayController {

	// Implementa
	@Autowired
	private ImageMicroserviceClient imageClient;

	@Autowired
	private PriceMicroserviceClient priceClient;

	@RequestMapping("/desktop")
	public DesktopProductAggregate getProductDesktop() {
		return new DesktopProductAggregate(priceClient.getPrice(), imageClient.getImagePath());
	}

	@RequestMapping("/mobile")
	public MobileProductAggregate getProductMobbile() {
		return new MobileProductAggregate(priceClient.getPrice());
	}

	@RequestMapping("/")
	public IProductAggregate getProduct(@RequestHeader("user-agent") String userAgent) {

		if ("desktop".equals(userAgent))
			return new DesktopProductAggregate(priceClient.getPrice(), imageClient.getImagePath());

		else if ("mobile".equals(userAgent))
			return new MobileProductAggregate(priceClient.getPrice());

		else
			throw new IllegalArgumentException("Unknown user-agent");
	}

	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public Map<?, ?> illegalArgumentExceptionHandler(IllegalArgumentException ex) {
		Map<String, String> map = new HashMap<>();
		map.put("code", HttpStatus.BAD_REQUEST.getReasonPhrase());
		map.put("exception", ex.getClass().getSimpleName());
		map.put("message", ex.getMessage());
		return map;
	}
}
