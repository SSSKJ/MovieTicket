package server;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import junit.framework.TestCase;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("../../../main/webapp/WEB-INF/movie-servlet.xml")
public class BaseTest extends TestCase {
	@Before
	public void init() {}
	
}
