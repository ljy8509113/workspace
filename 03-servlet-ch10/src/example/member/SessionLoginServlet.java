package example.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionLoginServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		PrintWriter out = resp.getWriter();
		
		if(id.equals(password)) {
			HttpSession s = req.getSession();
			s.setAttribute("MEMBER", id);
			out.println("�α��� s");
		}else {
			out.println("�α��� ����");
			out.println("<a href='../session-login-form.do'>�α��� ȭ������ �̵�</a>");
		}
		
		out.flush();
		out.close();
	}
}
