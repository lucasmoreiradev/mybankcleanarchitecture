package br.com.fauker.bank.exception;

public class AccountAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 4315700382191281567L;

	public AccountAlreadyExistsException(String cpf) {
		super("There is already an account registered with this CPF");
	}
	
}
