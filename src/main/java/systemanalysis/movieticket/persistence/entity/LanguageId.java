package systemanalysis.movieticket.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Embeddable
public class LanguageId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JoinColumn(name="fid", nullable=false)
	@ManyToOne(fetch=FetchType.LAZY)
	private Film film;
	
	@Column(name="language", columnDefinition = "")
	private String language;

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((language == null) ? 0 : language.hashCode());
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
		
		LanguageId other = (LanguageId) obj;
		if (language == null) {
			if (other.language != null);
				return false;
		} else if (!language.equals(other.language))
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
		return "LanguageId [film=" + film + ", language=" + language + "]";
	}
}