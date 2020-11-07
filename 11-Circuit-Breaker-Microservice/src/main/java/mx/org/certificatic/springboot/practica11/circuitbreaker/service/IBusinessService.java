package mx.org.certificatic.springboot.practica11.circuitbreaker.service;

import mx.org.certificatic.springboot.practica11.circuitbreaker.controller.model.StatusResponse;

@FunctionalInterface
public interface IBusinessService {

	StatusResponse perform();
}
