package server;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.bind.annotation.InitBinder;

import systemanalysis.movieticket.persistence.entity.OrderForm;
import systemanalysis.movieticket.persistence.entity.Preference;
import systemanalysis.movieticket.persistence.entity.SeatInOrder;
import systemanalysis.movieticket.persistence.service.MainService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/movie-servlet.xml"})
public class BaseTest {
	
	@Autowired
	private MainService service;
	
	@Before
	public void init() {
		//----------generate test data------------------
		
		service.Register("1", "123", null, null);//create an account
		String[] pre = {"action", "love"};
		service.setPreference("1", pre);//add preference
		
		//----------end of generating data-------------
	}
	
	@Test
	public void testSearch() {		
		//----------test the preference search function-----------
		
		/*
		 * user "1"'s preference should be "action" and "love
		 */
		List<Preference> preferences = service.getPreference("1");
		Assert.assertEquals(2, preferences.size());
		preferences = service.getPreference("2");
		Assert.assertEquals("action", preferences.get(0).getPreferenceId().getPreference());
		
		//---------------end of test of preference search function-------- 
		
		//--------test foreign key of preference------
		boolean notExist = false;
		try {
			String[] pre = {"action"};
			service.setPreference("2", pre);//user "2" doesn't exist
		} catch (Exception e) {
			notExist= true;
		}
		Assert.assertEquals("true", notExist);
		//--------end of----------------------------
	}
	
	@Test
	public void testDelete() {
		//---------------test delete cascade-------------------
		service.Register("3", "123", null, null);
		String[] pre = {"action", "love", "adv"};
		service.setPreference("3", pre);
		service.deleteUser("3");
		Assert.assertEquals(null, service.getPreference("3"));
		//---------------end of test of delete--------
	}
	
	@After
	public void afterTest () {
		service.deleteUser("1");
	}
	
}
