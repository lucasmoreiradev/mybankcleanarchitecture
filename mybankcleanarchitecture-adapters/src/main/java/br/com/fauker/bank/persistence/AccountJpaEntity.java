package br.com.fauker.bank.persistence;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "accounts")
public class AccountJpaEntity {

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String name;
	
	@Column
	private String cpf;
	
	@Column
	private LocalDate birth;
	
	@Column
	private Long initialBalance;
	
	@OneToMany
	private List<TransactionJpaEntity> transactions;
	
	public List<TransactionJpaEntity> getTransactions() {
		return Collections.unmodifiableList(transactions);
	}
	
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getBirth() {
		return birth;
	}

	public void setBirth(LocalDate birth) {
		this.birth = birth;
	}

	public Long getInitialBalance() {
		return initialBalance;
	}

	public void setInitialBalance(Long initialBalance) {
		this.initialBalance = initialBalance;
	}	
	
}
