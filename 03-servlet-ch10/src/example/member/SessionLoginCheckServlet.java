package example.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionLoginCheckServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		
		HttpSession session = req.getSession();
		String memberId = (String)session.getAttribute("MEMBERID");
		
		boolean isLogin = memberId == null ? false:true;
		
		if(isLogin) {
			out.println("���̵� : " + memberId + "�� �α����� ����<br/>");
			out.println("<a href='session-logout.do'>�α׾ƿ�</a>");
		}else {
			out.println("�α��� ���� ����.");
		}
		
		out.flush();
		out.close();
	}
}
