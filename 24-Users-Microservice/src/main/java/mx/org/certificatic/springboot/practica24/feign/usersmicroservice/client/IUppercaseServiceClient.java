package mx.org.certificatic.springboot.practica24.feign.usersmicroservice.client;

import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;

//Agrega Feign Client
public interface IUppercaseServiceClient {

	// Agrega "/toUppercase/{name}" edpoint mediante Metodo GET.
	public Map<String, Object> toUppercase(@PathVariable String name);
}
