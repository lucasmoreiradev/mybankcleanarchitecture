package br.com.fauker.bank.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.com.fauker.bank.port.in.DepositUseCase;

@WebMvcTest(controllers = BankOperationsController.class)
class BankOperationsControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private DepositUseCase depositUseCase;

	@Test
	void testDeposit() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/bank/deposit/{sourceAccountId}/{targetAccountId}", 1L, 2L).content("100")
				.header("Content-Type", "application/json"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

}
