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
public class RetrieveDataAction extends ActionSupport implements ModelDriven<ShowBean>{

	ShowBean show = new ShowBean();
	BmsService service = new BmsServiceImpl();
	private ArrayList<String> movies_list;
	
	
	public ArrayList<String> getMovies_list() {
		return movies_list;
	}

	public void setMovies_list(ArrayList<String> movies_list) {
		this.movies_list = movies_list;
	}

	@Override
	public ShowBean getModel() {
		// TODO Auto-generated method stub
		return show;
	}

	@Override
	public String execute() throws Exception {
		
		String result="input";
		result = service.retrieveData(show);
		
		return result;
	}
}
