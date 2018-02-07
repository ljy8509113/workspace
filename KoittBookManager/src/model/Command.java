package model;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
	String execute(HttpServletRequest req, HttpServletResponse res) throws ClassNotFoundException, SQLException;
}
