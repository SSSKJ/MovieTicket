package systemanalysis.movieticket.persistence.dto;

import systemanalysis.movieticket.persistence.entity.PlayList;

public class PlayListDto {
	
	int id;
	int room;
	String time;
	float price;
	
	public PlayListDto() {}
	
	public PlayListDto(PlayList p) {
		id = p.getPlid();
		room = p.getsRoom();
		time = p.getPlayTime();
		price = p.getPrice();
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getRoom() {
		return room;
	}
	
	public void setRoom(int room) {
		this.room = room;
	}
	
	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public float getPrice() {
		return price;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
}
