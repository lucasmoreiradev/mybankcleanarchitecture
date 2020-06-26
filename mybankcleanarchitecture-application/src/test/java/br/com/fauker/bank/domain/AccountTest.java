package br.com.fauker.bank.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.fauker.bank.exception.WithdrawNotAllowdException;

class AccountTest {

	@Test
	void shouldWithdrawWithSuccess() throws WithdrawNotAllowdException {
		Account account = new Account(1L, "Fulano Brito", "12345678999", LocalDate.of(1994, 1, 4), Money.of(1000L));
		account.withdraw(Money.of(1000L));
	}

	@Test
	void shouldThrowExceptionWhenWithdrawIsNotAllowd() {
		WithdrawNotAllowdException exception = assertThrows(WithdrawNotAllowdException.class, () -> {
			Account account = new Account(1L, "Fulano Brito", "12345678999", LocalDate.of(1994, 1, 4), Money.of(10L));
			account.withdraw(Money.of(1000L));
		});
		
	    String expectedMessage = "Withdraw not allowed";
	    String actualMessage = exception.getMessage();
	    
	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	void shouldGetBalanceCorrectly() {
		Account account = new Account(1L, "Fulano Brito", "12345678999", LocalDate.of(1994, 1, 4), Money.of(1000L));
		account.deposit(Money.of(50L), 2L, 1L);
		assertEquals(Money.of(1050L), account.getBalance());
	}

}
