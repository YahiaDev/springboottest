package springboottest.demo.repository.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import springboottest.demo.model.Person;
import springboottest.demo.repository.PersonRepo;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class PersonRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private PersonRepo personRepo;

	@Test
	public void whenFindByName_thenReturnPerson() {
		Person person = new Person();
		person.setFirstName("TATA");
		person.setLastName("PAPA");
		entityManager.persist(person);
		entityManager.flush();

		// when
		List<Person> pFound = personRepo.findByFirstName(person.getFirstName());

		// then
		// assertNotNull(" person list sshloud not be null", pFound.get(0));
		assertThat(pFound.get(0)).isNotNull();
		assertThat(pFound.get(0).getFirstName()).isEqualTo(person.getFirstName());
		// assertThat(pFound.get(0).getFirstName().equals(person.getFirstName()));

	}

	@Test
	public void whenFirstNameLike_thenReturnPerson() {
		Person person = new Person();
		person.setFirstName("firstName");
		person.setLastName("lastName");
		entityManager.persist(person);
		entityManager.flush();

		// when
		List<Person> pFoundList = personRepo.findByFirstNameContaining("first");

		// then
		assertThat(pFoundList).isNotNull();
		assertThat(pFoundList.get(0).getFirstName()).isEqualTo("firstName");
	}

}
