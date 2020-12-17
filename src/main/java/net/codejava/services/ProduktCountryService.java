package net.codejava.services;

import net.codejava.models.ProduktCountry;
import net.codejava.repo.ProduktCountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProduktCountryService {

    @Autowired
    private ProduktCountryRepository repo;

    public List<ProduktCountry> listAll() {
        return repo.findAll();
    }

    public void save(ProduktCountry productC) {
        repo.save(productC);
    }

    public ProduktCountry getByName(String n)
    {
        return repo.findByName(n);
    }

    public ProduktCountry get(long id) {
        return repo.findById(id).get();
    }

    public void delete(long id) {
        repo.deleteById(id);
    }
}
