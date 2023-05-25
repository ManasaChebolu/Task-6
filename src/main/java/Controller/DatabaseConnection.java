package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONObject;

import entity.employee;



public class DatabaseConnection {
	String tableName,sql;

	
	public String create(employee jsobj,Connection conn) throws SQLException {
		if(jsobj.getEmpType().equals("permanent") || jsobj.getEmpType().equals("parttime") ||jsobj.getEmpType().equals("contract")) {
	    	tableName = jsobj.getEmpType();
	    	System.out.println(conn);
	    	try {
				sql = String.format("INSERT INTO %s VALUES (?,?,?,?) ", tableName);
		        PreparedStatement insertstmt=conn.prepareStatement(sql);    	     	       	    	  
			           insertstmt.setInt(1, jsobj.getEmpId());
			           insertstmt.setString(2, jsobj.getEmpName());
			           insertstmt.setInt(3, jsobj.getEmpSalary());
			           insertstmt.setString(4, jsobj.getEmpType()); 		          
			           insertstmt.executeUpdate();	
			   
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    	return "Created";
	       }
		else 
			return "No Such Type";	
	}
	
	public String delete(employee jsobj,Connection conn) throws SQLException {
		if(jsobj.getEmpType().equals("permanent") || jsobj.getEmpType().equals("parttime") ||jsobj.getEmpType().equals("contract")) {
	    	tableName = jsobj.getEmpType();
	    	try {
				//Connection();
				sql=String.format("delete from %s where empId=?",tableName);
	               PreparedStatement deletestmt=conn.prepareStatement(sql);
	               deletestmt.setInt(1,jsobj.getEmpId());
	               deletestmt.executeUpdate();
			   
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    	return "Deleted";
	       }
		else 
			return "No employee found";	
	}
	
	public String permanentList(Connection conn) throws SQLException, ClassNotFoundException {
		//Connection();
		String jsonData="Lists";
		PreparedStatement selectpermanentstmt=conn.prepareStatement("select *from permanent");
		   ResultSet rs=selectpermanentstmt.executeQuery();		   
		   JSONArray permanentArray=new JSONArray();
		   while(rs.next()) {
			    JSONObject permanent=new JSONObject(); 
			        permanent.put("empId",rs.getInt("empId"));
			        permanent.put("empName",rs.getString("empName"));
			        permanent.put("empSalary",rs.getInt("empSalary"));
			        permanent.put("empType",rs.getString("empType"));
			        permanentArray.put(permanent);
			        
		   }  	
		   jsonData=permanentArray.toString();
		   return jsonData;
	}
	public String parttimeList(Connection conn) throws SQLException, ClassNotFoundException {	   
		//Connection();
		String jsonData="Lists";
		PreparedStatement selectparttimestmt=conn.prepareStatement("select *from parttime");
		ResultSet rs1=selectparttimestmt.executeQuery();   	
		JSONArray parttimeArray=new JSONArray();
		   while(rs1.next()) {
			   JSONObject parttime=new JSONObject();
			     parttime.put("empId",rs1.getInt("empId"));
			     parttime.put("empName",rs1.getString("empName"));
			     parttime.put("empSalary",rs1.getInt("empSalary"));
			     parttime.put("empType",rs1.getString("empType"));
			     parttimeArray.put(parttime); 
		   }	
		   jsonData=parttimeArray.toString();
		   return jsonData;

	}
	public String contractList(Connection conn) throws SQLException, ClassNotFoundException {
		//Connection();
		String jsonData="Lists";
		PreparedStatement selectcontractstmt=conn.prepareStatement("select *from contract");
		  ResultSet rs2= selectcontractstmt.executeQuery();  
		  JSONArray contractArray=new JSONArray();
		   while(rs2.next()) {
			   JSONObject contract=new JSONObject();
			     contract.put("empId",rs2.getInt("empId"));
			     contract.put("empName",rs2.getString("empName"));
			     contract.put("empSalary",rs2.getInt("empSalary"));
			     contract.put("empType",rs2.getString("empType"));
			     contractArray.put(contract);
		   }
		   jsonData=contractArray.toString();
		   return jsonData;
	}

	
}
