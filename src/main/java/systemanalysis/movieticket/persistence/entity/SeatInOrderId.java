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
	private OrderForm orderform;
	
	@Column(name="row", nullable=false)
	private int row;
	
	@Column(name="col", nullable=false)
	private int col;

	public OrderForm getOrder() {
		return orderform;
	}

	public void setOrder(OrderForm orderform) {
		this.orderform = orderform;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return col;
	}

	public void setColumn(int col) {
		this.col = col;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + col;
		result = prime * result + ((orderform == null) ? 0 : orderform.hashCode());
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
		if (col != other.col)
			return false;
		if (orderform == null) {
			if (other.orderform != null)
				return false;
		} else if (!orderform.equals(other.orderform))
			return false;
		if (row != other.row)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "SeatInOrderId [order=" + orderform + ", row=" + row + ", column=" + col + "]";
	}
}
