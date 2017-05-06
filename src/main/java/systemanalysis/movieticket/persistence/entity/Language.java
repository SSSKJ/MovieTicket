package systemanalysis.movieticket.persistence.entity;
import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="language")
public class Language implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private LanguageId id;
	
	public Language() {}
	
	public Language(LanguageId id) {
		this.id = id;
	}

	public LanguageId getId() {
		return id;
	}

	public void setId(LanguageId id) {
		this.id = id;
	}
	
	
}