package systemanalysis.movieticket.persistence.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="seatinorder")
public class SeatInOrder implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private SeatInOrderId id;

	public SeatInOrderId getId() {
		return id;
	}

	public void setId(SeatInOrderId id) {
		this.id = id;
	}
}
