package net.codejava.services;

import net.codejava.models.Produkt;
import net.codejava.repo.ProduktRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProduktService {

	@Autowired
	private ProduktRepository repo;
	
	public List<Produkt> listAll() {
		return repo.findAll();
	}


	public void save(Produkt product) {
		repo.save(product);
	}
	
	public Produkt get(long id) {
		return repo.findById(id).get();
	}
	
	public void delete(long id) {
		repo.deleteById(id);
	}
}
