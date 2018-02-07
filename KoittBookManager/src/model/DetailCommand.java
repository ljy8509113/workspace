package model;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao;
import vo.Book;

public class DetailCommand implements Command{
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws ClassNotFoundException, SQLException, IllegalArgumentException, NullPointerException {
		String page = "./jsp/detail.jsp";
		BookDao dao = new BookDao();
		
		String isbn = req.getParameter("isbn");
		
		if(isbn == null || isbn.trim().length() == 0)
			throw new IllegalArgumentException("isbn 누락");
		
		Book b = dao.select(Integer.parseInt(isbn));
		if(b == null)
			throw new NullPointerException("없거나 삭제된 도서 입니다.");
		
		req.setAttribute("detail", b);
		
		return page;
	}
	
}
