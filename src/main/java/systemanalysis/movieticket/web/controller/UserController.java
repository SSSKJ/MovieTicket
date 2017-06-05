package systemanalysis.movieticket.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONArray;
import systemanalysis.movieticket.persistence.dto.OrderFormDetailDto;
import systemanalysis.movieticket.persistence.dto.UserDetailDto;
import systemanalysis.movieticket.persistence.entity.OrderForm;
import systemanalysis.movieticket.persistence.entity.PlayList;
import systemanalysis.movieticket.persistence.entity.Preference;
import systemanalysis.movieticket.persistence.entity.User;
import systemanalysis.movieticket.persistence.service.MovieService;
import systemanalysis.movieticket.persistence.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private static final Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	private UserService userservice;
	
	@Autowired
	private MovieService movieservice;
	
	@ApiOperation(value = "检测session中的email", notes = "用于当浏览器存在session时判断该session是否合法")
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public void check(HttpSession session, HttpServletResponse response) {
		String email = session.getAttribute("email").toString();
		if (userservice.check(email)) {
			response.setStatus(200);
			logger.info("Session(Email: " + email + ") is Valid");
		} else {
			response.setStatus(401);
			logger.info("Session is Invalid");
		}
	}
	
	@ApiOperation(value = "用户名获取", notes = "用于获取用户名")
	@RequestMapping(method = RequestMethod.GET, value = "/getnickname")
	public void getnickname(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException {
		String email = session.getAttribute("email").toString();
		User user = userservice.getUser(email);
		response.getWriter().write(user.getNickname());
		logger.info("User: " + email + " get Nickname: " + user.getNickname());
	}
	
	@ApiOperation(value = "用户基础信息获取", notes = "用于获取用户信息")
	@RequestMapping(method = RequestMethod.GET, value = "/getinfo")
	@ResponseBody
	public UserDetailDto userinfo(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException {
		//System.out.println(session.getId() + "........");
		String email = session.getAttribute("email").toString();
		User user = userservice.getUser(email);
		//System.out.println(user.getNickname() + "........2");
		UserDetailDto detail = new UserDetailDto(user);
		logger.info("User: " + email + " get Details");
		return detail;
	}
	
	@ApiOperation(value = "用户偏好类型获取", notes = "用户获取用户偏好的电影类型")
	@RequestMapping(method = RequestMethod.GET, value = "/getpreference")
	@ResponseBody
	public void userpreference(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException {
		//System.out.println(session.getId() + "........");
		String email = session.getAttribute("email").toString();
		List<Preference> preference = userservice.getPreference(email);
		//System.out.println(preference.get(0).getPreferenceId().getPreference() + "........3");
		JSONArray j = new JSONArray();
		//List<String> pf = new ArrayList<String>();
		for (Preference p:preference)
			j.add(p.getPreferenceId().getPreference());
		//System.out.println(j);
		logger.info("User: " + email + " get Preference");
		response.getWriter().write(j.toString());
	}
	
	@ApiOperation(value = "修改用户信息", notes = "用于修改用户基础信息，包括电话号码、用户名、偏好")
	@RequestMapping(method = RequestMethod.POST, value = "/modifyuser")
	public void modifyuser(String phone, String nickname, @RequestParam(value="preference[]") String[] preference, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		String email = session.getAttribute("email").toString();
		//check format
		if (phone != null) {
			logger.info("User: " + email + " modify Phone");
			userservice.modifyPhone(email, phone);
		}
		if (nickname != null) {
			logger.info("User: " + email + " modify Nickname");
			userservice.modifyNickname(email, nickname);
		}
		if (preference != null) {
			logger.info("User: " + email + " modify Preference");
			userservice.deleteAllPreference(email);
			userservice.setPreference(email, preference);
		}
	}
	
	@ApiOperation(value = "修改密码", notes = "用于修改用户密码")
	@RequestMapping(method = RequestMethod.POST, value = "/modifypassword")
	public void modifypassword(String password, HttpSession session) {
		String email = session.getAttribute("email").toString();
		//check password format
		logger.info("User: " + email + " modify Password");
		userservice.modifyPassword(email, password);
	}
	
	@ApiOperation(value = "获取全部订单", notes = "用于获取已存在或历史的全部订单")
	@RequestMapping(method = RequestMethod.GET, value = "/getorderforms")
	@ResponseBody
	public List<OrderFormDetailDto> getOrderForms(HttpSession session, HttpServletResponse response) throws IOException {
		String email = session.getAttribute("email").toString();
		List<OrderForm> orderforms = userservice.getOrderForms(email);
		List<OrderFormDetailDto> details = new ArrayList<OrderFormDetailDto>();
		for (OrderForm o:orderforms) {
			OrderFormDetailDto temp = new OrderFormDetailDto(o);
			details.add(temp);
		}
		logger.info("User: " + email + " get All OrderForms");
		return details;
	}
	
	@ApiOperation(value = "获取特定订单", notes = "用于获取特定的某个订单的详细信息")
	@RequestMapping(method = RequestMethod.GET, value = "/getorderforms/{formid}")
	public OrderFormDetailDto formdetail(@PathVariable(value="formid") int formid, HttpServletResponse response, HttpSession session) throws IOException {
		String email = session.getAttribute("email").toString();
		OrderForm orderform = userservice.getOrderForm(formid);
		logger.info("User: " + session.getAttribute("email") + " get OrderForm: " + formid);
		if (orderform == null || !orderform.getUser().getEmailaddress().equals(email)) {
			response.setStatus(404);
			logger.info("User: " + email + " fail to get OrderForm: " + formid);
			return null;
		}
		OrderFormDetailDto formdetail = new OrderFormDetailDto(orderform);
		logger.info("User: " + email + " get OrderForm: " + formid);
		return formdetail;
	}
	
	@ApiOperation(value = "下订单", notes = "用于将订单录入到系统")
	@RequestMapping(method = RequestMethod.POST, value = "/addorderform")
	public void addOrderForm(int playlistid, int[] seats, HttpSession session, HttpServletResponse response) {
		String email = session.getAttribute("email").toString();
		if (userservice.getUser(email) == null) {
			response.setStatus(401);
			logger.info("User: " + email + " fail to Add OrderForm, User doesn't Exist");
			return;
		}
		PlayList playlist = movieservice.getPlaylistById(playlistid);
		if (playlist == null) {
			response.setStatus(404);
			logger.info("User: " + email + " fail to Add OrderForm, Playlist doesn't Exist");
			return;
		}
		userservice.addOrderForm(playlistid, email, seats);
	}
	
	@ApiOperation(value = "删除订单", notes = "用于删除或取消特定订单")
	@RequestMapping(method = RequestMethod.POST, value = "/deleteorderform")
	public void deleteOrderForm(int oid, HttpSession session) {
		logger.info("User: " + session.getAttribute("email") + " delete OrderForm: " + oid);
		userservice.deleteOrderForm(oid);
	}
}
