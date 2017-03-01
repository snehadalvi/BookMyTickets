/**
 * 
 */
package com.bms.actions;

import com.bms.beans.UserBean;
import com.bms.service.BmsService;
import com.bms.service.BmsServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author Sneha
 *
 */
public class LoginAction extends ActionSupport implements ModelDriven<UserBean> {

	UserBean user = new UserBean();
	BmsService service = new BmsServiceImpl();
	
	@Override
	public UserBean getModel() {
		// TODO Auto-generated method stub
		return user;
	}

	public UserBean getUser() {
		return user;
	}

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
				
		String role = service.loginUser(user);
		
		return role;
	}
	
}
