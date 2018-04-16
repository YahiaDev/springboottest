package springboottest.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboottest.demo.model.Adresse;
import springboottest.demo.repository.AdresseRepo;

@Service
public class AdresseService {

	@Autowired
	private AdresseRepo adresseRepo;

	public void saveOrUpdateAdresse(Adresse adresse) {
		adresseRepo.save(adresse);
	}

}
