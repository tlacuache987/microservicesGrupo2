package mx.org.certificatic.springboot.practica24.feign.usersmicroservice.client;

import java.util.Map;

//Agrega Feign Client
public interface IAgeServiceClient {

	// Agrega "/age" edpoint mediante Metodo GET.
	public Map<String, Object> age();
}