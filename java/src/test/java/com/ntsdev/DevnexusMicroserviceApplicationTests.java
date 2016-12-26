package com.ntsdev;

import com.jayway.jsonpath.JsonPath;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration
@WebAppConfiguration
public class DevnexusMicroserviceApplicationTests {

	@Autowired
	private WebApplicationContext context;

	private MockMvc mvc;

	@Before
	public void setup(){
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}


	@Test
	public void contextLoads() {
	}

	@Test
	public void testPersonIsFound() throws Exception {
		mvc.perform(get("/people")).andExpect(result -> {
			String json = result.getResponse().getContentAsString();
			String firstName = JsonPath.read(json, "$._embedded.people[0].firstName");
			String lastName = JsonPath.read(json, "$._embedded.people[0].lastName");
			assertEquals("Neil", firstName);
			assertEquals("Shannon", lastName);
		});

	}

}
