package hu.ordersystem.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AdminLoginInterceptors implements HandlerInterceptor {
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String uri=request.getRequestURI();
	
		System.out.println(uri);
		if(uri.equals("/ordersystem/login")) {
			return true;
		}
		
		if(uri.equals("/ordersystem/checkAdmin")) {
			return true;
		}else {
			Object admin = request.getSession().getAttribute("admin");
			if(admin!=null) {
				return true;
			}else {
				response.sendRedirect("/ordersystem/index.jsp");
				return false;
			}
		}
		
		
		
	}
	
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {
	}
	
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable Exception ex) throws Exception {
	}
}
