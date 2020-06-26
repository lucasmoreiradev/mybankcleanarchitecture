package br.com.fauker.bank.exception;

public class WithdrawNotAllowdException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public WithdrawNotAllowdException() {
		super("Withdraw not allowed");
	}
}
