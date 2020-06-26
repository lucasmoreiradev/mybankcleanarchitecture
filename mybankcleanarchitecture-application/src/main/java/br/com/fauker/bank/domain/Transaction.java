package br.com.fauker.bank.domain;

import java.time.LocalDateTime;

public class Transaction {
	
	private Long id;
	
	private Long accountId;
	
	private Long targetAccountId;
	
	private Money money;
	
	private LocalDateTime createdAt;
	
	@Deprecated
	public Transaction() {}
	
	public Transaction(Long accountId, Long targetAccountId, Money money) {
		this.accountId = accountId;
		this.targetAccountId = targetAccountId;
		this.money = money;
		this.createdAt = LocalDateTime.now();
	}
	
	public Long getId() {
		return id;
	}
	
	public Long getAccountId() {
		return accountId;
	}
	
	public Long getTargetAccountId() {
		return targetAccountId;
	}
	
	public Money getMoney() {
		return money;
	}
	
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	
}
