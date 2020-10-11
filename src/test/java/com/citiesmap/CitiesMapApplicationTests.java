package com.citiesmap;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.citiesmap.controller.CitiesMapController;

@SpringBootTest
class CitiesMapApplicationTests {

	@Autowired
	private CitiesMapController controller;
	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
