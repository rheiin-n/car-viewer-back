package mg.rheiin.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mg.rheiin.main.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
