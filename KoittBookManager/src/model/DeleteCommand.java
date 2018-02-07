package model;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao;

public class DeleteCommand implements Command{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws ClassNotFoundException, SQLException {
		String page = "./jsp/delete.jsp";
		
		String isbn = req.getParameter("isbn");
		
		if(isbn == null || isbn.trim().length() == 0)
			throw new IllegalArgumentException("도서 번호 누락");
		
		BookDao dao = new BookDao();
		dao.delete(Integer.parseInt(isbn));
		
		return page;
	}
	
}
