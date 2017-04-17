package server;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import systemanalysis.movieticket.persistence.entity.userInfo;
import systemanalysis.movieticket.persistence.service.userInfoService;

public class DatabaseTest extends BaseTest {
	
	@Autowired
	private userInfoService service;
	
	@Test
	public void test() {
		userInfo check = service.findOne("test");
		Assert.assertEquals("123456", check.getPassword());
	}

}
