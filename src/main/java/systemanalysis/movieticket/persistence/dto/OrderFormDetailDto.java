package systemanalysis.movieticket.persistence.dto;

import systemanalysis.movieticket.persistence.entity.OrderForm;

public class OrderFormDetailDto {
	
	int oid;
	String date;
	String moviename;
	String movietime;
	String cinema;
	int ticketamount;
	float price;
	String screeningroom;
	
	public OrderFormDetailDto() {}
	
	public OrderFormDetailDto(OrderForm o) {
		oid = o.getOid();
		date = o.getDate();
		moviename = o.getMoviename();
		movietime = o.getMovietime();
		cinema = o.getCinema();
		ticketamount = o.getTicketamount();
		price = o.getPrice();
		screeningroom = o.getScreeningroom();
	}
	
	public int getOid() {
		return oid;
	}
	
	public void setOid(int oid) {
		this.oid = oid;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getMoviename() {
		return moviename;
	}
	
	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}
	
	public String getMovietime() {
		return movietime;
	}
	
	public void setMovietime(String movietime) {
		this.movietime = movietime;
	}
	
	public String getCinema() {
		return cinema;
	}
	
	public void setCinema(String cinema) {
		this.cinema = cinema;
	}
	
	public int getTicketamount() {
		return ticketamount;
	}
	
	public void setTicketamount(int ticketamount) {
		this.ticketamount = ticketamount;
	}
	
	public float getPrice() {
		return price;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
	
	public String getScreeningroom() {
		return screeningroom;
	}
	
	public void setScreeningroom(String screeningroom) {
		this.screeningroom = screeningroom;
	}
}
