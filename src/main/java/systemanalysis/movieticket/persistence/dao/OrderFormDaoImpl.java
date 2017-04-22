package systemanalysis.movieticket.persistence.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import systemanalysis.movieticket.persistence.entity.OrderForm;

@Repository
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
		Query query = entityManager.createQuery("select * from orderform where emailaddress = " + emailaddress);
		List<OrderForm> result = query.getResultList();
		
		return result;
	}
	
	
}
