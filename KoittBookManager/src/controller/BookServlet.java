package controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Command;
import model.DeleteCommand;
import model.DetailCommand;
import model.InsertCommand;
import model.InsertFormCommand;
import model.ListCommand;
import model.UpdateCommand;
import model.UpdateFormCommand;

public class BookServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	void doProcess(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.setCharacterEncoding("UTF-8");
			
			String cmd = req.getParameter("cmd");
			Command command = null;
			
			if(cmd == null || cmd.trim().length() == 0) {
				cmd = "CMD_LIST";
			}
			
			switch(cmd) {
			case "CMD_LIST":
				command = new ListCommand();
				break;
				
			case "CMD_INSERT":
				command = new InsertCommand();
				break;
			case "CMD_INSERT_FORM" :
				command = new InsertFormCommand();
				break;
			case "CMD_DETAIL":
				command = new DetailCommand();
				break;
				
			case "CMD_REMOVE":
				command = new DeleteCommand();
				break;
				
			case "CMD_UPDATE_FORM":
				command = new UpdateFormCommand();
				break;
				
			case "CMD_UPDATE":
				command = new UpdateCommand();
				break;
			}
			
			String page = command.execute(req, resp);
				
			RequestDispatcher rd = req.getRequestDispatcher(page);
			rd.forward(req, resp);
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(NumberFormatException e) {
			e.printStackTrace();
		}
		
		
	}

}
