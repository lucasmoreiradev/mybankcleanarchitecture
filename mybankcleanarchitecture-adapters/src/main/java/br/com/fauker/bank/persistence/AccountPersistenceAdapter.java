package br.com.fauker.bank.persistence;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import br.com.fauker.bank.domain.Account;
import br.com.fauker.bank.port.out.GetAccountPort;
import br.com.fauker.bank.port.out.UpdateAccountPort;

@Service
public class AccountPersistenceAdapter implements GetAccountPort, UpdateAccountPort {
	
	private AccountRepository repository;
	private AccountMapper accountMapper;

	public AccountPersistenceAdapter(AccountRepository repository, AccountMapper accountMapper) {
		this.repository = repository;
		this.accountMapper = accountMapper;
	}

	@Override
	public void update(Account account) {
		
	}

	@Override
	public Optional<Account> load(Long accountId) {
		AccountJpaEntity account = repository.findById(accountId).orElseThrow(EntityNotFoundException::new);
		return Optional.ofNullable(accountMapper.toDomainEntity(account));
	}

}
