package systemanalysis.movieticket.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Embeddable
public class DirectorId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JoinColumn(name="fid", nullable=false)
	@ManyToOne(fetch=FetchType.LAZY)
	private Film film;
	
	@Column(name="dname", columnDefinition = "")
	private String dname;

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	
	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dname == null) ? 0 : dname.hashCode());
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
		
		DirectorId other = (DirectorId) obj;
		if (dname == null) {
			if (other.dname != null);
				return false;
		} else if (!dname.equals(other.dname))
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
		return "DirectorId [film=" + film + ", dname=" + dname + "]";
	}
}