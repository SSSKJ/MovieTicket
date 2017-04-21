package systemanalysis.movieticket.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class SeatInOrderId implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JoinColumn(name="orderid", nullable=false)
	@ManyToOne(fetch=FetchType.LAZY)
	private Order order;
	
	@Column(name="row", nullable=false)
	private int row;
	
	@Column(name="column", nullable=false)
	private int column;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + column;
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + row;
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
		SeatInOrderId other = (SeatInOrderId) obj;
		if (column != other.column)
			return false;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (row != other.row)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "SeatInOrderId [order=" + order + ", row=" + row + ", column=" + column + "]";
	}
}
