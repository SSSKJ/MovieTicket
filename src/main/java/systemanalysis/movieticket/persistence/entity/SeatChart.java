package systemanalysis.movieticket.persistence.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="seatchart")
public class SeatChart implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="scid", nullable=false)
	private int scid;

	@ManyToMany(mappedBy="seatChart", fetch=FetchType.LAZY)
	private List<PlayList> playList = new ArrayList<PlayList>();
	
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
	
	public int getId() {
		return scid;
	}

	public void setId(int scid) {
		this.scid = scid;
	}

	public List<PlayList> getPlayList() {
		return playList;
	}

	public void setPlayList(List<PlayList> playList) {
		this.playList = playList;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + scid;
		result = prime * result + col;
		result = prime * result + ((playList == null) ? 0 : playList.hashCode());
		result = prime * result + row;
		return result;
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
		SeatChart other = (SeatChart) obj;
		if (col != other.col)
			return false;
		if (playList == null) {
			if (other.playList != null)
				return false;
		} else if (!playList.equals(other.playList))
			return false;
		if (row != other.row)
			return false;
		
		if (scid != other.scid)
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