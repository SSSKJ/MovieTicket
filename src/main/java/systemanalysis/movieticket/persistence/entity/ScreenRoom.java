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
@Table(name="screenroom")
public class ScreenRoom implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name="srid", nullable=false)
	@Id
	@GeneratedValue
	private int srid;
	
	@JoinColumn(name="cid", nullable=false)
	@ManyToOne(fetch=FetchType.LAZY)
	private Cinema cinema; 
	
	@Column(name="srname", nullable=false)
	private String srname;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="sRoom")
	private List<PlayList> playLists = new ArrayList<PlayList>();

	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

	public String getSrname() {
		return srname;
	}

	public void setSrname(String srname) {
		this.srname = srname;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + srid;
		result = prime * result + ((srname == null) ? 0 : srname.hashCode());
		result = prime * result + ((cinema == null) ? 0 : cinema.hashCode());
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
		
		ScreenRoom other = (ScreenRoom) obj;
		
		if (srid != other.srid)
			return false;
		
		if (srname == null) {
			if (other.srname != null)
				return false;
		} else if (!srname.equals(other.srname))
			return false;
		
		if (cinema == null) {
			if (other.cinema != null)
				return false;
		} else if (!cinema.equals(other.cinema))
			return false;
		
		return true;
	}
	
	public int getSrid() {
		return srid;
	}

	public void setSrid(int srid) {
		this.srid = srid;
	}

	@Override
	public String toString() {
		return "ScreenRoomId [cinema=" + cinema + ", srname=" + srname + "]";
	}
	
	
	
}