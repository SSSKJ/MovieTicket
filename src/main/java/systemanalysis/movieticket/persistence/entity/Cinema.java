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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cinema")
public class Cinema implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name="cid", nullable=false)
	@Id
	@GeneratedValue
	private int cid;
	
	@Column(name="cname", nullable=false)
	private String cname;
	
	@Column(name="address")
	private String address;
	
	@Column(name="location")
	private String location;
	
	/*@Column(name="city", nullable=false)
	private String city;
	
	@Column(name="town", nullable=false)
	private String town;*/
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@OneToMany(cascade=CascadeType.ALL, mappedBy="cinema")
	private List<ScreenRoom> sRooms = new ArrayList<ScreenRoom>();
	
	@ManyToMany(mappedBy="cinemas", fetch=FetchType.LAZY)
	private List<Film> films = new ArrayList<Film>();
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="cinema")
	private List<PlayList> playLists = new ArrayList<PlayList>();
	
	public List<PlayList> getPlayLists() {
		return playLists;
	}

	public void setPlayLists(List<PlayList> playLists) {
		this.playLists = playLists;
	}

	public List<Film> getFilms() {
		return films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}

	public List<ScreenRoom> getsRooms() {
		return sRooms;
	}

	public void setsRooms(List<ScreenRoom> sRooms) {
		this.sRooms = sRooms;
	}

	public Cinema() {}

	public Cinema(int cid, String cname, String location, String address) {
		this.cid = cid;
		this.cname = cname;
		//this.city = city;
		//this.town = town;
		this.location = location;
		this.address = address;
	}
	
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	/*public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}*/
	
	@Override                                                           
	public String toString() {
		return "Cinema [cid=" + cid + ", name=" + cname 
				+ ", address=" + address 
				+ ", location=" + location;
				//+ ", city=" + city 
				//+ ", town=" + town + "]";
	}
}
