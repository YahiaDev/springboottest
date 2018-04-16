package springboottest.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboottest.demo.model.Adresse;

@Repository
public interface AdresseRepo extends JpaRepository<Adresse, Long> {

}
