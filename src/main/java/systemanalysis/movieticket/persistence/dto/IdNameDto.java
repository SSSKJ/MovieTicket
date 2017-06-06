package systemanalysis.movieticket.persistence.dto;

import systemanalysis.movieticket.persistence.entity.Cinema;
import systemanalysis.movieticket.persistence.entity.Film;

public class IdNameDto {
	
	int id;
	String name;
	
	public IdNameDto() {}
	
	public IdNameDto(Cinema cinema) {
		id = cinema.getCid();
		name = cinema.getCname();
	}
	
	public IdNameDto(Film film) {
		id = film.getFid();
		name = film.getFname();
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
