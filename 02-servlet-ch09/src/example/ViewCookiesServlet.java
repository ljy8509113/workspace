package example;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewCookiesServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html; charset=utf-8 ");
		resp.setCharacterEncoding("utf-8");
		
		PrintWriter out = resp.getWriter();
		out.println("<h1>Cookie List</h1>");
		
		Cookie[] cookies = req.getCookies();
		if(cookies != null && cookies.length > 0) {
			for(int i=0; i<cookies.length; i++) {
				out.print(cookies[i].getName());
				out.print(" = ");
				out.print(URLDecoder.decode(cookies[i].getValue(), "utf-8")+"<br>");
			}
		}else {
			out.println("Cookie Not Found");
		}
		
		out.flush();
		out.close();
	}
}
