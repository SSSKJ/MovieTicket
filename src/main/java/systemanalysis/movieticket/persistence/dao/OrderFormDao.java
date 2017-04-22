package systemanalysis.movieticket.persistence.dao;

import java.util.List;

import systemanalysis.movieticket.persistence.entity.OrderForm;

public interface OrderFormDao {
	
	//Search all relevant order by emailaddress
	List<OrderForm> searchAllRelevant(String emailaddress);
	
	OrderForm findOne(int oid);
	
	List<OrderForm> findAll();
	
    void create(OrderForm entity);

    OrderForm update(OrderForm entity);

    void delete(OrderForm entity);
    
    //Delete orderform by oid
    void deleteById(int oid);
    
}
