package br.com.fauker.bank.web;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fauker.bank.domain.Money;
import br.com.fauker.bank.exception.AccountAlreadyExistsException;
import br.com.fauker.bank.port.in.CreateAccountUseCase;
import br.com.fauker.bank.port.in.CreateAccountUseCase.CreateAccountRequest;

@RestController
public class CreateAccountController {
	
	private CreateAccountUseCase useCase;
	
	public CreateAccountController(CreateAccountUseCase useCase) {
		this.useCase = useCase;
	}

	@PostMapping("/bank/accounts")
	public ResponseEntity<?> create(@RequestBody CreateAccountForm form) throws URISyntaxException {
		try {
			CreateAccountRequest createAccountRequest = new CreateAccountRequest(form.getName(), form.getCpf(),
					form.getBirth(), Money.of(form.getIntitialBalance()));
			Long newAccountId = useCase.create(createAccountRequest);
			return ResponseEntity.created(new URI("http://localhost:8080/accounts/" + newAccountId)).build();
		} catch (AccountAlreadyExistsException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
}
