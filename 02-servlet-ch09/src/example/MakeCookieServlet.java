package example;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MakeCookieServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html; charset=utf-8 ");
		resp.setCharacterEncoding("utf-8");
		
		String encodeName = URLEncoder.encode("ÃÖ¾¾","utf-8");
		Cookie cookie = new Cookie("name", encodeName);
		cookie.setMaxAge(60*60);
		resp.addCookie(cookie);
		
		PrintWriter out = resp.getWriter();
		out.println(cookie.getName());
		out.println(cookie.getValue());
		
		out.flush();
		out.close();
		
	}
}
