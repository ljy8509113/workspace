package filter;

import java.io.IOException;
import java.io.PrintWriter;import java.net.CookieHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.CookieHelper;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		String id = req.getParameter("id");
		HttpSession session = req.getSession();
		session.setAttribute("MEMBER", id);
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.print("<head><title>로그인</title></head>");
		out.println("<body>로그인~</body></html>");
		
		out.flush();
		out.close();
	}
}
