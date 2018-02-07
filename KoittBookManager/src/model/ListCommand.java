package model;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao;
import vo.Book;

public class ListCommand implements Command{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws ClassNotFoundException, SQLException {
		String page = "./jsp/list.jsp";
		
		List<Book> list = null;
		BookDao dao = new BookDao();
		
		list = dao.selectAll();
		
		req.setAttribute("list", list);
		
		return page;
	}
	
}
