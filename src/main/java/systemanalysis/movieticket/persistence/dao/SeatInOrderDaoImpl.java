package systemanalysis.movieticket.persistence.dao;

import java.util.List;

import javax.persistence.Query;
import systemanalysis.movieticket.persistence.entity.SeatInOrder;
import systemanalysis.movieticket.persistence.entity.SeatInOrderId;

public class SeatInOrderDaoImpl extends AbstractJpaDAO<SeatInOrder> implements SeatInOrderDao {
	
	public SeatInOrderDaoImpl() {
		super();
		setClazz(SeatInOrder.class);
	}
	
	public SeatInOrder findOne(final SeatInOrderId id) {
        return entityManager.find(SeatInOrder.class, id);
    }
	
	public void deleteById(final SeatInOrderId id) {
		final SeatInOrder entity = findOne(id);
		delete(entity);
	}
	
	@SuppressWarnings("unchecked")
	public List<SeatInOrder> searchAllRelevant(int oid) {
		Query query = entityManager.createQuery("selete * from seatinorder where oid = " + oid);
		List<SeatInOrder> result = query.getResultList();
		return result; 
	}

}
