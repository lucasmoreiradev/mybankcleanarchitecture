package br.com.fauker.bank.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.fauker.bank.persistence.AccountJpaEntity;
import br.com.fauker.bank.persistence.AccountRepository;

@RestController
public class AccountController {
	
	private AccountRepository accountRepository;
	
	public AccountController(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@GetMapping("/accounts/{id}")
	public AccountDTO getAccount(@PathVariable("id") Long id) throws NotFoundException {
		AccountJpaEntity accountJpaEntity = accountRepository.findById(id).orElseThrow(NotFoundException::new);
		return toDTO(accountJpaEntity);
	}
	
	private AccountDTO toDTO(AccountJpaEntity accountJpaEntity) {
		return new AccountDTO(accountJpaEntity.getName(), accountJpaEntity.getCpf(), accountJpaEntity.getBirth());
	}
	
}
