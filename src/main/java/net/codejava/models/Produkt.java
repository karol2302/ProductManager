package net.codejava.models;

import javax.persistence.*;

@Entity
@Table(name="produkt")
public class Produkt {
	private Long id;
	private String name;
	private String brand;




	//, foreignKey = @ForeignKey(name = "produkt_ibfk_1"))
	@ManyToOne
	@JoinColumn(name="id", referencedColumnName = "id")
	private ProduktCountry madein_id;

	private float price;

	public Produkt() {
	}

	protected Produkt(Long id, String name, String brand, ProduktCountry madein_id, float price) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.madein_id = madein_id;
		this.price = price;
	}

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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@ManyToOne
	//(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@PrimaryKeyJoinColumn
	@JoinColumn(name="madein_id", referencedColumnName = "id")
 	public ProduktCountry getMadein_id() {
		return madein_id;
	}

	public void setMadein_id(ProduktCountry madein_id) {
		this.madein_id = madein_id;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
