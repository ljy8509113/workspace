package model;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertFormCommand implements Command{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws ClassNotFoundException, SQLException {
		String page = "./jsp/insert-form.jsp";
		
		return page;
	}
	
}
