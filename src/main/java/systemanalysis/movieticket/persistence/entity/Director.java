package systemanalysis.movieticket.persistence.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="director")
public class Director implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public Director() {}
	
	@Id
	@GeneratedValue
	@Column(name="did", nullable=false)
	private int did;
	
	@ManyToMany(mappedBy="d", fetch=FetchType.LAZY)
	private List<Film> films = new ArrayList<Film>();
	
	@Column(name="dname", columnDefinition = "")
	private String dname;

	
	public List<Film> getFilms() {
		return films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}
	
	public int getId() {
		return did;
	}
	
	public void setId(int did) {
		this.did = did;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + did;
		result = prime * result + ((dname == null) ? 0 : dname.hashCode());
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
		
		Director other = (Director) obj;
		if (dname == null) {
			if (other.dname != null);
				return false;
		} else if (!dname.equals(other.dname))
			return false;
		
		if (did != other.did)
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
		return "DirectorId [film=" + films + ", dname=" + dname + "]";
	}
	
	
}