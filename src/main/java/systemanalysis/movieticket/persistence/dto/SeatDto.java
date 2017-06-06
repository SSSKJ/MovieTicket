package systemanalysis.movieticket.persistence.dto;

import systemanalysis.movieticket.persistence.entity.SeatChart;

public class SeatDto {
	
	int seatid;
	int row;
	int col;
	boolean isAvailable;
	
	public SeatDto() {}
	
	public SeatDto(SeatChart s) {
		seatid = s.getId();
		row = s.getRow();
		col = s.getColumn();
		isAvailable = s.isAvailable();
	}
	
	public int getSeatid() {
		return seatid;
	}
	
	public void setSeatid(int seatid) {
		this.seatid = seatid;
	}
	
	public int getRow() {
		return row;
	}
	
	public void setRow(int row) {
		this.row = row;
	}
	
	public int getCol() {
		return col;
	}
	
	public void setCol(int col) {
		this.col = col;
	}
	
	public boolean isAvailable() {
		return isAvailable;
	}
	
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
}
