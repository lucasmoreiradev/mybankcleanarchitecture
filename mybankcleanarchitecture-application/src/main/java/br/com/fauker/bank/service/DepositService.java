package br.com.fauker.bank.service;

import br.com.fauker.bank.domain.Account;
import br.com.fauker.bank.exception.WithdrawNotAllowdException;
import br.com.fauker.bank.port.in.DepositRequest;
import br.com.fauker.bank.port.in.DepositUseCase;
import br.com.fauker.bank.port.out.GetAccountPort;
import br.com.fauker.bank.port.out.UpdateAccountPort;

public class DepositService implements DepositUseCase {
	
	private GetAccountPort getAccountPort;
	private UpdateAccountPort updateAccountPort;

	public DepositService(GetAccountPort getAccountPort, UpdateAccountPort updateAccountPort) {
		this.getAccountPort = getAccountPort;
		this.updateAccountPort = updateAccountPort;
	}

	@Override
	public void deposit(DepositRequest depositRequest) throws WithdrawNotAllowdException {
		Account sourceAccount = getAccountPort.load(depositRequest.getSourceAccountId()).get();
		Account targetAccount = getAccountPort.load(depositRequest.getTargetAccountId()).get();
		
		sourceAccount.withdraw(depositRequest.getMoney());
		
		targetAccount.deposit(depositRequest.getMoney(), depositRequest.getSourceAccountId(), depositRequest.getTargetAccountId());
		
		updateAccountPort.update(targetAccount);
		updateAccountPort.update(sourceAccount);
	}

}
