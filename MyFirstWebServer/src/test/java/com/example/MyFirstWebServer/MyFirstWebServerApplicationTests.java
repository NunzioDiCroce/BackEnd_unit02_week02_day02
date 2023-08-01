package com.example.MyFirstWebServer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc

class MyFirstWebServerApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void italianRulesShouldReturnCharsetUTF8() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/rules/italian")).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.TEXT_PLAIN_VALUE + ";charset=UTF-8"));
	}

	@Test
	public void englishRulesShouldReturnCharsetUTF8() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/rules/english")).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.TEXT_PLAIN_VALUE + ";charset=UTF-8"));
	}

	@Test
	public void othersRulesShouldReturnCharsetUTF8() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/rules/")).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.TEXT_PLAIN_VALUE + ";charset=UTF-8"));
	}

}
