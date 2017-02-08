package it.simonecasamassa.sprint.restsample.test.controller;


import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.util.JsonExpectationsHelper;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.annotation.JsonCreator;

import org.junit.Test;

import it.simonecasamassa.spring.restsample.controller.UserController;
import it.simonecasamassa.spring.restsample.repository.UserRepository;
import it.simonecasamassa.spring.restsample.repository.impl.UserCabledRepository;
import net.minidev.json.JSONObject;

public class TestUserController {
	
	
	private final MockMvc mockMvc = standaloneSetup(new UserController(new UserCabledRepository())).build();
	
	@Test
	public void validate_get_user() throws Exception {
		mockMvc.perform(get("/users/simone"))
			.andExpect(status().isOk())
			.andExpect(content().contentType("application/json"))
			.andExpect(jsonPath("$.surname").value("Benedetti"));
	
	}
	
	@Test
	public void validate_get_users() throws Exception {
		mockMvc.perform(get("/users"))
			.andExpect(status().isOk())
			.andExpect(content().contentType("application/json"))
			.andExpect(jsonPath("$[0].surname").value("Rossi"))
			.andExpect(jsonPath("$[1].surname").value("Verdi"))
			.andExpect(jsonPath("$[2].surname").value("Bianchi"));
	
	}
	
	@Test
	public void validate_post_register() throws Exception {
		
		JSONObject user = new JSONObject();
		user.put("name", "CLAUDIA");
		user.put("surname", "ROSSI");
		user.put("height", "1.85");
		user.put("weight", "60");
		mockMvc.perform(post("/users/register").contentType("application/json").content(user.toJSONString()))
			.andExpect(status().isOk())
			.andExpect(content().contentType("application/json"))
			.andExpect(jsonPath("$.risposta").value("Utente registrato"));
	
	}
	
	@Test
	public void service_not_found() throws Exception {
		
		
		mockMvc.perform(get("/users/bad_service"))
			.andExpect(status().isNotFound())
			;
	
	}
}
