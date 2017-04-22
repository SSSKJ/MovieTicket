package server;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

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
	
	@Test
	public void test() {
		//userInfo check = service.findOne("test");
		//Assert.assertEquals("123456", check.getPassword()
		
		//----------test the search function-----------
		List<OrderForm> orderForms = service.getOrderForms("1");
		Assert.assertEquals(2, orderForms.size());
		
		List<SeatInOrder> seatInOrders = service.getSeat(1);
		Assert.assertEquals(2, seatInOrders.size());
		seatInOrders = service.getSeat(2);
		Assert.assertEquals(1, seatInOrders.size());
		
		List<Preference> preferences = service.getPreference("1");
		Assert.assertEquals(2, preferences.size());
		preferences = service.getPreference("2");
		Assert.assertEquals("action", preferences.get(0).getPreferenceId().getPreference());
		
		//---------------end of test of search function--------
		
		
		//---------------test delete cascade-------------------
//		service.deleteUser("3");
//		Assert.assertEquals(null, service.getUser("3"));
//		Assert.assertEquals(null, service.getOrderForms("3"));
//		Assert.assertEquals(null, service.getPreference("3"));
		//---------------end of test of delete--------
	}
}
