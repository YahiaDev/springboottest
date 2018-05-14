package springboottest.demo.controller.test;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import springboottest.demo.controller.PersonController;
import springboottest.demo.model.Person;
import springboottest.demo.service.PersonService;

@RunWith(SpringRunner.class)
@WebMvcTest(PersonController.class)
public class PersonControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean(name = "personService")
	private PersonService service;

	@Test
	public void givenPerson_whenGetAllPerson_thenReturnJsonArry() throws Exception {
		Person person = new Person();

		person.setFirstName("yahia");
		person.setLastName("ammmar");

		List<Person> personList = Arrays.asList(person);

		given(service.getAllPersons()).willReturn(personList);

		mvc.perform(get("/person/findallperson").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].firstName", is(person.getFirstName())));
	}

}
