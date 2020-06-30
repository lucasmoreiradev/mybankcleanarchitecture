package br.com.fauker.bank.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NO_CONTENT)
public class NotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

}
