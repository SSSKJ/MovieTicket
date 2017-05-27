package systemanalysis.movieticket.persistence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import systemanalysis.movieticket.persistence.dao.OrderFormDao;
import systemanalysis.movieticket.persistence.dao.SeatInOrderDao;
import systemanalysis.movieticket.persistence.dao.UserDao;
import systemanalysis.movieticket.persistence.entity.OrderForm;
import systemanalysis.movieticket.persistence.entity.SeatInOrder;
import systemanalysis.movieticket.persistence.entity.SeatInOrderId;
import systemanalysis.movieticket.persistence.entity.User;

@Service
@Transactional
public class OrderService {
	
	@Autowired
	private UserDao userdao;
	
	@Autowired
	private OrderFormDao odao;
	
	@Autowired
	private SeatInOrderDao sdao;
	
	public boolean addOrderForm(String emailaddress, String date, String moviename, String movietime, String cinema, int ticketamount, float price, String screeningroom, int[][] seats ) {
		OrderForm orderform = new OrderForm();
		orderform.setDate(date);
		orderform.setMoviename(moviename);
		orderform.setMovietime(movietime);
		orderform.setCinema(cinema);
		orderform.setTicketamount(ticketamount);
		orderform.setPrice(price);
		orderform.setScreeningroom(screeningroom);
		for (int[] seat:seats) {
			//check if the seat have be occupied
			//if have been occupied return false
		}
		return true;
	}
	
	public List<OrderForm> getOrderForms(String emailaddress) {
		if (userdao.findOne(emailaddress) == null)
			return null;
		return odao.searchAllRelevant(emailaddress);
	}
	
	public OrderForm getOrderForm(int oid) {
		return odao.findOne(oid);
	}
	
	public void deleteOrderForm(int oid) {
		if (odao.findOne(oid) != null)
			odao.deleteById(oid);
	}
	
	public List<SeatInOrder> getSeats(int oid) {
		if (odao.findOne(oid) == null)
			return null;
		return sdao.searchAllRelevant(oid);
	}
	
	public boolean getSeat(int col, int row) {
		//movie controller
		return false;
	}
	
	public void setSeat(int oid, String[] seats) {
		OrderForm orderform = odao.findOne(oid);
		if (orderform != null) {
			SeatInOrder p = new SeatInOrder();
			SeatInOrderId sid = new SeatInOrderId();
			sid.setOrder(orderform);
			for (String seat:seats) {
				//waiting for seat
				//movie database set seat
			}
		}
	}
}
