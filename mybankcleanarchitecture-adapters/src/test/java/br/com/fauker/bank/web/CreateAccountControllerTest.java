package br.com.fauker.bank.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.com.fauker.bank.port.in.CreateAccountUseCase;
import net.minidev.json.JSONObject;

@WebMvcTest(controllers = CreateAccountController.class)
class CreateAccountControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CreateAccountUseCase createAccountUseCase;

	@Test
	void shouldCreateAccount() throws Exception {
		JSONObject payload = new JSONObject();
		payload.put("name", "Lucas Moreira");
		payload.put("cpf", "12312331");
		payload.put("birth", "1994-04-01");
		payload.put("initial_balance", 1000L);
		
		System.out.println(payload.toString());
		mockMvc.perform(MockMvcRequestBuilders.post("/bank/accounts").content(payload.toString())
				.header("Content-Type", "application/json"))
				.andExpect(MockMvcResultMatchers.status().isCreated());
	}

}
