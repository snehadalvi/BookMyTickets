/**
 * 
 */
package com.bms.actions;

import java.util.ArrayList;

import com.bms.beans.ShowBean;
import com.bms.service.BmsService;
import com.bms.service.BmsServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author Sneha
 *
 */
public class SearchShowsAction extends ActionSupport implements ModelDriven<ShowBean> {

	ShowBean show = new ShowBean();
	BmsService service = new BmsServiceImpl();
	
	@Override
	public ShowBean getModel() {
		// TODO Auto-generated method stub
		return show;
	}

	@Override
	public String execute() throws Exception {
		
		String result=service.searchShows(show);
		
		return result;
	}
	
	

}
