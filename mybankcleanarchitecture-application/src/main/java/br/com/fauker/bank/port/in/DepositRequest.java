package br.com.fauker.bank.port.in;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import br.com.fauker.bank.domain.Money;

public class DepositRequest {

	private final Long sourceAccountId;
	
	private final Long targetAccountId;
	
	private final Money money;
	
	public DepositRequest(Long sourceAccountId, Long targetAccountId, Money money) {
		assertNotNull("Source Account id is required", sourceAccountId);
		assertNotNull("Target Account id is required", targetAccountId);
		assertTrue(money.isPositive(), "The money should be greather than zero!");
		this.sourceAccountId = sourceAccountId;
		this.targetAccountId = targetAccountId;
		this.money = money;
	}

	public Long getSourceAccountId() {
		return sourceAccountId;
	}
	
	public Long getTargetAccountId() {
		return targetAccountId;
	}
	
	public Money getMoney() {
		return money;
	}
	
}
