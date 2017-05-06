package systemanalysis.movieticket.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Embeddable
public class FilmTypeId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JoinColumn(name="fid", nullable=false)
	@ManyToOne(fetch=FetchType.LAZY)
	private Film film;
	
	@Column(name="filmType", columnDefinition = "")
	private String filmType;

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	
	public String getFilmType() {
		return filmType;
	}

	public void setFilmType(String filmType) {
		this.filmType = filmType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((filmType == null) ? 0 : filmType.hashCode());
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
		
		FilmTypeId other = (FilmTypeId) obj;
		if (filmType == null) {
			if (other.filmType != null);
				return false;
		} else if (!filmType.equals(other.filmType))
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
		return "FilmTypeId [film=" + film + ", filmType=" + filmType + "]";
	}
}