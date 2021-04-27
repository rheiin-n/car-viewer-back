package mg.rheiin.main.dto.response.builder;

import java.time.LocalDateTime;

import mg.rheiin.main.dto.response.ResponseDTO;
import mg.rheiin.main.exception.CVError;

public class ResponseDTOBuilder<T, E extends CVError> {
	private ResponseDTO<T, E> response = new ResponseDTO<T, E>();
	
	public ResponseDTOBuilder<T, E> entity(T entity) {
		this.response.setEntity(entity);
		return this;
	}
	
	public ResponseDTOBuilder<T, E> error(E error) {
		this.response.setError(error);
		return this;
	}
	
	public ResponseDTOBuilder<T, E> timestamp(String timestamp) {
		this.response.setTimestamp(timestamp);
		return this;
	}
	
	public ResponseDTO<T, E> build() {
		return this.response;
	}
}
