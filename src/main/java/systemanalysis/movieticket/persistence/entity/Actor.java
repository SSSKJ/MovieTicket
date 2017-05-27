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
@Table(name="actor")
public class Actor implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int aid;
	
	@ManyToMany(mappedBy="a", fetch=FetchType.LAZY)
	private List<Film> films = new ArrayList<Film>();
	
	@Column(name="aname", columnDefinition = "")
	private String aname;

	

	public List<Film> getFilms() {
		return films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}
	
	public int getId() {
		return aid;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + aid;
		result = prime * result + ((aname == null) ? 0 : aname.hashCode());
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
		
		Actor other = (Actor) obj;
		if (aname == null) {
			if (other.aname != null);
				return false;
		} else if (!aname.equals(other.aname))
			return false;
		
		if (other.aid != aid)
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
		return "Actor [ id= " + aid +  ", film=" + films + ", aname=" + aname + "]";
	}
	
	
}
