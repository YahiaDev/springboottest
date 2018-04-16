package springboottest.demo.service.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import springboottest.demo.model.Person;
import springboottest.demo.repository.PersonRepo;
import springboottest.demo.service.PersonService;

@RunWith(SpringRunner.class)
public class PersonServiceTest {

	@TestConfiguration
	static class PersonServiceTestConfiguration {

		@Bean
		public PersonService personneService() {
			return new PersonService();
		}
	}

	@Autowired
	private PersonService personService;

	@MockBean
	private PersonRepo personRepo;

	@Before
	public void setUp() {
		Person person = new Person();
		person.setFirstName("yahia");
		person.setLastName("Ammar");

		String firstNameLike = "ya";

		List<Person> personList = Arrays.asList(person);

		Mockito.when(personRepo.findByFirstName(person.getFirstName())).thenReturn(personList);
		Mockito.when(personRepo.findByFirstNameContaining(firstNameLike)).thenReturn(personList);
	}

	@Test
	public void whenValidName_thenPersonShouldBefound() {
		String firstName = "yahia";
		List<Person> pFound = personService.findByFirstName(firstName);
		assertThat(pFound.get(0).getFirstName()).isEqualTo(firstName);
	}
	
	@Test
	public void whenValideNamelike_thenResultShouldBeFound(){
		String firstNameLike = "ya";
		List<Person> pFound = personService.findByFirstNameContaining(firstNameLike);
		assertThat(pFound.get(0).getFirstName()).isEqualTo("yahia");
	}

}
