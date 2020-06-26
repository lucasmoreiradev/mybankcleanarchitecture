package br.com.fauker.bank.port.out;

import br.com.fauker.bank.domain.Account;

public interface UpdateAccountPort {

	void update(Account account);
	
}
