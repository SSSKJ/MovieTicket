package systemanalysis.movieticket.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Embeddable
public class ActorId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JoinColumn(name="fid", nullable=false)
	@ManyToOne(fetch=FetchType.LAZY)
	private Film film;
	
	@Column(name="aname", columnDefinition = "")
	private String aname;

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aname == null) ? 0 : aname.hashCode());
		result = prime * result + ((film == null) ? 0 : film.hashCode());
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
		
		ActorId other = (ActorId) obj;
		if (aname == null) {
			if (other.aname != null);
				return false;
		} else if (!aname.equals(other.aname))
			return false;
		
		if (film == null) {
			if (other.film != null)
				return false;
		} else if (!film.equals(other.film))
			return false;
		
		return true;
	}
	
	@Override
	public String toString() {
		return "ActorId [film=" + film + ", aname=" + aname + "]";
	}
}
