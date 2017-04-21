package systemanalysis.movieticket.persistence.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="preference")
public class Preference implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private PreferenceId id;
	
	public Preference() {}
	
	public Preference(PreferenceId id) {
		this.id = id;
	}
	
	public void setPreferenceId(PreferenceId id) {
		this.id = id;
	}
	
	public PreferenceId getPreferenceId() {
		return id;
	}
}
