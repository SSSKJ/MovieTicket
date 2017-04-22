package systemanalysis.movieticket.persistence.dao;

import java.util.List;

import systemanalysis.movieticket.persistence.entity.SeatInOrder;
import systemanalysis.movieticket.persistence.entity.SeatInOrderId;

public interface SeatInOrderDao {
	
	SeatInOrder findOne(SeatInOrderId id);

    List<SeatInOrder> findAll();

    void create(SeatInOrder entity);

    SeatInOrder update(SeatInOrder entity);

    void delete(SeatInOrder entity);

    void deleteById(SeatInOrderId id);
    
    //Search all relevant preference by emailaddress and return in type List<SeatInOrder>
    List<SeatInOrder> searchAllRelevant(int oid);
    
}
