package mx.org.certificatic.springboot.practica10.retry.service;

import mx.org.certificatic.springboot.practica10.retry.controller.model.StatusResponse;

public interface IBusinessService {

	StatusResponse perform();

	// Just for test
	void setRetries(int retries);

	// Just for test
	void setAttempts(int i);
}
