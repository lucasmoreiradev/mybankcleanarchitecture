package br.com.fauker.bank.service;

import br.com.fauker.bank.domain.Account;
import br.com.fauker.bank.exception.AccountAlreadyExistsException;
import br.com.fauker.bank.port.in.CreateAccountUseCase;
import br.com.fauker.bank.port.out.CreateAccountPort;
import br.com.fauker.bank.port.out.GetAccountPort;

public class CreateAccountService implements CreateAccountUseCase {
	
	private CreateAccountPort createAccountPort;
	private GetAccountPort getAccountPort;

	public CreateAccountService(CreateAccountPort createAccountPort, GetAccountPort getAccountPort) {
		this.createAccountPort = createAccountPort;
		this.getAccountPort = getAccountPort;
	}

	@Override
	public Long create(CreateAccountRequest createAccountRequest) throws AccountAlreadyExistsException {
		if (getAccountPort.load(createAccountRequest.getCpf()).isPresent()) {
			throw new AccountAlreadyExistsException(createAccountRequest.getCpf());
		}
		return createAccountPort.create(new Account(createAccountRequest.getName(), createAccountRequest.getCpf(), createAccountRequest.getBirth(), createAccountRequest.getInitialBalance()));
	}

}
