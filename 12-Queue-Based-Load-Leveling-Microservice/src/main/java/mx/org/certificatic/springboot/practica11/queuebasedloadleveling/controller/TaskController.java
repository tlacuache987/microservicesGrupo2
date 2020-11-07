package mx.org.certificatic.springboot.practica11.queuebasedloadleveling.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import mx.org.certificatic.springboot.practica11.queuebasedloadleveling.service.ITaskService;

@Slf4j
// Define Rest Controller
public class TaskController {

	// Inyecta ITaskService

	@GetMapping("/{triggeredTasks}")
	public String getResponse(@PathVariable int triggeredTasks) {

		// Implementa
		return null;
	}

}
