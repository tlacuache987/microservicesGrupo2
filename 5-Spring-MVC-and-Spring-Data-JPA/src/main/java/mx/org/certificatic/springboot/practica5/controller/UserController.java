package mx.org.certificatic.springboot.practica5.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import mx.org.certificatic.springboot.practica5.entities.User;
import mx.org.certificatic.springboot.practica5.services.impl.UserService;

@Slf4j
// define controller
public class UserController {

	// inyecta UserService por constructor

	
	@GetMapping("/")
	public String index(Model model, @RequestParam("page") Optional<Integer> page,
			@RequestParam("size") Optional<Integer> size) {

		int currentPage = 0;
		int pageSize = 0;
		
		log.info("retrieving page of Users for page: {} of size: {}", currentPage-1, pageSize);

		// Implementa
		
		log.info("going to index view");
		
		return "index";
	}

	@ResponseBody
	@GetMapping("/all")
	public Page<User> all(Model model, @RequestParam("page") Optional<Integer> page,
			@RequestParam("size") Optional<Integer> size) {
		
		int currentPage = 0;
		int pageSize = 0;
		
		log.info("retrieving page of Users for page: {} of size: {}", currentPage-1, pageSize);

		// Implementa

		return null;
	}

	@GetMapping("/add-user-form")
	public String showSignUpForm(User user) {
		
		log.info("going to add-user-form view");
		
		return "add-user-form";
	}

	@PostMapping("/add-user")
	public String addUser(@Valid User user, BindingResult result, Model model) {
		
		// Implementa

		return "redirect:/";
	}

	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		
		log.info("retrieving User with id: {}", id);

		// Implementa
		
		log.info("going to update-user-form view");

		return "update-user-form";
	}

	@PostMapping("/update/{id}")
	public String updateUser(@PathVariable("id") long id, @Valid User user, BindingResult result, Model model) {
		
		// Implementa
		
		log.info("redirecting to '/' path");

		return "redirect:/";
	}

	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		
		// Implementa
		
		log.info("redirecting to '/' path");

		return "redirect:/";
	}
}
