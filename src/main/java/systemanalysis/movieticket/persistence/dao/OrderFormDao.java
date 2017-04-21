package systemanalysis.movieticket.persistence.dao;

import java.util.List;

import systemanalysis.movieticket.persistence.entity.OrderForm;
import systemanalysis.movieticket.persistence.entity.Preference;

public interface OrderFormDao {
	
	//Search order by emailaddress
	//Delete orderform by oid
	//Delete all relevant orderform by emailaddress
	OrderForm findOne(String emailaddress);

    void create(OrderForm entity);

    OrderForm update(OrderForm entity);

    void delete(OrderForm entity);

    void deleteById(OrderForm entityemailaddress);
    
    //Search all relevant preference by emailaddress and return in type List<Preference>
    //List<OrderForm> searchAllRelevant(String emailaddress);
}
