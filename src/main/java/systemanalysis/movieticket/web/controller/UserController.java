package systemanalysis.movieticket.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import systemanalysis.movieticket.persistence.entity.Preference;
import systemanalysis.movieticket.persistence.entity.User;
import systemanalysis.movieticket.persistence.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	@RequestMapping(method = RequestMethod.GET, value = "/getnickname")
	public void getnickname(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException {
		String email = session.getAttribute("email").toString();
		User user = userservice.getUser(email);
		response.getWriter().write(user.getNickname());
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getinfo")
	@ResponseBody
	public void userinfo(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException {
		//System.out.println(session.getId() + "........");
		String email = session.getAttribute("email").toString();
		User user = userservice.getUser(email);
		//System.out.println(user.getNickname() + "........2");
		JSONObject j = new JSONObject();
		j.put("email", email);
		j.put("nickname", user.getNickname());
		j.put("phone", user.getPhone());
		response.getWriter().write(j.toString());
	}
	
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
		response.getWriter().write(j.toString());
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/modifyuser")
	public void modifyuser(String phone, String nickname, @RequestParam(value="preference[]") String[] preference, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		String email = session.getAttribute("email").toString();
		//check format
		if (phone != null) userservice.modifyPhone(email, phone);
		if (nickname != null) userservice.modifyNickname(email, nickname);
		if (preference != null) userservice.modifyPreference(email, preference);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/modifypassword")
	public void modifypassword(String password, HttpSession session) {
		String email = session.getAttribute("email").toString();
		//check password format
		userservice.modifyPassword(email, password);
	}
}
