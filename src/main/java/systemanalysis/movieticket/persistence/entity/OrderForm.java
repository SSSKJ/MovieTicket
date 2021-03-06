package systemanalysis.movieticket.persistence.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="orderform")
public class OrderForm implements Serializable {
	 
	private static final long serialVersionUID = 1L;
	
	@Column(name="oid", nullable=false)
	@Id
	@GeneratedValue
	private int oid;
	
	@JoinColumn(name="emailaddress", nullable=false)
	@ManyToOne(fetch=FetchType.LAZY)
	private User user;
	
	@Column(name="date", nullable=false)
	private String date;
	
	@Column(name="moviename", nullable=false)
	private String moviename;

	@Column(name="movietime", nullable=false)
	private String movietime;
	
	@Column(name="cinema", nullable=false)
	private String cinema;
	
	@Column(name="ticketamount", nullable=false)
	private int ticketamount;
	
	@Column(name="price", nullable=false)
	private float price;
	
	@Column(name="screeningroom", nullable=false)
	private int screeningroom;
	
	/*@Column(name="state", nullable=false)
	private String state;
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}*/

	@OneToMany(cascade=CascadeType.ALL, mappedBy="id.orderform")
	private List<SeatInOrder> s = new ArrayList<SeatInOrder>();
	
	public List<SeatInOrder> getS() {
		return s;
	}

	public void setS(List<SeatInOrder> s) {
		this.s = s;
	}

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
		this.date = date;
	}
	
	public String getDate() {
		return date;
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

	public int getScreeningroom() {
		return screeningroom;
	}

	public void setScreeningroom(int screeningroom) {
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
		result = prime * result + screeningroom;
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
		if (screeningroom != other.screeningroom)
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
