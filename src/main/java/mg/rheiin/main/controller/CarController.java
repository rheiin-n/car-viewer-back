package mg.rheiin.main.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mg.rheiin.main.decorator.Responsable;
import mg.rheiin.main.dto.request.CarRequestDTO;
import mg.rheiin.main.dto.response.PublicCarResponseDTO;
import mg.rheiin.main.dto.response.ResponseDTO;
import mg.rheiin.main.entities.Car;
import mg.rheiin.main.exception.CVError;
import mg.rheiin.main.services.CarService;

@RestController
@RequestMapping("car")
public class CarController {

		@Autowired
		private CarService carService;
		
		@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<? extends Responsable> saveCar(@RequestBody CarRequestDTO carDTO) {
			try {
				ResponseDTO<Car, CVError> response = new ResponseDTO<Car, CVError>();
				carService.saveCar(carDTO, 
						(entity, error) -> {
							response.setEntity(entity);
							response.setError(error);
							response.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
						});
				return new ResponseEntity<ResponseDTO<Car, CVError>>(response, HttpStatus.CREATED);
			} catch (Exception e) {
				return new ResponseEntity<CVError>(new CVError(Arrays.asList("Immatriculation field cannot be empty")), HttpStatus.BAD_REQUEST);
			}
		}
		
		@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<? extends Responsable> getCar(@PathVariable(value = "id") Long id) {
			try {
				return ResponseEntity.ok(carService.getCar(id));
			} catch (Exception e) {
				return new ResponseEntity<CVError>(new CVError(Arrays.asList(e.getMessage())), HttpStatus.NOT_FOUND);
			}
		}
		
		@PreAuthorize("permitAll()")
		@GetMapping(path = "/public/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<? extends Responsable> getPublicCar(@PathVariable(value = "id") Long id) {
			try {
				return ResponseEntity.ok(carService.getPublicCar(id));
			} catch (Exception e) {
				return new ResponseEntity<CVError>(new CVError(Arrays.asList(e.getMessage())), HttpStatus.NOT_FOUND);
			}
		}
		
		@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<Car>> getAllCar() {
			return ResponseEntity.ok(carService.getAllCar());
		}
		
		@PreAuthorize("permitAll()")
		@GetMapping(path = "/public", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<PublicCarResponseDTO>> getAllPublicCar() {
			return ResponseEntity.ok(carService.getAllPublicCar());
		}
}
