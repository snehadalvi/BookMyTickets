/**
 * 
 */
package com.bms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.catalina.core.ApplicationContext;

import com.bms.beans.BillingBean;
import com.bms.beans.ShowBean;
import com.bms.beans.UserBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * @author Sneha
 *
 */
public class BmsDaoImpl implements BmsDao{

	Connection conn;
	PreparedStatement stmt;
	ResultSet rs;
	DBConnection dbConnection=new DBConnection();
	String query;
	
	@Override
	public String loginUser(UserBean user) {
		
		String role="";
		try 
		{
			conn = dbConnection.getConnection();
			System.out.println(conn);
			stmt= conn.prepareStatement("select * from users where username=? and password=?");
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			rs=stmt.executeQuery();
			
			if(rs.next())
			{
				role="success";
				user.setUid(rs.getString(1));
				ActionContext.getContext().getSession().put("user",user);
			}
			else
				role="invalid";
			return role;
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		/*if(user.getUsername().equals("tom"))
		{
			if(user.getPassword().equals("test"))
				return "Admin";
		}*/
		
		return role;
	}

	@Override
	public String searchShows(ShowBean show) {
		
		String result = "success";
		ArrayList<ShowBean> shows_list = new ArrayList<ShowBean>();
		ShowBean show1;
		String movie_id="", movie_name, theatre_id="", theatre_name;
		String status = "Available shows are ";
		
		try 
		{
			conn = dbConnection.getConnection();
			System.out.println(conn);
			
			//search id of a movie
			movie_name = show.getMovie();
			System.out.println(movie_name);
			stmt = conn.prepareStatement("select mid from movies where movie_name=?");
			stmt.setString(1, movie_name);
			rs=stmt.executeQuery();
			if(rs.next())
			{
				movie_id = rs.getString(1);
				System.out.println(movie_id);
			}
			
			//search id of a theatre
			theatre_name = show.getTheatre();
			stmt = conn.prepareStatement("select tid from theatres where theatre_name=?");
			stmt.setString(1, theatre_name);
			rs=stmt.executeQuery();
			if(rs.next())
			{
				theatre_id = rs.getString(1);
				System.out.println(theatre_id);
			}
			
			stmt= conn.prepareStatement("select m.movie_name, t.theatre_name, s.date, s.time, s.rate, s.sid "
										+ "from shows s, movies m, theatres t "
										+ "where (s.mid=? or s.tid=?) and s.mid=m.mid and s.tid=t.tid");
			stmt.setString(1, movie_id);
			stmt.setString(2, theatre_id);
			rs=stmt.executeQuery();
			
			while(rs.next())
			{
				show1 = new ShowBean();
				show1.setMovie(rs.getString(1));
				show1.setTheatre(rs.getString(2));
				show1.setDate(rs.getString(3));
				show1.setTime(rs.getString(4));
				show1.setPrice(rs.getDouble(5));
				show1.setShowid(rs.getString(6));
				shows_list.add(show1);
			}
			if(shows_list.isEmpty())
			{
				status = "No shows for the selected search crieteria";
				shows_list = null;
			}
			
			//put the results in context
			ActionContext.getContext().getSession().put("status", status);
			ActionContext.getContext().getSession().put("shows_list", shows_list);
		    
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public String retrieveData(ShowBean show) {
		// TODO Auto-generated method stub

		String result = "success";
		ArrayList<String> movies_list = new ArrayList<String>();
		ArrayList<String> theatres_list = new ArrayList<String>();
		
		try 
		{
			conn = dbConnection.getConnection();
			System.out.println(conn);
			
			//retrieve current movies
			stmt = conn.prepareStatement("select movie_name from movies m");
			rs=stmt.executeQuery();
			while(rs.next())
			{
				movies_list.add(rs.getString(1));
			}
			
		    System.out.println(movies_list.toString());
		    ActionContext.getContext().getSession().put("movies_list", movies_list); 
		    
		    //retrieve theatres
		    stmt = conn.prepareStatement("select theatre_name from theatres");
		    rs=stmt.executeQuery();
		    while(rs.next())
		    {
		    	theatres_list.add(rs.getString(1));
		    }

		    System.out.println(theatres_list.toString());

		    ActionContext.getContext().getSession().put("theatres_list", theatres_list); 
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public String showDeatils(String showid) {
		
		String result="input";
		ShowBean show = new ShowBean();
		try 
		{
			conn = dbConnection.getConnection();
			System.out.println(conn);
			stmt= conn.prepareStatement("select m.movie_name, t.theatre_name, s.date, s.time, s.rate, s.availability "
										+ "from shows s, movies m, theatres t "
										+ "where s.sid=? and s.mid=m.mid and s.tid=t.tid");
			stmt.setString(1, showid);
			rs=stmt.executeQuery();
			
			if(rs.next())
			{
				result="success";
				show.setShowid(showid);
				show.setMovie(rs.getString(1));
				show.setTheatre(rs.getString(2));
				show.setDate(rs.getString(3));
				show.setTime(rs.getString(4));
				show.setPrice(rs.getDouble(5));
				show.setAvailability(rs.getInt(6));
				System.out.println(show.toString());
				ActionContext.getContext().getSession().put("bookshow", show); 
			}
			else
				result="error";
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		return result;
	} // end showDetails

	@Override
	public String payAndBook(BillingBean billing) {
		
		String result = "input";
		String uid="", sid="", cardtype="", status = "C";
		int available_seats = 0, ntickets = 0;
		
		UserBean user = (UserBean) ActionContext.getContext().getSession().get("user");
		ShowBean show = (ShowBean) ActionContext.getContext().getSession().get("bookshow");
		
		if(user!=null)
		{
			uid = user.getUid();
		}
		if(show!=null)
		{
			sid = show.getShowid();
			available_seats = show.getAvailability();
		}
		ntickets = billing.getNtickets();
		System.out.println("total cost= $"+billing.getTcost());
		
		try 
		{
			conn = dbConnection.getConnection();
			System.out.println(conn);
			stmt= conn.prepareStatement("update shows set availability = ? where sid = ?");
			stmt.setInt(1, available_seats - ntickets);
			stmt.setString(2, sid);
			stmt.executeUpdate();
			
			stmt= conn.prepareStatement("insert into billing values (?, ?, ?, ?, ?)");
			stmt.setString(1, uid);
			stmt.setString(2, sid);
			stmt.setInt(3, ntickets);
			stmt.setString(4, cardtype);
			stmt.setString(5, status);
			stmt.executeUpdate();
			result="success";
			
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ActionContext.getContext().getSession().put("billing", billing);
		return result;
	}
	
	
	public boolean checkUser(UserBean user) {
		boolean isNewUser = true;
		try 
		{
			conn = dbConnection.getConnection();
			System.out.println(conn);
			stmt= conn.prepareStatement("select * from users where username=?");
			stmt.setString(1, user.getUsername());
			rs=stmt.executeQuery();
			
			if(rs.next())
			{
				isNewUser = false;
			}
			else
				isNewUser = true;
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Is this new user? "+isNewUser);
		return isNewUser;
	}
	
	public String registerUser(UserBean user){
		String result = "input";
			
		String uid="";
		Random randomGenerator = new Random();
		int randomVal = randomGenerator.nextInt(100);
		uid = "U"+randomVal;
		
		try 
		{
			conn = dbConnection.getConnection();
			System.out.println(conn);			
			stmt= conn.prepareStatement("insert into users values (?, ?, ?, ?, ?, ?, ?, ?)");
			stmt.setString(1, uid);
			stmt.setString(2, user.getFirst());
			stmt.setString(3, user.getLast());
			stmt.setString(4, user.getAddress());
			stmt.setString(5, user.getUsername());
			stmt.setString(6, user.getPassword());
			stmt.setString(7, user.getPhone());
			stmt.setString(8, user.getEmail());
			stmt.executeUpdate();
			result="success";
			
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("reguser:"+result);
		return result;
	}
	

} //end class
