package systemanalysis.movieticket.persistence.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import systemanalysis.movieticket.persistence.dao.OrderFormDao;
import systemanalysis.movieticket.persistence.dao.PlayListDao;
import systemanalysis.movieticket.persistence.dao.PreferenceDao;
import systemanalysis.movieticket.persistence.dao.SeatChartDao;
import systemanalysis.movieticket.persistence.dao.UserDao;
import systemanalysis.movieticket.persistence.entity.OrderForm;
import systemanalysis.movieticket.persistence.entity.PlayList;
import systemanalysis.movieticket.persistence.entity.Preference;
import systemanalysis.movieticket.persistence.entity.PreferenceId;
import systemanalysis.movieticket.persistence.entity.SeatChart;
import systemanalysis.movieticket.persistence.entity.User;

@Service
@Transactional
public class UserService {
	
	private static final Logger logger = Logger.getLogger(UserService.class);
	
	@Autowired
	private UserDao userdao;
	
	@Autowired
	private PreferenceDao pdao;
	
	@Autowired
	private OrderFormDao odao;
	
	@Autowired
	private SeatChartDao scdao;
	
	@Autowired
	private PlayListDao pldao;
	
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
				logger.info("User: " + emailaddress + " set Preference" + prefer);
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
		List<Preference> preference = pdao.searchAllRelevant(emailaddress);
		for (Preference p:preference)
			pdao.delete(p);
		logger.info("User: " + emailaddress + " delete All Preferences");
	}
	
	public boolean getOnePreference(String emailaddress, String preference) {
		if (!check(emailaddress)) return false;
		User user = userdao.findOne(emailaddress);
		PreferenceId pid = new PreferenceId();
		pid.SetUser(user);
		pid.setPreference(preference);
		if (pdao.findOne(pid) != null)
			return true;
		return false;
	}
	
	public void modifyNickname(String emailaddress, String nickname) {
		User user = userdao.findOne(emailaddress);
		if (user != null) {
			String temp = user.getNickname();
			user.setNickname(nickname);
			userdao.update(user);
			logger.info("User: " + emailaddress + " modify Nickiname: " + temp + "to " + user.getNickname() +  " successfully");
		} else
			logger.info("User: " + emailaddress + " fail to modify Nickiname, User doesn't Exist");
	}
	
	public void modifyPhone(String emailaddress, String phone) {
		User user = userdao.findOne(emailaddress);
		if (user != null) {
			String temp = user.getPhone();
			user.setPhone(phone);
			userdao.update(user);
			logger.info("User: " + emailaddress + " modify Phone: " + temp + "to " + user.getPhone() +  " successfully");
		} else
			logger.info("User: " + emailaddress + " fail to modify Phone, User doesn't Exist");
	}
	
	public void modifyPassword(String emailaddress, String password) {
		User user = userdao.findOne(emailaddress);
		if (user != null) {
			String temp = user.getPassword();
			user.setPassword(password);
			userdao.update(user);
			logger.info("User: " + emailaddress + " modify Password: " + temp + "to " + user.getPassword() +  " successfully");
		} else
			logger.info("User: " + emailaddress + " fail to modify Password, User doesn't Exist");
	}
	
	public boolean addOrderForm(int plid, String email, int[] seats) {
		for (int s:seats) {
			SeatChart seat = scdao.findOne(s);
			if (seat.isAvailable()) {
				seat.setAvailable(false);
				scdao.update(seat);
			} else {
				logger.info("User: " + email + " fail to Add OrderForm, Seat: " + s + " has been occupied");
				return false;
			}
		}
		User user = userdao.findOne(email);
		PlayList p = pldao.findOne(plid);
		OrderForm orderform = new OrderForm();
		orderform.setDate(p.getPlayDate() + "");
		orderform.setMoviename(p.getFilm().getFname());
		orderform.setMovietime(p.getPlayTime());
		orderform.setCinema(p.getCinema().getCname());
		orderform.setTicketamount(seats.length);
		orderform.setPrice(p.getPrice() * seats.length);
		orderform.setScreeningroom(p.getsRoom());
		orderform.setUser(user);
		odao.create(orderform);
		logger.info("User: " + email + " add OrderForm(oid: " + orderform.getOid() + ") successfully");//maybe can not get oid
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
}
