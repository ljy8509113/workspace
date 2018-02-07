package model;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao;
import vo.Book;

public class InsertCommand implements Command{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws ClassNotFoundException, SQLException, NumberFormatException {
		String page = "./jsp/insert-ok.jsp";
		
		String title = req.getParameter("title");
		String author = req.getParameter("author");
		String publicsher = req.getParameter("publicsher");
		String price = req.getParameter("price");
		String description = req.getParameter("description");
		
		Book book = new Book(title, author, publicsher, Integer.parseInt(price), description);
		
		BookDao dao = new BookDao();
		dao.insert(book);
		
		return page;
	}
	
}
