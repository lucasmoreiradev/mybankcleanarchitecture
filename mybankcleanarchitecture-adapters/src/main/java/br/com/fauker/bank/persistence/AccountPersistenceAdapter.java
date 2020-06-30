package br.com.fauker.bank.persistence;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import br.com.fauker.bank.domain.Account;
import br.com.fauker.bank.port.out.CreateAccountPort;
import br.com.fauker.bank.port.out.GetAccountPort;
import br.com.fauker.bank.port.out.UpdateAccountPort;

@Service
public class AccountPersistenceAdapter implements GetAccountPort, UpdateAccountPort, CreateAccountPort {
	
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

	@Override
	public Optional<Account> load(String cpf) {
		return repository.findByCpf(cpf).map(account -> {
			return Optional.ofNullable(accountMapper.toDomainEntity(account));
		}).orElse(Optional.empty());
	}

	@Override
	public Long create(Account account) {
		AccountJpaEntity savedAccount = repository.save(accountMapper.toJpaEntity(account));
		return savedAccount.getId();
	}

}
