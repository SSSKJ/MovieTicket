package systemanalysis.movieticket.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Embeddable
public class FilmVersionId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JoinColumn(name="fid", nullable=false)
	@ManyToOne(fetch=FetchType.LAZY)
	private Film film;
	
	@Column(name="versionType", columnDefinition = "")
	private String versionType;

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	
	public String getVersionType() {
		return versionType;
	}

	public void setVersionType(String versionType) {
		this.versionType = versionType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((versionType == null) ? 0 : versionType.hashCode());
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
		
		FilmVersionId other = (FilmVersionId) obj;
		if (versionType == null) {
			if (other.versionType != null);
				return false;
		} else if (!versionType.equals(other.versionType))
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
		return "FilmVersionId [film=" + film + ", versionType=" + versionType + "]";
	}
}