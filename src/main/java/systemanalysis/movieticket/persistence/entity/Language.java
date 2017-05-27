package systemanalysis.movieticket.persistence.entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="language")
public class Language implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="lid", nullable=false)
	private int lid;
	
	@ManyToMany(mappedBy="l", fetch=FetchType.LAZY)
	private List<Film> films = new ArrayList<Film>();
	
	public List<Film> getFilms() {
		return films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}

	@Column(name="language", columnDefinition = "")
	private String language;
	
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	
	public int getId() {
		return lid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + lid;
		result = prime * result + ((language == null) ? 0 : language.hashCode());
		result = prime * result + ((films == null) ? 0 : films.hashCode());
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
		
		Language other = (Language) obj;
		if (language == null) {
			if (other.language != null);
				return false;
		} else if (!language.equals(other.language))
			return false;
		
		if (lid != other.lid)
			return false;
		
		if (films == null) {
			if (other.films != null)
				return false;
		} else if (!films.equals(other.films))
			return false;
		
		return true;
	}
	
	@Override
	public String toString() {
		return "LanguageId [id=" + lid + ", film=" + films + ", language=" + language + "]";
	}
}