package systemanalysis.movieticket.persistence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import systemanalysis.movieticket.persistence.dao.userInfoDao;
import systemanalysis.movieticket.persistence.entity.userInfo;

@Service
@Transactional
public class userInfoService {
	
	@Autowired
	private userInfoDao dao;
	
	public userInfoService() {
		super();
	}
	
	// API
    public void create(final userInfo entity) {
        dao.create(entity);
    }

    public userInfo findOne(final String username) {
        return dao.findOne(username);
    }

    public List<userInfo> findAll() {
        return dao.findAll();
    }
    
    public void print() {
    	System.out.println("ok.......................");
    }
}
