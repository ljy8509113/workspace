package example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.CookieHelper;

public class LoginCheckServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		CookieHelper cookies = new CookieHelper(req);
		
		if(cookies.exists("AUTH")) {
			String id = cookies.getValue("AUTH");
			out.println("아이디 : '"+id +"'로 로그인 한 상태<br>");
			out.println("<a href='logout.do'>로그아웃</a>");
		}else {
			out.println("로그인하지 않음.");
		}
		
		out.flush();
		out.close();
	}
}
