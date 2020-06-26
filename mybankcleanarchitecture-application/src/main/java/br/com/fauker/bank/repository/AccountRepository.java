package br.com.fauker.bank.repository;

import java.util.Optional;

import br.com.fauker.bank.domain.Account;

public interface AccountRepository {

	Account save(Account account);
	
	Optional<Account> findById(Long id);
	
}
