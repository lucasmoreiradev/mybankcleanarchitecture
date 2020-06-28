package br.com.fauker.bank.port.in;


import javax.validation.constraints.NotNull;

import br.com.fauker.bank.domain.Money;

public class DepositRequest {

	@NotNull
	private final Long sourceAccountId;
	
	@NotNull
	private final Long targetAccountId;
	
	@NotNull
	private final Money money;
	
	public DepositRequest(Long sourceAccountId, Long targetAccountId, Money money) {
		if (!money.isPositive()) {
			throw new IllegalArgumentException("Money should be positive");
		}
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
