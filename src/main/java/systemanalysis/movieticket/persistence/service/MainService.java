package systemanalysis.movieticket.persistence.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import systemanalysis.movieticket.persistence.dao.UserDao;
import systemanalysis.movieticket.persistence.dto.InfoDto;
import systemanalysis.movieticket.persistence.dto.UserDto;
import systemanalysis.movieticket.persistence.entity.User;

@Service
@Transactional
public class MainService {
	
	private static final Logger logger = Logger.getLogger(MainService.class);
	
	@Autowired
	private UserDao userdao;
	
	public boolean Register(UserDto u, InfoDto info) {
		if (userdao.findOne(u.getEmail()) == null) {
			User user = new User(u.getEmail(), u.getPassword());
			if (info.getNickname() != "")
				user.setNickname(info.getNickname());
			user.setPhone(info.getPhone());
			userdao.create(user);
			logger.info("Successful Register: " + u.getEmail());
			return true;
		}
		logger.info("Fail to Register: " + u.getEmail() + ", Email already Exist");
		return false;
	}
	
	public boolean check(String emailaddress) {
		if (userdao.findOne(emailaddress) == null)
			return false;
		else return true;
	}
	
	public int Login(UserDto u) {
		User user = userdao.findOne(u.getEmail());
		if (user == null)
			return 0;
		else if (!user.getPassword().equals(u.getPassword()))
			return 1;
		return 2;
	}
}
