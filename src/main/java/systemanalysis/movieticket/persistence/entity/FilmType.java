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
@Table(name="filmtype")
public class FilmType implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="ftid", nullable=false)
	private int ftid;
	

	@ManyToMany(mappedBy="ft", fetch=FetchType.LAZY)
	private List<Film> films = new ArrayList<Film>();
	
	@Column(name="filmType", columnDefinition = "")
	private String filmType;
	
	public int getId() {
		return ftid;
	}
	
	public void setId(int ftid) {
		this.ftid = ftid;
	}

	public List<Film> getFilms() {
		return films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
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
		result = prime * result + ftid;
		result = prime * result + ((filmType == null) ? 0 : filmType.hashCode());
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
		
		FilmType other = (FilmType) obj;
		if (filmType == null) {
			if (other.filmType != null);
				return false;
		} else if (!filmType.equals(other.filmType))
			return false;
		
		if (ftid != other.ftid)
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
		return "FilmTypeId [id=" + ftid + ", film=" + films + ", filmType=" + filmType + "]";
	}
	
	
}