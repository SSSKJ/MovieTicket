package systemanalysis.movieticket.persistence.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="actor")
public class Actor implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ActorId id;
	
	public Actor() {}
	
	public Actor(ActorId id) {
		this.id = id;
	}

	public ActorId getId() {
		return id;
	}

	public void setId(ActorId id) {
		this.id = id;
	}
	
	
}
