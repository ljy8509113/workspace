package example.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionInfoServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		Date time = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		HttpSession session = req.getSession();
		
		PrintWriter out = resp.getWriter();
		String sessionId = session.getId();
		out.println("技记ID : "+sessionId);
		
		time.setTime(session.getCreationTime());
		out.println("技记 积己 矫埃 : " + format.format(time));
		
		out.flush();
		out.close();
	}
}
