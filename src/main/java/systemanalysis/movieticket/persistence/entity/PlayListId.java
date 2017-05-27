package systemanalysis.movieticket.persistence.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Embeddable
public class PlayListId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name="plid", nullable=false)
	@GeneratedValue
	private int plid;
	
	@JoinColumn(name="srid", nullable=false)
	@ManyToOne(fetch=FetchType.LAZY)
	private ScreenRoom sRoom;
	
	@JoinColumn(name="fid", nullable=false)
	@ManyToOne(fetch=FetchType.LAZY)
	private Film film;
	
	@JoinColumn(name="cid", nullable=false)
	@ManyToOne(fetch=FetchType.LAZY)
	private Cinema cinema;
	
	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

	@ManyToMany(cascade={CascadeType.ALL,CascadeType.ALL,CascadeType.MERGE})
	@JoinTable(name="playlist_seatchart",
				joinColumns={
						@JoinColumn(name="plid", referencedColumnName="plid")
				},
				inverseJoinColumns={
						@JoinColumn(name="scid", referencedColumnName="scid")
				})
	private List<SeatChart> seatChart = new ArrayList<SeatChart>();
	
	@Column(name="playdate", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date playDate;
	
	@Column(name="playtime", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date playTime;
	
	@Column(name="totalseat", nullable=false)
	private int totalSeat;
	
	@Column(name="emptyseat", nullable=false)
	private int emptySeat;
	
	@Column(name="price", nullable=false)
	private float price;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sRoom == null) ? 0 : sRoom.hashCode());
		result = prime * result + ((film == null) ? 0 : film.hashCode());
		result = prime * result + ((playDate == null) ? 0 : playDate.hashCode());
		result = prime * result + ((playTime == null) ? 0 : playTime.hashCode());
		result = prime * result + plid;
		result = prime * result + totalSeat;
		result = prime * result + emptySeat;
		result = prime * result + Float.floatToIntBits(price);
		return result;
	}
	
	
	
	public int getPlid() {
		return plid;
	}


	public void setPlid(int plid) {
		this.plid = plid;
	}


	public ScreenRoom getsRoom() {
		return sRoom;
	}


	public void setsRoom(ScreenRoom sRoom) {
		this.sRoom = sRoom;
	}


	public Film getFilm() {
		return film;
	}


	public void setFilm(Film film) {
		this.film = film;
	}


	public List<SeatChart> getSeatChart() {
		return seatChart;
	}


	public void setSeatChart(List<SeatChart> seatChart) {
		this.seatChart = seatChart;
	}


	public Date getPlayDate() {
		return playDate;
	}


	public void setPlayDate(Date playDate) {
		this.playDate = playDate;
	}


	public Date getPlayTime() {
		return playTime;
	}


	public void setPlayTime(Date playTime) {
		this.playTime = playTime;
	}


	public int getTotalSeat() {
		return totalSeat;
	}


	public void setTotalSeat(int totalSeat) {
		this.totalSeat = totalSeat;
	}



	public int getEmptySeat() {
		return emptySeat;
	}


	public void setEmptySeat(int emptySeat) {
		this.emptySeat = emptySeat;
	}


	public float getPrice() {
		return price;
	}



	public void setPrice(float price) {
		this.price = price;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		PlayListId other = (PlayListId)obj;
		if (sRoom == null) {
			if (other.sRoom != null)
				return false;
		} else if (!sRoom.equals(other.sRoom)) {
				return false;
		}
		
		if (film == null) {
			if (other.film != null)
				return false;
		} else if (!film.equals(other.film)) {
				return false;
		}
		
		if (playDate == null) {
			if (other.playDate != null)
				return false;
		} else if (!playDate.equals(other.playDate)) {
				return false;
		}
		
		if (playTime == null) {
			if (other.playTime != null)
				return false;
		} else if (!playTime.equals(other.playTime)) {
				return false;
		}
		
		if (plid != other.plid)
			return false;
		
		if (totalSeat != other.totalSeat)
			return false;
		
		if (emptySeat != other.emptySeat)
			return false;
		
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		
		return true;
	}
	
	@Override
	public String toString() {
		return "PlayList [ plid=" + plid
				+ ", screenRoom=" + sRoom
				+ ", film=" + film
				+ ", playDate=" + playDate
				+ ", playTime=" + playTime
				+ ", totalSeat=" + totalSeat
				+ ", emptySeat=" + emptySeat
				+ ", price=" + price;
	}
}
