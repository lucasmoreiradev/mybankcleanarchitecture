package br.com.fauker.bank.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import br.com.fauker.bank.domain.Account;
import br.com.fauker.bank.domain.Money;
import br.com.fauker.bank.exception.AccountAlreadyExistsException;
import br.com.fauker.bank.port.out.CreateAccountPort;
import br.com.fauker.bank.port.out.GetAccountPort;
import br.com.fauker.bank.port.in.CreateAccountUseCase.CreateAccountRequest;

class CreateAccountServiceTest {
	
	private final GetAccountPort getAccountPort = Mockito.mock(GetAccountPort.class);
	private final CreateAccountPort createAccountPort = Mockito.mock(CreateAccountPort.class);
	
	private final CreateAccountService service = new CreateAccountService(createAccountPort, getAccountPort);

	@Test
	void shouldNotPermitCreateAnAccountWithDuplicatedCpf() {
		AccountAlreadyExistsException exception = assertThrows(AccountAlreadyExistsException.class, () -> {
			Account existingAccount = new Account(1L, "Lucas", "123456", LocalDate.of(1994, 1, 4), Money.of(1000L));
			Mockito.when(getAccountPort.load(existingAccount.getCpf())).thenReturn(Optional.ofNullable(existingAccount));
			
			CreateAccountRequest createAccountRequest = new CreateAccountRequest("Lucas", "123456", LocalDate.of(1994, 1, 4), Money.of(1000L));
			service.create(createAccountRequest);			
		});
		
		String expectedMessage = "There is already an account registered with this CPF";
		String actualMessage = exception.getMessage();
		
		assertTrue(actualMessage.equals(expectedMessage));
	}
	
	@Test
	void shouldCreateAccount() throws AccountAlreadyExistsException {
		CreateAccountRequest createAccountRequest = new CreateAccountRequest("Lucas", "123456", LocalDate.of(1994, 1, 4), Money.of(1000L));
		Mockito.when(getAccountPort.load(createAccountRequest.getCpf())).thenReturn(Optional.empty());
		service.create(createAccountRequest);
	}

}
