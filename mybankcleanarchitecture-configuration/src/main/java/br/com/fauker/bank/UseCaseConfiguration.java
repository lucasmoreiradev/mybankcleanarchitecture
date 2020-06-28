package br.com.fauker.bank;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.fauker.bank.port.in.DepositUseCase;
import br.com.fauker.bank.port.out.GetAccountPort;
import br.com.fauker.bank.port.out.UpdateAccountPort;
import br.com.fauker.bank.service.DepositService;

@Configuration
public class UseCaseConfiguration {

	@Bean
	public DepositUseCase depositUseCase(GetAccountPort getAccountPort, UpdateAccountPort updateAccountPort) {
		return new DepositService(getAccountPort, updateAccountPort);
	}
	
}
