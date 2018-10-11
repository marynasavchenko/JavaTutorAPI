package com.abacuspro.hotelbeta.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(RoomReservationController.class)
@AutoConfigureMockMvc(secure = false)
public class RoomReservationControllerTest {

	@Autowired
	private MockMvc mockMvc;


	@Test
	public void shouldGetAllRooms() throws Exception {
		mockMvc.perform(get("/hotel/allrooms"))
				.andExpect(status().isOk());
	}
}
