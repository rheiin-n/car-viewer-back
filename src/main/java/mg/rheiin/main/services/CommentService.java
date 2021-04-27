package mg.rheiin.main.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mg.rheiin.main.dto.request.CommentRequestDTO;
import mg.rheiin.main.entities.Car;
import mg.rheiin.main.entities.Comment;
import mg.rheiin.main.exception.CVError;
import mg.rheiin.main.functionnal.QueryExecutor;
import mg.rheiin.main.repositories.CarRepository;
import mg.rheiin.main.repositories.CommentRepository;

@Service
public class CommentService {
	@Autowired
	CarRepository carRepository;
	
	@Autowired
	CommentRepository commentRepository;

	@Transactional
	public void saveComment(CommentRequestDTO commentDTO, QueryExecutor<Comment, CVError> executor) throws Exception {
		Optional<Car> car = carRepository.findById(commentDTO.getCarId());
		if (car.isEmpty()) {
			throw new Exception("The specified car is not found");
		} else if (Objects.isNull(commentDTO.getValue()) || commentDTO.getValue().isEmpty() || commentDTO.getValue().isBlank()) {
			throw new Exception("Cannot add empty or blank comment");
		} else {
			Comment comment = new Comment(commentDTO.getValue(), LocalDateTime.now(), car.get());
			car.get().getComments().add(comment);
			carRepository.save(car.get());
			executor.didPersist(comment, null);
		}
	}
	
	@Transactional
	public Comment getComment(Long id) throws Exception {
		Optional<Comment> comment = commentRepository.findById(id);
		if (comment.isEmpty()) {
			throw new Exception("No comment found with the specifid id :" + id);
		} else {
			return comment.get();
		}
	}
	
	@Transactional
	public List<Comment> getAllComment() {
		return commentRepository.findAll();
	}
}
