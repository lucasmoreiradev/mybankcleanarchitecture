package br.com.fauker.bank.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import br.com.fauker.bank.domain.Account;
import br.com.fauker.bank.domain.Money;
import br.com.fauker.bank.exception.WithdrawNotAllowdException;
import br.com.fauker.bank.port.in.DepositRequest;
import br.com.fauker.bank.port.out.GetAccountPort;
import br.com.fauker.bank.port.out.UpdateAccountPort;

class DepositServiceTest {
	
	private final GetAccountPort getAccountPort = Mockito.mock(GetAccountPort.class);
	private final UpdateAccountPort updateAccountPort = Mockito.mock(UpdateAccountPort.class);
	
	private final DepositService service = new DepositService(getAccountPort, updateAccountPort);

	@Test
	void shouldDeposit() throws WithdrawNotAllowdException {
		long sourceAccountId = 1L;
		long targetAccountId = 2L;
		
		Account sourceAccount = new Account(sourceAccountId, "Lucas Moreira", "123456", LocalDate.of(1994, 1, 4), Money.of(1000000000L));
		Mockito.when(getAccountPort.load(sourceAccountId)).thenReturn(Optional.ofNullable(sourceAccount));
		
		Account targetAccount = new Account(targetAccountId, "Fulano Brito", "654321", LocalDate.of(1994, 1, 4), Money.of(10L));
		Mockito.when(getAccountPort.load(targetAccountId)).thenReturn(Optional.ofNullable(targetAccount));
		
		DepositRequest depositRequest = new DepositRequest(sourceAccountId, targetAccountId, Money.of(50L));
		service.deposit(depositRequest);
	}
	
	@Test
	void shouldFailtDepositWhenSourceAccountHasNoEnoughMoney() throws WithdrawNotAllowdException {
		WithdrawNotAllowdException exception = assertThrows(WithdrawNotAllowdException.class, () -> {
			long sourceAccountId = 1L;
			long targetAccountId = 2L;
			
			Account sourceAccount = new Account(sourceAccountId, "Lucas Moreira", "123456", LocalDate.of(1994, 1, 4), Money.of(49L));
			Mockito.when(getAccountPort.load(sourceAccountId)).thenReturn(Optional.ofNullable(sourceAccount));
			
			Account targetAccount = new Account(targetAccountId, "Fulano Brito", "654321", LocalDate.of(1994, 1, 4), Money.ZERO);
			Mockito.when(getAccountPort.load(targetAccountId)).thenReturn(Optional.ofNullable(targetAccount));
			
			DepositRequest depositRequest = new DepositRequest(sourceAccountId, targetAccountId, Money.of(50L));
			service.deposit(depositRequest);
		});
		
	    String expectedMessage = "Withdraw not allowed";
	    String actualMessage = exception.getMessage();
	    
	    assertTrue(actualMessage.contains(expectedMessage));
	}


}
