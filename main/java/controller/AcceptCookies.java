package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.weatherBean;

@WebServlet("/AcceptCookies")
public class AcceptCookies extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AcceptCookies() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String allowStr = request.getParameter("allow");
		String denieStr = request.getParameter("denied");
		
		weatherBean wBean = new weatherBean(allowStr, denieStr);
		request.getSession().setAttribute("wBeanTwo", wBean);
		
		if(allowStr != null) {
			Cookie allowCookie = new Cookie("allow", allowStr);
			response.addCookie(allowCookie);
		}else if(denieStr != null) {
			Cookie denieCookie = new Cookie("denied", allowStr);
			response.addCookie(denieCookie);
		}
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
		
		
	}

}
