package systemanalysis.movieticket.persistence.dao;

import java.util.List;

import javax.persistence.Query;

import systemanalysis.movieticket.persistence.entity.OrderForm;

public class OrderFormDaoImpl extends AbstractJpaDAO<OrderForm> implements OrderFormDao {
	
	public OrderFormDaoImpl() {
		super();
		setClazz(OrderForm.class);
	}

	public OrderForm findOne(int oid) {
		// TODO Auto-generated method stub
		return entityManager.find(OrderForm.class, oid);
	}

	public void deleteById(int oid) {
		// TODO Auto-generated method stub
		final OrderForm entity = findOne(oid);
		delete(entity);
	}

	@SuppressWarnings("unchecked")
	public List<OrderForm> searchAllRelevant(String emailaddress) {
		Query query = entityManager.createQuery("selete * from orderform where emailaddress = " + emailaddress);
		List<OrderForm> result = query.getResultList();
		
		return result;
	}
	
	
}
