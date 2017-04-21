package systemanalysis.movieticket.persistence.entity;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
@Table(name="orderform")
public class OrderForm implements Serializable {
	 
	private static final long serialVersionUID = 1L;
	
	@Column(name="oid", nullable=false)
	@Id
	private int oid;
	
	@JoinColumn(name="emailaddress", nullable=false)
	@ManyToOne(fetch=FetchType.LAZY)
	private User user;
	
	@Column(name="date", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Column(name="moviename", nullable=false)
	private String moviename;

	@Column(name="movietime", nullable=false)
	@Temporal(TemporalType.TIME)
	private Date movietime;
	
	@Column(name="cinema", nullable=false)
	private String cinema;
	
	@Column(name="ticketamount", nullable=false)
	private int ticketamount;
	
	@Column(name="price", nullable=false)
	private float price;
	
	@Column(name="screeningroom", nullable=false)
	private String screeningroom;
	
	public OrderForm(){}
	
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
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.date = sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		try {
			this.movietime = sdf.parse(movietime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cinema == null) ? 0 : cinema.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((moviename == null) ? 0 : moviename.hashCode());
		result = prime * result + ((movietime == null) ? 0 : movietime.hashCode());
		result = prime * result + oid;
		result = prime * result + Float.floatToIntBits(price);
		result = prime * result + ((screeningroom == null) ? 0 : screeningroom.hashCode());
		result = prime * result + ticketamount;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderForm other = (OrderForm) obj;
		if (cinema == null) {
			if (other.cinema != null)
				return false;
		} else if (!cinema.equals(other.cinema))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (moviename == null) {
			if (other.moviename != null)
				return false;
		} else if (!moviename.equals(other.moviename))
			return false;
		if (movietime == null) {
			if (other.movietime != null)
				return false;
		} else if (!movietime.equals(other.movietime))
			return false;
		if (oid != other.oid)
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		if (screeningroom == null) {
			if (other.screeningroom != null)
				return false;
		} else if (!screeningroom.equals(other.screeningroom))
			return false;
		if (ticketamount != other.ticketamount)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "OrderForm [oid=" + oid + ", user=" + user + ", date=" + date + ", moviename=" + moviename + ", movietime="
				+ movietime + ", cinema=" + cinema + ", ticketamount=" + ticketamount + ", price=" + price
				+ ", screeningroom=" + screeningroom + "]";
	}
	
}
