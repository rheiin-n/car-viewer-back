package mg.rheiin.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mg.rheiin.main.entities.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

}
