package springboottest.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import springboottest.demo.model.Person;
import springboottest.demo.service.AdresseService;
import springboottest.demo.service.PersonService;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

	@Autowired
	private PersonService personService;

	@Autowired
	private AdresseService adresseService;

	@RequestMapping(value = "/findpersonbylastname/{lastName}", method = RequestMethod.GET)
	public List<Person> findPeronByLastName(@PathVariable String lastName) {
		return personService.findByLastName(lastName);
	}

	@RequestMapping(value = "/findpersonbyfirstname/{firstName}", method = RequestMethod.GET)
	public List<Person> findPersonByFirstName(@PathVariable String firstName) {
		return personService.findByFirstName(firstName);
	}

	@RequestMapping(value = "/addorupdateperson", method = RequestMethod.POST)
	public void addOrUpdatePerson(@RequestBody Person person) {
		if (person.getAdresse() != null) {
			adresseService.saveOrUpdateAdresse(person.getAdresse());
		}
		personService.addOrUpdatePerson(person);
	}

	@RequestMapping(value = "/findbyfirstnameandlastname/{firstName}&&{lastName}", method = RequestMethod.GET)
	public List<Person> findByPersonFirstNameAndLastName(@PathVariable String firstName,
			@PathVariable String lastName) {
		return personService.findByFirstNameAndLastName(firstName, lastName);
	}

	@RequestMapping(value = "/findallperson", method = RequestMethod.GET)
	public List<Person> findAllPerson() {
		return personService.getAllPersons();
	}

	@RequestMapping(value = "/findbyadressecity/{city}", method = RequestMethod.GET)
	public List<Person> findByAdresseCity(@PathVariable String city) {
		return personService.findByAdresseCity(city);
	}

	@RequestMapping(value = "/findfirstnamecontaining/{firstNameLike}", method = RequestMethod.GET)
	public List<Person> findByFirstNameContaining(@PathVariable String firstNameLike) {
		return personService.findByFirstNameContaining(firstNameLike);
	}

}
