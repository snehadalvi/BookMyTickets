/**
 * 
 */
package com.bms.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Sneha
 *
 */
public class LogoutAction extends ActionSupport{

	@Override
	public String execute() throws Exception {
		
		ActionContext.getContext().getSession().clear();
		
		return SUCCESS;
	}

	
}
