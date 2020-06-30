package br.com.fauker.bank.port.in;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.fauker.bank.domain.Money;
import br.com.fauker.bank.exception.AccountAlreadyExistsException;

public interface CreateAccountUseCase {
	
	Long create(CreateAccountRequest createAccountRequest) throws AccountAlreadyExistsException;

	public class CreateAccountRequest {

		@NotEmpty
		private String name;

		@NotEmpty
		private String cpf;

		@NotNull
		private LocalDate birth;

		@NotNull
		private Money initialBalance;

		public CreateAccountRequest(@NotEmpty String name, @NotEmpty String cpf, @NotNull LocalDate birth,
				@NotNull Money initialBalance) {
			this.name = name;
			this.cpf = cpf;
			this.birth = birth;
			this.initialBalance = initialBalance;
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

		public Money getInitialBalance() {
			return initialBalance;
		}

		@Override
		public String toString() {
			return "CreateAccountRequest [name=" + name + ", cpf=" + cpf + ", birth=" + birth + ", initialBalance="
					+ initialBalance + "]";
		}

	}

}
