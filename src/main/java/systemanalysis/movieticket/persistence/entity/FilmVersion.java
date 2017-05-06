package systemanalysis.movieticket.persistence.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="filmversion")
public class FilmVersion implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private DirectorId id;
	
	public FilmVersion() {}
	
	public FilmVersion(DirectorId id) {
		this.id = id;
	}

	public DirectorId getId() {
		return id;
	}

	public void setId(DirectorId id) {
		this.id = id;
	}
	
	
}