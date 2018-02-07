package model;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao;
import vo.Book;

public class UpdateFormCommand implements Command{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws ClassNotFoundException, SQLException, IllegalArgumentException, NullPointerException {
		String page = "./jsp/update-form.jsp";
		
		String isbn = req.getParameter("isbn");
		BookDao dao = new BookDao();
		
		if(isbn == null || isbn.trim().length() == 0)
			throw new IllegalArgumentException("���� ��ȣ ����");
		
		Book b = dao.select(Integer.parseInt(isbn));
		if(b == null)
			throw new NullPointerException("���ų� ������ ���� �Դϴ�.");
		
		req.setAttribute("detail", b);
		
		return page;
	}
	
}
