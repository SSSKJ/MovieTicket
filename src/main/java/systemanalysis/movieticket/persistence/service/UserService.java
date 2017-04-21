package systemanalysis.movieticket.persistence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import systemanalysis.movieticket.persistence.dao.UserDao;
import systemanalysis.movieticket.persistence.entity.User;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserDao userdao;
	
	public UserService() {
		super();
	}
	
	public void create(final User entity) {
		userdao.create(entity);
	}
	
	public User findOne(String name) {
		return userdao.findOne(name);
	}
	
	public List<User> findAll() {
        return userdao.findAll();
    }
	
	public User update(final User entity) {
		return userdao.update(entity);
	}

}
