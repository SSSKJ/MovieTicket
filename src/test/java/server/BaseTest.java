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
import systemanalysis.movieticket.persistence.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/movie-servlet.xml"})
public class BaseTest {
	
	@Autowired
	private UserService service;
	
	@Before
	public void init() {
		service.deleteUser("1");
		service.deleteUser("3");
	}
	
	@Test
	public void testSearch() {
		//----------generate test data------------------
		
		service.Register("1", "123", "222", "1232");//create an account
		String[] pre = {"action", "love"};
		service.setPreference("1", pre);//add preference
				
		//----------end of generating data-------------
		
		//----------test the preference search function-----------
		
		/*
		 * user "1"'s preference should be "action" and "love
		 */
		List<Preference> preferences = service.getPreference("1");
		Assert.assertEquals(2, preferences.size());
		preferences = service.getPreference("1");
		Assert.assertEquals("action", preferences.get(0).getPreferenceId().getPreference());
		
		//---------------end of test of preference search function-------- 
		
		//--------test foreign key of preference------
//		boolean notExist = false;
//		try {
//			String[] pre = {"action"};
//			service.setPreference("2", pre);//user "2" doesn't exist
//		} catch (Exception e) {
//			notExist= true;
//		}
//		Assert.assertEquals("true", notExist);
		//--------end of----------------------------
		
		//service.deleteUser("1");
		String[] s = {"action"};
		service.deletePreference("1", s);
		Assert.assertEquals("love", preferences.get(0).getPreferenceId().getPreference());
		Assert.assertEquals(false, service.getOnePreference("1", "action"));
	}
	
	@Test
	public void testDelete() {
		//---------------test delete cascade-------------------
		service.Register("3", "123", "22", "1232");
		String[] pre = {"action", "love", "adv"};
		service.setPreference("3", pre);
		Assert.assertEquals(3, service.getPreference("3").size());
		service.deleteUser("3");
		//Assert.assertEquals(0, service.getPreference("3").size());
		//---------------end of test of delete--------
	}
	
	/*@After
	public void afterTest () {
		service.deleteUser("1");
		service.deleteUser("3");
	}*/
	
}
