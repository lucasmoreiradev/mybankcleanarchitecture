package br.com.fauker.bank.web;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateAccountForm {

	@NotEmpty
	private String name;

	@NotEmpty
	private String cpf;

	@NotNull
	private LocalDate birth;

	@JsonProperty("initial_balance")
	private Long intitialBalance;
	
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

	public Long getIntitialBalance() {
		return intitialBalance;
	}

	public void setIntitialBalance(Long intitialBalance) {
		this.intitialBalance = intitialBalance;
	}

	@Override
	public String toString() {
		return "CreateAccountForm [name=" + name + ", cpf=" + cpf + ", birth=" + birth + ", intitialBalance="
				+ intitialBalance + "]";
	}

}
