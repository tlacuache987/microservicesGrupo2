package mx.org.certificatic.springboot.practica5.services.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import mx.org.certificatic.springboot.practica5.entities.User;
import mx.org.certificatic.springboot.practica5.repositories.UserRepository;
import mx.org.certificatic.springboot.practica5.services.api.IUserService;

// define service, imeplementa IUserService
@Service
public class UserService implements IUserService {
	
	private UserRepository userRepository;
	
	// @Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public Page<User> findPaginated(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	@Override
	public void saveOrUpdate(User user) {
		userRepository.save(user);
	}

	@Override
	public User searchById(long id) {
		// return userRepository.findById(id).orElseGet(() -> null);
		return userRepository.findById(id)
							 .orElseThrow(() -> new IllegalArgumentException("Invalid user Id: " + id));
	}

	@Override
	public void delete(User user) {
		userRepository.delete(user);
	}
}