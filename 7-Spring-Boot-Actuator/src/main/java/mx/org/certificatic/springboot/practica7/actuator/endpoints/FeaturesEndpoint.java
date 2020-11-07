package mx.org.certificatic.springboot.practica7.actuator.endpoints;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import mx.org.certificatic.springboot.practica7.appconfig.Feature;


// define bean component
// define endpoint actuator "features"
public class FeaturesEndpoint {

	@Autowired
	private Map<String, Feature> features;

	// operacion de lectura
	public Map<String, Feature> features() {
		return features;
	}

	// operacion de lectura
	public Feature feature(@Selector String name) {
		return features.get(name);
	}

	// operacion de escritura
	public void configureFeature(@Selector String name, boolean enabled) {
		features.put(name, Feature.builder().name(name).enabled(enabled).build());
	}

	// operacion de borrado
	public void deleteFeature(@Selector String name) {
		features.remove(name);
	}

}