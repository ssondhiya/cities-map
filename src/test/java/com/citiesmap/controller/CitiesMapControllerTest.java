package com.citiesmap.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.citiesmap.services.CitiesMapService;

@WebMvcTest(CitiesMapController.class)
class CitiesMapControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CitiesMapService service;
	@Test
	void testConnectedCityResponse() throws Exception {
		when(service.isCityConnected(Mockito.anyString(), Mockito.anyString())).thenReturn(true);
		this.mockMvc
			.perform(get("/connected?origin=A&destination=A"))
			.andExpect(status().isOk())
			.andExpect(content().string("yes"));
		
	}
	
	@Test
	void testDisConnectedCityResponse() throws Exception {
		when(service.isCityConnected(Mockito.anyString(), Mockito.anyString())).thenReturn(false);
		this.mockMvc
			.perform(get("/connected?origin=A&destination=B"))
			.andExpect(status().isOk())
			.andExpect(content().string("no"));
		
	}
	
	@Test
	void testNoParameters() throws Exception {
		String expected = "{\"origin\": \"Can not be null or empty.\",\"destination\": \"Can not be null or empty.\"}";
		this.mockMvc
			.perform(get("/connected"))
			.andExpect(status().is4xxClientError())
			.andExpect(content().json(expected));
		
	}

}
