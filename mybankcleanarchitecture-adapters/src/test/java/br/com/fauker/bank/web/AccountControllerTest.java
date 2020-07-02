package br.com.fauker.bank.web;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.com.fauker.bank.persistence.AccountJpaEntity;
import br.com.fauker.bank.persistence.AccountRepository;
import br.com.fauker.bank.port.in.CreateAccountUseCase;

@WebMvcTest(controllers = AccountController.class)
class AccountControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CreateAccountUseCase createAccountUseCase;
	
	@MockBean
	private AccountRepository accountRepository;

	@Test
	void testGetAccount() throws Exception {
		AccountJpaEntity accountJpaEntity = new AccountJpaEntity("Lucas Moreira", "0416342123123", LocalDate.of(1994, 4, 1), 10000L);
		
		Mockito.when(accountRepository.findById(1L)).thenReturn(Optional.ofNullable(accountJpaEntity));
		
		mockMvc.perform(MockMvcRequestBuilders.get("/accounts/{id}", 1L)
				.header("Content-Type", "application/json"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

}
