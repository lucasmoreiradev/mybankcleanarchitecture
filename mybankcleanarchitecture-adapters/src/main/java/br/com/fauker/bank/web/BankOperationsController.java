package br.com.fauker.bank.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fauker.bank.domain.Money;
import br.com.fauker.bank.exception.WithdrawNotAllowdException;
import br.com.fauker.bank.port.in.DepositUseCase;
import br.com.fauker.bank.port.in.DepositUseCase.DepositRequest;

@RestController
public class BankOperationsController {
	
	private final DepositUseCase depositUseCase;
	
	private BankOperationsController(DepositUseCase depositUseCase) {
		this.depositUseCase = depositUseCase;
	}
	
	@PostMapping("/bank/deposit/{sourceAccountId}/{targetAccountId}")
	public ResponseEntity<?> deposit(@PathVariable("sourceAccountId") Long sourceAccountId,
			@PathVariable("targetAccountId") Long targetAccountId, @RequestBody Long amount) {
		DepositRequest depositRequest = new DepositRequest(sourceAccountId, targetAccountId, Money.of(amount));
		
		try {
			depositUseCase.deposit(depositRequest);
		} catch (WithdrawNotAllowdException e) {
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
		}
		
		return ResponseEntity.ok().build();
	}
}
