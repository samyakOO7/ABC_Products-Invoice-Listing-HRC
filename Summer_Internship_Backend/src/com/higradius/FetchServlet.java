package com.higradius;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class dummyServlet
 */
@WebServlet("/FetchServlet")
public class FetchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //JDBC driver name and database URL
	static final String dbDriver="com.mysql.jdbc.Driver";
	static final String dbURL="jdbc:mysql://localhost:3306/";
	static final String dbname="data";
	static final String username="root";
	static final String password="Samyak123";
    public FetchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection con=null;
		Statement st=null;
		Statement st1=null;
		List<Response> l=new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con=DriverManager.getConnection(dbURL+dbname,username,password);
			 st=con.createStatement();
			 st1=con.createStatement();
			 String page=request.getParameter("page") != null?request.getParameter("page") :  "1" ;
			 
			int OFFSET=(Integer.parseInt(page)-1)*10;
			String offset=Integer.toString(OFFSET);
			 String query="SELECT name_customer,cust_number, invoice_id,total_open_amount,due_in_date,clear_date,Notes FROM mytable ORDER BY FIELD1 LIMIT 10 OFFSET ";
			String query1="SELECT COUNT(*) FROM mytable;";
			 query=query.concat(offset);
		
			 ResultSet rs=st.executeQuery(query);
			ResultSet rs2=st1.executeQuery(query1);
			rs2.next();
			int totalrecords=rs2.getInt(1);
			
			
			 while(rs.next())
			 {
				Response r=new Response();
				 r.setcust_name(rs.getString("name_customer"));
				 r.setcust_number(rs.getString("cust_number"));
				 r.setinvoice_id(rs.getString("invoice_id"));
				 r.setAmount(rs.getString("total_open_amount"));
				 r.setdue_date(rs.getString("due_in_date"));
				 r.setclear_date(rs.getString("clear_date"));
				 r.set_notes(rs.getString("Notes"));
				 l.add(r);
			 }
			 PrintWriter print=response.getWriter();
			Gson gson=new Gson();
			String jsonString=gson.toJson(l);
			 response.setContentType("application/json");
			 response.setCharacterEncoding("UTF-8");
			
				print.write(jsonString);
			 
			
			rs.close();
			rs2.close();
			st1.close();
			st.close();
			con.close();
			
		}catch(SQLException se)
		{
			se.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				if(st!=null)
				{
					st.close();
				}
			}catch(SQLException se2)
			{
				se2.printStackTrace();
			}
			try {
				if(con!=null)
				{
					con.close();
				}
			}catch(SQLException se3)
			{
				se3.printStackTrace();
			}
			
		}
		
		
	}

	

}
