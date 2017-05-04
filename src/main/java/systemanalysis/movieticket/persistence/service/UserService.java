package systemanalysis.movieticket.persistence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import systemanalysis.movieticket.persistence.dao.OrderFormDao;
import systemanalysis.movieticket.persistence.dao.PreferenceDao;
import systemanalysis.movieticket.persistence.dao.SeatInOrderDao;
import systemanalysis.movieticket.persistence.dao.UserDao;
import systemanalysis.movieticket.persistence.entity.OrderForm;
import systemanalysis.movieticket.persistence.entity.Preference;
import systemanalysis.movieticket.persistence.entity.PreferenceId;
import systemanalysis.movieticket.persistence.entity.SeatInOrder;
import systemanalysis.movieticket.persistence.entity.SeatInOrderId;
import systemanalysis.movieticket.persistence.entity.User;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserDao userdao;
	
	@Autowired
	private PreferenceDao pdao;
	
	@Autowired
	private OrderFormDao odao;
	
	@Autowired
	private SeatInOrderDao sdao;
	
	public User getUser(String emailaddress) {
		return userdao.findOne(emailaddress);
	}
	
	//This is just for test
	public void deleteUser(String emailaddress) {
		if (check(emailaddress)) {
			userdao.deleteById(emailaddress);
		}
	}
	
	public boolean check(String emailaddress) {
		if (userdao.findOne(emailaddress) == null)
			return false;
		else return true;
	}
	
	public void setPreference(String emailaddress, String[] preference) {
		if (!check(emailaddress)) return;
		User user = userdao.findOne(emailaddress);
		for (String prefer:preference) {
			Preference p = new Preference();
			PreferenceId pid = new PreferenceId();
			pid.SetUser(user);
			pid.setPreference(prefer);
			if (pdao.findOne(pid) == null) {
				p.setPreferenceId(pid);
				pdao.create(p);
				user.getP().add(p);
			}
		}
	}
	
	public List<Preference> getPreference(String emailaddress) {
		return pdao.searchAllRelevant(emailaddress);
	}
	
	public void deletePreference(String emailaddress, String[] preference) {
		if (!check(emailaddress)) return;
		User user = userdao.findOne(emailaddress);
		for (String prefer:preference) {
			PreferenceId pid = new PreferenceId();
			pid.SetUser(user);
			pid.setPreference(prefer);
			Preference p = pdao.findOne(pid);
			if (p != null)
				pdao.delete(p);
		}
	}
	
	public void deleteAllPreference(String emailaddress) {
		if (!check(emailaddress)) return;
		User user = userdao.findOne(emailaddress);
		List<Preference> preference = pdao.searchAllRelevant(emailaddress);
		for (Preference p:preference)
			pdao.delete(p);
	}
	
	public boolean getOnePreference(String emailaddress, String preference) {
		if (!check(emailaddress)) return false;
		User user = userdao.findOne(emailaddress);
		Preference p = new Preference();
		PreferenceId pid = new PreferenceId();
		pid.SetUser(user);
		pid.setPreference(preference);
		if (pdao.findOne(pid) != null)
			return true;
		return false;
	}
	
	public void addOrderForm() {}
	
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
	
	public List<SeatInOrder> getSeat(int oid) {
		if (odao.findOne(oid) == null)
			return null;
		return sdao.searchAllRelevant(oid);
	}
	
	public void setSeat(int oid, String[] seats) {
		OrderForm orderform = odao.findOne(oid);
		if (orderform != null) {
			SeatInOrder p = new SeatInOrder();
			SeatInOrderId sid = new SeatInOrderId();
			sid.setOrder(orderform);
			for (String seat:seats) {
				//waiting for seat
			}
		}
	}
	
	public void modifyNickname(String emailaddress, String nickname) {
		User user = userdao.findOne(emailaddress);
		if (user != null) {
			user.setNickname(nickname);
			userdao.update(user);
		}
	}
	
	public void modifyPhone(String emailaddress, String phone) {
		User user = userdao.findOne(emailaddress);
		if (user != null) {
			user.setPhone(phone);
			userdao.update(user);
		}
	}
	
	public void modifyPassword(String emailaddress, String password) {
		User user = userdao.findOne(emailaddress);
		if (user != null) {
			user.setPassword(password);
			userdao.update(user);
		}
	}
	
	//need to modify
	public void modifyPreference(String emailaddress, String[] preference) {
		deleteAllPreference(emailaddress);
		setPreference(emailaddress, preference);
	}
}
