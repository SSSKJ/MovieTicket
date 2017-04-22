package systemanalysis.movieticket.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import systemanalysis.movieticket.persistence.service.MainService;

@Controller
public class MainController {
	
	@Autowired
	private MainService service;
	
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/Register")
	public void register(String emailaddress, String password) {
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/Login")
	public void Login(String emailaddress, String password) {
		
	}
	
	@RequestMapping("/getOrderForms")
	public void getOrderForms() {
		
	}
}
