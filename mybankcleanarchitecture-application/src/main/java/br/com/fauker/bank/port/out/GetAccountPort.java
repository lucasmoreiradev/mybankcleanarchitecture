package br.com.fauker.bank.port.out;

import java.util.Optional;

import br.com.fauker.bank.domain.Account;

public interface GetAccountPort {

	Optional<Account> load(Long accountId);
	
}
