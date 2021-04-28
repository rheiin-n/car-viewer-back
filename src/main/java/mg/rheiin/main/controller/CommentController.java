package mg.rheiin.main.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mg.rheiin.main.decorator.Responsable;
import mg.rheiin.main.dto.request.CommentRequestDTO;
import mg.rheiin.main.dto.response.ResponseDTO;
import mg.rheiin.main.entities.Comment;
import mg.rheiin.main.exception.CVError;
import mg.rheiin.main.services.CommentService;

@RestController
@RequestMapping("comments")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<? extends Responsable> publishComment(@RequestBody CommentRequestDTO commentDTO) {
		try {
			ResponseDTO<Comment, CVError> response = new ResponseDTO<Comment, CVError>();
			commentService.saveComment(commentDTO, 
					(entity, error) -> {
						response.setEntity(entity);
						response.setError(error);
						response.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
					});
			return new ResponseEntity<ResponseDTO<Comment, CVError>>(response, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<CVError>(new CVError(Arrays.asList(e.getMessage())), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<? extends Responsable> getComment(@PathVariable Long id) {
		try {
			return new ResponseEntity<Comment>(commentService.getComment(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<CVError>(new CVError(Arrays.asList(e.getMessage())), HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Comment>> getAllComment() {
		return new ResponseEntity<List<Comment>>(commentService.getAllComment(), HttpStatus.OK);
	}
}
