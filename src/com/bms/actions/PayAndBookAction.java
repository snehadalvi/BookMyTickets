/**
 * 
 */
package com.bms.actions;

import com.bms.beans.BillingBean;
import com.bms.beans.ShowBean;
import com.bms.service.BmsService;
import com.bms.service.BmsServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author Sneha
 *
 */
public class PayAndBookAction extends ActionSupport implements ModelDriven<BillingBean>{

	BillingBean billing = new BillingBean();
	BmsService service = new BmsServiceImpl();
	
	@Override
	public BillingBean getModel() {
		// TODO Auto-generated method stub
		return billing;
	}

	@Override
	public String execute() throws Exception {
		
		String result = INPUT;
		
		result = service.payAndBook(billing);
		
		return result;
	}

	@Override
	public void validate() {
		
		int available_tkts=0;
		int ntickets = billing.getNtickets();
		
		ShowBean show = (ShowBean) ActionContext.getContext().getSession().get("bookshow");
		if(show!=null)
		{
			available_tkts = show.getAvailability();
		}
		
		if( ntickets > available_tkts)
		{
			addFieldError("ntickets", "Only "+available_tkts+" ticlets are available");
		}
		
	} // end validate
	

} //end class
