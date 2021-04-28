package mg.rheiin.main.services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mg.rheiin.main.dto.request.CarRequestDTO;
import mg.rheiin.main.dto.response.PublicCarResponseDTO;
import mg.rheiin.main.entities.Car;
import mg.rheiin.main.exception.CVError;
import mg.rheiin.main.functionnal.QueryExecutor;
import mg.rheiin.main.repositories.CarRepository;

@Service
public class CarService {
	
	@Autowired
	private CarRepository carRepository;
	
	@Transactional
	public Car updateCar(Car car) {
		return carRepository.save(car);
	}
	
	@Transactional
	public void saveCar(CarRequestDTO carDTO, QueryExecutor<Car, CVError> executor) throws Exception {
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
	public PublicCarResponseDTO getPublicCar(Long id) throws Exception {
		Optional<Car> car = carRepository.findById(id);
		if (car.isEmpty()) {
			throw new Exception("no car found with the specified ID");
		} else {
			return new PublicCarResponseDTO(car.get().getId(), car.get().getBrand(), car.get().getImmatriculation(), car.get().getTraveledDistance());
		}
	}
	
	@Transactional
	public List<Car> getAllCar() {
		return carRepository.findAll();
	}
	
	@Transactional
	public List<PublicCarResponseDTO> getAllPublicCar() {
		return carRepository.findAll().stream()
									.map( car -> new PublicCarResponseDTO(car.getId(), car.getBrand(), car.getImmatriculation(), car.getTraveledDistance()))
									.collect(Collectors.toList());
	}
}
