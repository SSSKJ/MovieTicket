package systemanalysis.movieticket.persistence.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="order")
public class Order implements Serializable {
	 
	private static final long serialVersionUID = 1L;
	
	@Column(name="oid", nullable=false)
	@Id
	private int oid;
	
	@JoinColumn(name="emailaddress")
	@ManyToOne(fetch=FetchType.LAZY)
	private User user;
	
	@Column(name="date", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Column(name="moviename", nullable=false)
	private String moviename;

	@Column(name="movietime", nullable=false)
	@Temporal(TemporalType.TIME)
	private Time movietime;
	
	@Column(name="cinema", nullable=false)
	private String cinema;
	
	@Column(name="ticketamount", nullable=false)
	private int ticketamount;
	
	@Column(name="price", nullable=false)
	private float price;
	
	@Column(name="screeningroom", nullable=false)
	private String screeningroom;
	
	public Order(){}
	
	public void setOid(int oid) {
		this.oid = oid;
	}
	
	public int getOid() {
		return oid;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setDate(String date) {
		this.date = Date.valueOf(date);
	}
	
	public String getDate() {
		return date.toString();
	}
	
	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}
	
	public String getMoviename() {
		return moviename;
	}

	public String getMovietime() {
		return movietime.toString();
	}

	public void setMovietime(String movietime) {
		this.movietime = Time.valueOf(movietime);
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
	
	@Override
	public String toString() {
		return "Order [oid=" + oid + ", user=" + user + ", date=" + date + ", moviename=" + moviename + ", movietime="
				+ movietime + ", cinema=" + cinema + ", ticketamount=" + ticketamount + ", price=" + price
				+ ", screeningroom=" + screeningroom + "]";
	}
	
}
