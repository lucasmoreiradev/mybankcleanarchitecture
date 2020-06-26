package br.com.fauker.bank.port.in;

import br.com.fauker.bank.exception.WithdrawNotAllowdException;

public interface DepositUseCase {
	
	void deposit(DepositRequest depositRequest) throws WithdrawNotAllowdException;
	
}
