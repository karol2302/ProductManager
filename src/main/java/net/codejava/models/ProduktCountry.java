package net.codejava.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "produktcountry")
public  class ProduktCountry {


     private Long id;
     private String name;

     public ProduktCountry() {}

     public ProduktCountry(String name)
     {
         this.name = name;
     }

     public ProduktCountry(Long id, String name) {
        this.id = id;
        this.name = name;
     }



    private List<Produkt> produkts = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany( cascade = CascadeType.ALL)
    @JoinColumn(name="id")
    public List<Produkt> getProdukts() {
        return produkts;
    }

    public void setProdukts(List<Produkt> produkts)
    {
        this.produkts = produkts;
    }
}


