package br.com.fauker.bank.web;

import java.time.LocalDate;

public class AccountDTO {

	private String name;
	private String cpf;
	private LocalDate birth;
	
	public AccountDTO(String name, String cpf, LocalDate birth) {
		this.name = name;
		this.cpf = cpf;
		this.birth = birth;
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
