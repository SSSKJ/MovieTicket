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
public class MainService {
	
	@Autowired
	private UserDao userdao;
	
	@Autowired
	private PreferenceDao pdao;
	
	@Autowired
	private OrderFormDao odao;
	
	@Autowired
	private SeatInOrderDao sdao;
	
	public boolean Register(String emailaddress, String password, String nickname, String phone) {
		if (userdao.findOne(emailaddress) == null) {
			User user = new User(emailaddress, password);
			if (nickname != "")
				user.setNickname(nickname);
			user.setPhone(phone);
			return true;
		}
		return false;
	}
	
	public boolean check(String emailaddress) {
		if (userdao.findOne(emailaddress) == null)
			return false;
		else return true;
	}
	
	public void setPreference(String emailaddress, String[] preference) {
		User user = userdao.findOne(emailaddress);
		Preference p = new Preference();
		PreferenceId pid = new PreferenceId();
		pid.SetUser(user);
		for (String prefer:preference) {
			pid.setPreference(prefer);
			if (pdao.findOne(pid) == null) {
				p.setPreferenceId(pid);
				pdao.create(p);
				user.getP().add(p);
			}
		}
		userdao.update(user); // mark
	}
	
	public void modifyNickname(String emailaddress, String nickname) {
		User user = userdao.findOne(emailaddress);
		if (user != null) {
			user.setNickname(nickname);
			userdao.update(user);
		}
	}
	
	public int Login(String emailaddress, String password) {
		User user = userdao.findOne(emailaddress);
		if (user == null)
			return 0;
		else if (user.getPassword() != password)
			return 1;
		return 2;
	}
	
	public List<Preference> getPreference(String emailaddress) {
		return pdao.searchAllRelevant(emailaddress);
	}
	
	public void deletePreference(String emailaddress, String[] preference) {
		User user = userdao.findOne(emailaddress);
		if (user != null) {
			Preference p = new Preference();
			PreferenceId pid = new PreferenceId();
			pid.SetUser(user);
			for (String prefer:preference) {
				pid.setPreference(prefer);
				if (pdao.findOne(pid) != null) {
					p.setPreferenceId(pid);
					pdao.delete(p);
				}
			}
		}
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
}
