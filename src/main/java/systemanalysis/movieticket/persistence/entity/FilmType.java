package systemanalysis.movieticket.persistence.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="filmtype")
public class FilmType implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private FilmTypeId id;
	
	public FilmType() {}
	
	public FilmType(FilmTypeId id) {
		this.id = id;
	}

	public FilmTypeId getId() {
		return id;
	}

	public void setId(FilmTypeId id) {
		this.id = id;
	}
	
	
}