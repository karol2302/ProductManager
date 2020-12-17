package net.codejava.Controller;

import net.codejava.models.Produkt;
import net.codejava.services.ProduktService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class MyRestController
{
    @Autowired
    private ProduktService countryService;

    @GetMapping("/api/countries")
    public List<Produkt> getCountries() {
      //  return countryService.listAll().stream().distinct().collect(Collectors.toList());
        return null;
    }

}