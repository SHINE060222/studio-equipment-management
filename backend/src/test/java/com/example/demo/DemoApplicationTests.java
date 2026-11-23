package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.beans.Transient;

import javax.print.attribute.standard.Media;

@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {
	@Autowired
	MockMvc mockMvc;

	// Spring能不能启动
	@Test
	void contextLoads() {
	}

	// 合法 POST/signups 是不是返回201
	@Test 
	void createSignupReturn201() throws Exception{
		mockMvc.perform(post("/signups")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"name\":\"test\",\"major\":\"stat\",\"gender\":\"M\",\"interests\":[\"running\"]}"))
			.andExpect(status().isCreated());
	}

	@Test 
	void createdSignupWithBlankNameReturn400() throws Exception{
		mockMvc.perform(post("/signups")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"name\":\"\",\"major\":\"stat\",\"gender\":\"M\",\"interests\":[\"running\"]}"))
			.andExpect(status().isBadRequest());
	}
}
