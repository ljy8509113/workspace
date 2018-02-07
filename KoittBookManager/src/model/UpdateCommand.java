package model;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao;
import vo.Book;

public class UpdateCommand implements Command{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws ClassNotFoundException, SQLException, IllegalArgumentException, NullPointerException, NumberFormatException {
		String page = "./jsp/update-ok.jsp";
		
		String title = req.getParameter("title");
		String publicsher = req.getParameter("publicsher");
		int price = Integer.parseInt(req.getParameter("price"));
		String description = req.getParameter("description");
		Integer isbn = Integer.parseInt(req.getParameter("isbn"));
		
		if(isbn == null || isbn == 0)
			throw new IllegalArgumentException("도서 번호 누락");
		
		BookDao dao = new BookDao();
		Book b = dao.select(isbn);
		
		if(b == null)
			throw new NullPointerException("없거나 삭제된 도서 입니다.");
		
		
		b.setDescription(description);
		b.setPrice(price);
		b.setPublicsher(publicsher);
		b.setTitle(title);
		
		dao.update(b);
		
		return page;
	}
	
}
