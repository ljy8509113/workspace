package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginCheckFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpServletRequest httpReq = (HttpServletRequest)req;
		HttpSession session = httpReq.getSession();
		
		boolean login = false;
		if(session != null) {
			if(session.getAttribute("MEMBER") != null) {
				login = true;
			}
		}
		
		if(login) {
			chain.doFilter(req, res);
		}else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/login-form.do");
			dispatcher.forward(req,  res);
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
