package example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.CookieHelper;

public class LoginOutServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		resp.addCookie(CookieHelper.createCookie("AUTH", "","/",0));
		
		PrintWriter out = resp.getWriter();
		out.println("·Î±×¾Æ¿ô ¤³¤³2.");
		
		out.flush();
		out.close();
	}
}
