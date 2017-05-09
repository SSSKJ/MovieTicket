package systemanalysis.movieticket.persistence.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="seatchart")
public class SeatChart implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private SeatChartId id;
	
	public SeatChart() {}
	
	public SeatChart(SeatChartId id) {
		this.id = id;
	}

	public SeatChartId getId() {
		return id;
	}

	public void setId(SeatChartId id) {
		this.id = id;
	}
	
	
}