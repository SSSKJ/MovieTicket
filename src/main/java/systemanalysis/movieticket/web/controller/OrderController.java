package systemanalysis.movieticket.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import systemanalysis.movieticket.persistence.entity.OrderForm;
import systemanalysis.movieticket.persistence.service.OrderService;
import systemanalysis.movieticket.persistence.service.UserService;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private UserService userservice;
	
	@Autowired
	private OrderService orderservice;
	
	@RequestMapping(method = RequestMethod.GET, value = "/getorderforms")
	public void getOrderForms(HttpSession session, HttpServletResponse response) throws IOException {
		String email = session.getAttribute("email").toString();
		List<OrderForm> orderforms = orderservice.getOrderForms(email);
		JSONArray ja = new JSONArray();
		JSONObject j;
		for (OrderForm o:orderforms) {
			j = new JSONObject();
			j.put("oid", o.getOid());
			j.put("date", o.getDate());
			j.put("moviename", o.getMoviename());
			j.put("movietime", o.getMovietime());
			j.put("cinema", o.getCinema());
			j.put("ticketamount", o.getTicketamount());
			j.put("price", o.getPrice());
			j.put("screeningroom", o.getScreeningroom());
			ja.add(j);
		}
		response.getWriter().write(ja.toString());
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getorderforms/{formId}")
	public void formdetail() {}
	
	@RequestMapping(method = RequestMethod.POST, value = "/addorderform")
	public void addOrderForm(String date, String moviename, String movietime, String cinema, int ticketamount, float  price, String screeningroom, int[][] seats, HttpSession session, HttpServletResponse response) {
		String email = session.getAttribute("email").toString();
		if (userservice.getUser(email) == null) {
			response.setStatus(1);//set status code
			return;
		}
		if (!orderservice.addOrderForm(email, date, moviename, movietime, cinema, ticketamount, price, screeningroom, seats))
			response.setStatus(1);//set status code
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/deleteorderform")
	public void deleteOrderForm(int oid) {
		orderservice.deleteOrderForm(oid);
	}
}
