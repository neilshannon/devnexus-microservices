package com.ntsdev;

import com.jayway.jsonpath.JsonPath;
import com.ntsdev.domain.Person;
import com.ntsdev.repository.PersonRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DevNexusMicroserviceApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private PersonRepository personRepository;


	@Before
	public void setupData(){
		personRepository.deleteAll();
		personRepository.insert(new Person("Neil", "Shannon"));
	}


	@Test
	public void contextLoads() {
	}

	@Test
	public void testPersonIsFound() throws Exception {
		mockMvc.perform(get("/people")).andExpect(result -> {
			String json = result.getResponse().getContentAsString();
			String firstName = JsonPath.read(json, "$._embedded.people[0].firstName");
			String lastName = JsonPath.read(json, "$._embedded.people[0].lastName");
			assertEquals("Neil", firstName);
			assertEquals("Shannon", lastName);
		});

	}

}
