package net.codejava.repo;

import net.codejava.models.Produkt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduktRepository extends JpaRepository<Produkt, Long> {

}
