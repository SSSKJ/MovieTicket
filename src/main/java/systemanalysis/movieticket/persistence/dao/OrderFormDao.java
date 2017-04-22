package systemanalysis.movieticket.persistence.dao;

import java.util.List;

import systemanalysis.movieticket.persistence.entity.OrderForm;

public interface OrderFormDao {
	
	//Search order by emailaddress
	List<OrderForm> searchAllRelevant(String emailaddress);
	//Delete orderform by oid
	//Delete all relevant orderform by emailaddress
	OrderForm findOne(String emailaddress);
	
	List<OrderForm> findAll();
	
    void create(OrderForm entity);

    OrderForm update(OrderForm entity);

    void delete(OrderForm entity);

    void deleteById(OrderForm entityemailaddress);
    
}
