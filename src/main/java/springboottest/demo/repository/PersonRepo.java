package springboottest.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import springboottest.demo.model.Person;

@Repository
public interface PersonRepo extends JpaRepository<Person, Long>, PagingAndSortingRepository<Person,Long> {

	List<Person> findByFirstName(String firstname);

	List<Person> findByLastName(String lastname);

	List<Person> findByFirstNameAndLastName(String firstName, String lastName);

	List<Person> findByAdresseCity(String city);

	List<Person> findByFirstNameContaining(String stringToFind);
	

}
