package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Controller.DatabaseConnection;
import entity.employee;
public class Servlet extends HttpServlet {	 	
	private static final long serialVersionUID = 1L;
       
	DatabaseConnection db= new DatabaseConnection();
	Gson gson= new Gson();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ServletContext ctx=request.getServletContext();  
			Connection conn=(Connection) ctx.getAttribute("myconn"); 
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			String p=db.permanentList(conn);
			String pa=db.parttimeList(conn);
			String c=db.contractList(conn);
			out.println(p);
			out.println(pa);
			out.println(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		employee jsobj = gson.fromJson(request.getReader(), employee.class);	
		try {	
			ServletContext ctx=request.getServletContext();  
			Connection conn=(Connection) ctx.getAttribute("myconn"); 
			String s = db.create(jsobj,conn);	
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			out.print(s);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		employee jsobj = gson.fromJson(request.getReader(), employee.class);	
		try {	
			ServletContext ctx=request.getServletContext();  
			Connection conn=(Connection) ctx.getAttribute("myconn"); 
			String s = db.delete(jsobj,conn);	
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			out.print(s);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}
