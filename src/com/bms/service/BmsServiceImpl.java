/**
 * 
 */
package com.bms.service;

import java.util.ArrayList;

import com.bms.beans.BillingBean;
import com.bms.beans.ShowBean;
import com.bms.beans.UserBean;
import com.bms.dao.BmsDao;
import com.bms.dao.BmsDaoImpl;

/**
 * @author Sneha
 *
 */
public class BmsServiceImpl implements BmsService{

	BmsDao dao= new BmsDaoImpl();
	
	@Override
	public String loginUser(UserBean user) {
		return dao.loginUser(user);
	}

	@Override
	public String searchShows(ShowBean show) {
		return dao.searchShows(show);
	}

	@Override
	public String retrieveData(ShowBean show) {
		// TODO Auto-generated method stub
		return dao.retrieveData(show);
	}

	@Override
	public String showDeatils(String showid) {
		// TODO Auto-generated method stub
		return dao.showDeatils(showid);
	}

	@Override
	public String payAndBook(BillingBean billing) {
		// TODO Auto-generated method stub
		return dao.payAndBook(billing);
	}

	@Override
	public String registerUser(UserBean user){
		return dao.registerUser(user);
	}

	@Override
	public boolean checkUser(UserBean user) {
		// TODO Auto-generated method stub
		return dao.checkUser(user);
	}
	

}
