package br.com.fauker.bank.persistence;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "transactions")
public class TransactionJpaEntity {

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "source_account_id")
	private AccountJpaEntity sourceAccount;
	
	@ManyToOne
	@JoinColumn(name = "target_account_id")
	private AccountJpaEntity targetAccountId;
	
	@Column
	private Long amount;
	
	@Column(name = "created_at")
	private LocalDateTime createdAt = LocalDateTime.now();

	public Long getId() {
		return id;
	}

	public AccountJpaEntity getSourceAccount() {
		return sourceAccount;
	}

	public void setSourceAccount(AccountJpaEntity sourceAccount) {
		this.sourceAccount = sourceAccount;
	}

	public AccountJpaEntity getTargetAccountId() {
		return targetAccountId;
	}

	public void setTargetAccountId(AccountJpaEntity targetAccountId) {
		this.targetAccountId = targetAccountId;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	
}
