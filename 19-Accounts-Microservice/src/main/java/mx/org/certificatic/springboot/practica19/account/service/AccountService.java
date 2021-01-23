package mx.org.certificatic.springboot.practica19.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import mx.org.certificatic.springboot.practica19.account.events.AccountCreatedEventBuilder;
import mx.org.certificatic.springboot.practica19.account.model.Account;
import mx.org.certificatic.springboot.practica19.account.observer.AccountCreatedListener;
import mx.org.certificatic.springboot.practica19.account.repository.AccountRepository;

@Slf4j
@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;

	// Inyecte la dependencia faltante
	@Autowired
	private ApplicationEventPublisher publisher;

	public void createAccount(Account account) {

		log.info("create account service start");

		accountRepository.save(account);

		log.info("publishing Account Created Event");
		
		// Implemente la logica faltante
		
		publisher.publishEvent(AccountCreatedEventBuilder.build(account));	
	}
	
}
