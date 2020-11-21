package mx.org.certificatic.springboot.practica1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlumnosController {
	
	@GetMapping("/alumno/{name}")
	public Alumno getAlumno(@PathVariable String name) {
		return new Alumno(name);
	}
	
}
