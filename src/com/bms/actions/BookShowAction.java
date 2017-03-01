/**
 * 
 */
package com.bms.actions;

import com.bms.beans.ShowBean;
import com.bms.beans.UserBean;
import com.bms.service.BmsService;
import com.bms.service.BmsServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Sneha
 *
 */
public class BookShowAction extends ActionSupport{

	String showid;
	BmsService service = new BmsServiceImpl();

	public String getShowid() {
		return showid;
	}
	public void setShowid(String showid) {
		this.showid = showid;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		String result="input";
		
		Object user = ActionContext.getContext().getSession().get("user");
		
		if(user==null)
			result="invalidlogin";
		else
		{
			result=service.showDeatils(showid);
		}
		return result;
	}
	
	public String noOfTickets(int ntickets)
	{
		String result= "input";
		
		return result;
	}
	
}
