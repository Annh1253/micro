package com.example.productservice;

import com.example.productservice.dto.ProductDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.TestExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;

@SpringBootTest
class ProductServiceApplicationTests {
	@Autowired
	private WebApplicationContext webApplicationContext;
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@BeforeEach
	void setUp(){

		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	void contextLoads() throws Exception {
		ProductDTO productDTO = getProductDTO();
		String productDTOJson =  objectMapper.writeValueAsString(productDTO);
		mockMvc.perform(MockMvcRequestBuilders.post("/api/product")
				.contentType(MediaType.APPLICATION_JSON)
				.content(productDTOJson))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	private ProductDTO getProductDTO(){
		return ProductDTO.builder()
				.name("Vivo v9")
				.description("best phone")
				.price(BigDecimal.valueOf(1000))
				.build();
	}

}
