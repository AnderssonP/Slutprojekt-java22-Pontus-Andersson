package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GetTheWeather;
import model.weatherBean;

@WebServlet("/OWservlet")
public class OWservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cityStr = request.getParameter("city");
		String countryStr = request.getParameter("country");
		Cookie cookie = null;

		weatherBean wBean = new weatherBean(cityStr, countryStr);
		GetTheWeather.getWeather(wBean);
		request.getSession().setAttribute("wBean", wBean);
		
		Cookie[] allCookies = request.getCookies();
			for(Cookie cookieTwo : allCookies) {
				if(cookieTwo.getName().equals("allow")) {
					boolean cookieExists = false;
					 for(Cookie ck : request.getCookies()) {
					    	if(ck.getName().equals("city")) {
					    		cookieExists = true;
					    		cookie = ck;
					    		break;
					    	}
						}	
					    if (cookieExists) {
					    	cookie.setValue(cookie.getValue() + "/" + cityStr + countryStr);
					    	String cookieKiller = cookie.getValue();
					    	String[] cookieK = cookieKiller.split("/");
					    	wBean.setCookieK(cookieK);
					    	response.addCookie(cookie);
					    	
					    }
					    else {
					    	cookie = new Cookie("city", cityStr + countryStr);
					    	response.addCookie(cookie);
					    }
					    
						RequestDispatcher rd = request.getRequestDispatcher("views/showWeather.jsp");
						rd.forward(request, response);
					}
				}
			
			RequestDispatcher rd = request.getRequestDispatcher("views/showWeather.jsp");
			rd.forward(request, response);
		}
  }
 


