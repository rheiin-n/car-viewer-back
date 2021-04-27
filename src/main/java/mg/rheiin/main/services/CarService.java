package mg.rheiin.main.services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mg.rheiin.main.dto.request.CarRequestDTO;
import mg.rheiin.main.entities.Car;
import mg.rheiin.main.exception.CVError;
import mg.rheiin.main.functionnal.QueryExecutor;
import mg.rheiin.main.repositories.CarRepository;

@Service
public class CarService {
	
	@Autowired
	CarRepository carRepository;
	
	@Transactional
	public void saveCar(CarRequestDTO carDTO, QueryExecutor<Car, CVError> executor) throws Exception {
		System.out.println("----------------------" + carDTO.toString());
		if (Objects.isNull(carDTO.getImmatriculation()) || carDTO.getImmatriculation().isEmpty() || carDTO.getImmatriculation().isBlank()) {
			throw new Exception("immatriculation cannot be empty");
		} else {
			Car car = new Car(carDTO.getBrand(), carDTO.getImmatriculation(), carDTO.getTraveledDistance(), null);
			carRepository.save(car);
			executor.didPersist(car, null);
		}
	}
	
	@Transactional
	public Car getCar(Long id) throws Exception {
		Optional<Car> car = carRepository.findById(id);
		if (car.isEmpty()) {
			throw new Exception("no car found with the specified ID");
		} else {
			return car.get();
		}
	}
	
	@Transactional
	public List<Car> getAllCar() {
		return carRepository.findAll();
	}
}
