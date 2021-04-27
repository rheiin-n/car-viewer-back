package mg.rheiin.main.dto.request;

public class CommentRequestDTO {
	private Long carId;
	private String value;
	
	public CommentRequestDTO() {} 
	
	public CommentRequestDTO(Long carId, String value) {
		this.carId = carId;
		this.value = value;
	}

	public Long getCarId() {
		return carId;
	}

	public void setCarId(Long carId) {
		this.carId = carId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
