package systemanalysis.movieticket.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (request.getSession().getAttribute("email") != null && request.getSession().getAttribute("email") != "") {
			System.out.println(request.getSession().getAttribute("email") + "................................666");
			return true;
		}
		response.setStatus(401);
		return false;
	}
}
