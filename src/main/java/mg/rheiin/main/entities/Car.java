package mg.rheiin.main.entities;

import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import mg.rheiin.main.decorator.Responsable;

@Entity
@Access(AccessType.FIELD)
public class Car implements Responsable {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private String brand;
	
	@Column(nullable = false, unique = true)
	private String immatriculation;
	
	@Column
	private Double traveledDistance;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Comment> comments;
	
	public Car() {}
	
	public Car(String brand, String immatriculation, Double traveledDistance, List<Comment> comments) {
		this.brand = brand;
		this.immatriculation = immatriculation;
		this.traveledDistance = traveledDistance;
		this.comments = comments;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	public Double getTraveledDistance() {
		return traveledDistance;
	}

	public void setTraveledDistance(Double traveledDistance) {
		this.traveledDistance = traveledDistance;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
}
