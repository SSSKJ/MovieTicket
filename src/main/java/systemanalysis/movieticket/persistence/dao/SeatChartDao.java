package systemanalysis.movieticket.persistence.dao;

import java.util.List;

import systemanalysis.movieticket.persistence.entity.SeatChart;
import systemanalysis.movieticket.persistence.entity.SeatChartId;

public interface SeatChartDao {
	List<SeatChart> searchAllRelevant(String plid);
	
	SeatChart findOne(SeatChartId sid);
	
	List<SeatChart> findAll();
	
    void create(SeatChart entity);

    SeatChart update(SeatChart entity);

    void delete(SeatChart entity);
}
