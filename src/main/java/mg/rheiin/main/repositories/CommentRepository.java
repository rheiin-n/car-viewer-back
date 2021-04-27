package mg.rheiin.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mg.rheiin.main.entities.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
