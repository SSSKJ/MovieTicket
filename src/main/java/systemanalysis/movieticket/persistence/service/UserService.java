package systemanalysis.movieticket.persistence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import systemanalysis.movieticket.persistence.dao.PreferenceDao;
import systemanalysis.movieticket.persistence.dao.UserDao;
import systemanalysis.movieticket.persistence.entity.Preference;
import systemanalysis.movieticket.persistence.entity.PreferenceId;
import systemanalysis.movieticket.persistence.entity.User;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserDao userdao;
	
	@Autowired
	private PreferenceDao pdao;
	
	public User getUser(String emailaddress) {
		return userdao.findOne(emailaddress);
	}
	
	//This is just for test
	public void deleteUser(String emailaddress) {
		if (check(emailaddress)) {
			userdao.deleteById(emailaddress);
		}
	}
	
	private boolean check(String emailaddress) {
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
		List<Preference> preference = pdao.searchAllRelevant(emailaddress);
		for (Preference p:preference)
			pdao.delete(p);
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
