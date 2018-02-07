package example;

import java.io.IOException;
import java.io.PrintWriter;import java.net.CookieHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.CookieHelper;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		
		PrintWriter out = resp.getWriter();
		
		if(id.equals(password)) {
			resp.addCookie(CookieHelper.createCookie("AUTH", id, "/", -1));
			out.println("로그인에 성공했습니다.");
		}else {
			out.println("로그인에 실패하였습니다.<br/>");
			out.println("<a href='../login-form.do'>로그인 화면으로 이동</a>");
		}
		
		out.flush();
		out.close();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
	}
}
