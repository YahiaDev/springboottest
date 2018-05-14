package springboottest.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import springboottest.demo.model.Person;
import springboottest.demo.repository.PersonRepo;

@Service
public class PersonService {

	@Autowired
	private PersonRepo personRepo;

	public List<Person> getAllPersons() {
		return personRepo.findAll();
	}

	public Person findById(long id) {
		return personRepo.findById(id).get();
	}

	public List<Person> findByLastName(String lastName) {
		return personRepo.findByLastName(lastName);
	}

	public List<Person> findByFirstName(String firsName) {
		return personRepo.findByFirstName(firsName);
	}

	public void addOrUpdatePerson(Person person) {
		personRepo.save(person);
	}

	public List<Person> findByFirstNameAndLastName(final String firstName, final String lastName) {
		return personRepo.findByFirstNameAndLastName(firstName, lastName);
	}

	public List<Person> findByAdresseCity(final String city) {
		return personRepo.findByAdresseCity(city);
	}

	public List<Person> findByFirstNameContaining(String stringToFind) {
		return personRepo.findByFirstNameContaining(stringToFind);
	}

	public List<Person> findAllPaging(int page, int size) {
		//return personRepo.findAll(new PageRequest(page, size, Direction.DESC, "id")).getContent();
		return personRepo.findAll(new PageRequest(page, size)).getContent();
	}

}
