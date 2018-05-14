package springboottest.demo.controller.test.integration;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import springboottest.demo.SpringboottestApplication;
import springboottest.demo.model.Person;
import springboottest.demo.service.PersonService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = SpringboottestApplication.class)
@AutoConfigureMockMvc
public class PersonControllerIntegTest {

	@Autowired
	private MockMvc mvc;

	// @Autowired
	// private PersonRepo personRepo;

	@Autowired
	private PersonService personService;

	@Test
	public void givenEmployees_whenGetEmployees_thenStatus200() throws Exception {

		// createTestEmployee("bob");

		Person person = new Person();
		person.setFirstName("yahia");
		person.setLastName("ammar");

		personService.addOrUpdatePerson(person);

		// personRepo.save(person);

		mvc.perform(get("/person/findallperson").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[0].firstName", is("yahia")));
	}

}
