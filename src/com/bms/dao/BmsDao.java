/**
 * 
 */
package com.bms.dao;

import java.util.ArrayList;

import com.bms.beans.*;

/**
 * @author Sneha
 *
 */
public interface BmsDao {

	public String loginUser(UserBean user);
	
	public String retrieveData(ShowBean show);
	
	public String searchShows(ShowBean show);
	
	public String showDeatils(String showid);
	
	public String payAndBook(BillingBean billing);
	
	public String registerUser(UserBean user);
	
	public boolean checkUser(UserBean user);
	
}
