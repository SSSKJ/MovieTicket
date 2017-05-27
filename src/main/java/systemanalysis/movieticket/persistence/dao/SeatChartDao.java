package systemanalysis.movieticket.persistence.dao;

import java.util.List;

import systemanalysis.movieticket.persistence.entity.SeatChart;

public interface SeatChartDao {
	List<SeatChart> searchAllRelevant(int plid);
	
	SeatChart findOne(int scid);
	
	List<SeatChart> findAll();
	
    void create(SeatChart entity);

    SeatChart update(SeatChart entity);

    void delete(SeatChart entity);
}
