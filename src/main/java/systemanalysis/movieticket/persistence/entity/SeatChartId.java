package systemanalysis.movieticket.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class SeatChartId implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JoinColumn(name="plid", nullable=false)
	@ManyToOne(fetch=FetchType.LAZY)
	private PlayList playList;
	
	@Column(name="row", nullable=false)
	private int row;
	
	@Column(name="col", nullable=false)
	private int col;
	
	@Column(name="isAvailable", nullable=false)
	private boolean isAvailable;

	

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
		result = prime * result + ((playList == null) ? 0 : playList.hashCode());
		result = prime * result + row;
		return result;
	}

	public PlayList getPlayList() {
		return playList;
	}

	public void setPlayList(PlayList playList) {
		this.playList = playList;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SeatChartId other = (SeatChartId) obj;
		if (col != other.col)
			return false;
		if (playList == null) {
			if (other.playList != null)
				return false;
		} else if (!playList.equals(other.playList))
			return false;
		if (row != other.row)
			return false;
		
		if (isAvailable != other.isAvailable)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "SeatChartId [playList=" + playList + ", row=" + row + ", column=" + col
				+ ", isAvailable=" + isAvailable + "]";
	}
}

