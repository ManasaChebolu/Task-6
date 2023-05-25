package Controller;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;



//@WebListener
public class GuestListener implements ServletContextListener {
	static Connection conn;

	public void contextInitialized(ServletContextEvent event) {  
		 
		try {
			ServletContext ctx=event.getServletContext();
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/employees","root","Chebolu@03"); 		  
			ctx.setAttribute("myconn", conn);  
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}            
	}
		  
		public void contextDestroyed(ServletContextEvent event) {  
		System.out.println("project undeployed");  	          
		}  
}
