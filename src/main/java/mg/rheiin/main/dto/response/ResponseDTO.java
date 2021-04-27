package mg.rheiin.main.dto.response;


import mg.rheiin.main.decorator.Responsable;
import mg.rheiin.main.exception.CVError;

public class ResponseDTO<T, E extends CVError> implements Responsable {
	private T entity;
	private E error;
	private String timestamp;
	
	public ResponseDTO() {}
	
	public ResponseDTO(T entity, E error, String timestamp) {
		this.entity = entity;
		this.error = error;
		this.timestamp = timestamp;
	}

	public T getEntity() {
		return entity;
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}

	public E getError() {
		return error;
	}

	public void setError(E error) {
		this.error = error;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
}
