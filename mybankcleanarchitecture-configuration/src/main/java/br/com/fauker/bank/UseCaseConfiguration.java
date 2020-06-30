package br.com.fauker.bank;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.fauker.bank.port.in.CreateAccountUseCase;
import br.com.fauker.bank.port.in.DepositUseCase;
import br.com.fauker.bank.port.out.CreateAccountPort;
import br.com.fauker.bank.port.out.GetAccountPort;
import br.com.fauker.bank.port.out.UpdateAccountPort;
import br.com.fauker.bank.service.CreateAccountService;
import br.com.fauker.bank.service.DepositService;

@Configuration
public class UseCaseConfiguration {

	@Bean
	public DepositUseCase depositUseCase(GetAccountPort getAccountPort, UpdateAccountPort updateAccountPort) {
		return new DepositService(getAccountPort, updateAccountPort);
	}
	
	@Bean
	public CreateAccountUseCase createAccountUseCase(CreateAccountPort createAccountPort, GetAccountPort getAccountPort) {
		return new CreateAccountService(createAccountPort, getAccountPort);
	}
	
}
