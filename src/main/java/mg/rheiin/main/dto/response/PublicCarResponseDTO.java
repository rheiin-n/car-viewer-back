package mg.rheiin.main.dto.response;

import mg.rheiin.main.decorator.Responsable;

public class PublicCarResponseDTO implements Responsable {
	private Long id;
	private String brand;
	private String immatriculation;
	private Double traveledDistance;
	
	public PublicCarResponseDTO() {}
	
	public PublicCarResponseDTO(Long id, String brand, String immatriculation, Double traveledDistance) {
		this.id = id;
		this.brand = brand;
		this.immatriculation = immatriculation;
		this.traveledDistance = traveledDistance;
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
}
