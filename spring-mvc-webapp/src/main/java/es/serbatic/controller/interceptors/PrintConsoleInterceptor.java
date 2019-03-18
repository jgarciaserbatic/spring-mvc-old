package es.serbatic.controller.interceptors;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class PrintConsoleInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("************************PRE-HANDLE**********************************");
		Enumeration<String> headers = request.getHeaderNames();
		System.out.println("*********************** CABECERAS *********************");
		while(headers.hasMoreElements()) {
			String header = headers.nextElement();
			System.out.println(header.concat(" = ").concat(request.getHeader(header)));
		}
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("************************POST-HANDLE**********************************");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("************************AFTER COMPLETION**********************************");

	}

}
