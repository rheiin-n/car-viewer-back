package mg.rheiin.main.dto.request;

public class CarRequestDTO {
	private String brand;
	private String immatriculation;
	private Double traveledDistance;
	
	public CarRequestDTO() {}
	
	public CarRequestDTO(String brand, String immatriculation, Double traveledDistance) {
		this.brand = brand;
		this.immatriculation = immatriculation;
		this.traveledDistance = traveledDistance;
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

	@Override
	public String toString() {
		return "CarRequestDTO [brand=" + brand + ", immatriculation=" + immatriculation + ", traveledDistance="
				+ traveledDistance + "]";
	}
	
}
