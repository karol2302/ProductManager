package net.codejava.repo;

import net.codejava.models.ProduktCountry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduktCountryRepository extends JpaRepository<ProduktCountry, Long> {

    ProduktCountry findByName(String n);
}

