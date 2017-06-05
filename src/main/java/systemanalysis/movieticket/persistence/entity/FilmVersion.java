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
@Table(name="filmversion")
public class FilmVersion implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="fvid", nullable=false)
	private int fvid;
	
	@ManyToMany(mappedBy="fv", fetch=FetchType.LAZY)
	private List<Film> films = new ArrayList<Film>();
	
	public List<Film> getFilms() {
		return films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}

	@Column(name="versionType", columnDefinition = "")
	private String versionType;

	
	public String getVersionType() {
		return versionType;
	}

	public void setVersionType(String versionType) {
		this.versionType = versionType;
	}
	
	public int getId() {
		return fvid;
	}
	
	public void setId(int fvid) {
		this.fvid = fvid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + fvid;
		result = prime * result + ((versionType == null) ? 0 : versionType.hashCode());
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
		
		FilmVersion other = (FilmVersion) obj;
		if (versionType == null) {
			if (other.versionType != null);
				return false;
		} else if (!versionType.equals(other.versionType))
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
		return "FilmVersionId [id=" + fvid + ", film=" + films + ", versionType=" + versionType + "]";
	}
	
	
}