package mg.rheiin.main.entities;

import java.time.LocalDateTime;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import mg.rheiin.main.decorator.Responsable;

@Entity
@Access(AccessType.FIELD)
public class Comment implements Responsable {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private String value;
	
	@Column(nullable = false)
	private LocalDateTime date;
	
	@ManyToOne
	@JoinColumn(name = "car_id")
	@JsonIgnore
	private Car car;
	
	public Comment() {}
	
	public Comment(String value, LocalDateTime date, Car car) {
		this.value = value;
		this.date = date;
		this.car = car;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
}
