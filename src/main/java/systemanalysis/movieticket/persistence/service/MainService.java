package systemanalysis.movieticket.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;

import systemanalysis.movieticket.persistence.dao.OrderFormDao;
import systemanalysis.movieticket.persistence.dao.PreferenceDao;
import systemanalysis.movieticket.persistence.dao.SeatInOrderDao;
import systemanalysis.movieticket.persistence.dao.UserDao;
import systemanalysis.movieticket.persistence.entity.User;

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
			userdao.create(user);
			return true;
		}
		return false;
	}
	
	public boolean check(String emailaddress) {
		if (userdao.findOne(emailaddress) == null)
			return false;
		else return true;
	}
	
	public int Login(String emailaddress, String password) {
		User user = userdao.findOne(emailaddress);
		if (user == null)
			return 0;
		else if (!user.getPassword().equals(password))
			return 1;
		return 2;
	}
}
