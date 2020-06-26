package br.com.fauker.bank.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.fauker.bank.exception.WithdrawNotAllowdException;

public class Account {
	
	private Long id;
	
	private String name;
	
	private String cpf;
	
	private LocalDate birth;
	
	private List<Transaction> transactions = new ArrayList<>();

	private Money initialBalance;

	@Deprecated
	public Account() {}
	
	public Account(Long id, String name, String cpf, LocalDate birth, Money initialBalance) {
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.birth = birth;
		this.initialBalance = initialBalance;
	}

	public void deposit(Money money, Long sourceAccountId, Long targetAccountId) {
		this.transactions.add(new Transaction(sourceAccountId, targetAccountId, money));
	}
	
	public void withdraw(Money money) throws WithdrawNotAllowdException {
		if (!canWithdraw(money)) {
			throw new WithdrawNotAllowdException();
		}
		this.transactions.add(new Transaction(this.id, this.id, money));
	}
	
	public Money getBalance() {
		return Money.add(initialBalance, transactions.stream().map(Transaction::getMoney).reduce(Money.ZERO, Money::add));
	}
	
	private boolean canWithdraw(Money money) {
		return getBalance().isGreaterThan(money);
	}
	
	public String getName() {
		return name;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public LocalDate getBirth() {
		return birth;
	}
	
}
