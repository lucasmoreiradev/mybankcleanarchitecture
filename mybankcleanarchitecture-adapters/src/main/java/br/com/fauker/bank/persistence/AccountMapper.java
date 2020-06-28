package br.com.fauker.bank.persistence;

import org.springframework.stereotype.Component;

import br.com.fauker.bank.domain.Account;
import br.com.fauker.bank.domain.Money;

@Component
public class AccountMapper {

	Account toDomainEntity(AccountJpaEntity account) {
		return new Account(account.getId(), account.getName(), account.getCpf(), account.getBirth(), Money.of(account.getInitialBalance()));
	}
	
}
