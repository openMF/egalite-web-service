package com.bfsi.mfi.validation;
import java.util.Comparator;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * @className : UserDateRangeValidator.java
 * @description : Validator class for date validation
 * @author : Vishal
 */
@FacesValidator("userDateRangeValidator")
public class UserDateRangeValidator implements Validator{
	 public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException 
	    {
	        if (value == null) {
	            return; 
	        }

	        UIInput startDateComponent = (UIInput) component.getAttributes().get("startDateComponent");
	        //Date curr_date = new Date();
			
			
	        if (!startDateComponent.isValid()) {
	            return; 
	        }

	        Date startDate = (Date) startDateComponent.getValue();	        
	        // current date
	        Date date = new Date();	        

	        if (startDate == null) {
	            return; 
	        }
	        TimeIgnoringComparator startDateComparator = new TimeIgnoringComparator();
	        int comparatorValue = startDateComparator.compare(startDate, date);
	        
	        if(comparatorValue < 0){
	        	startDateComponent.setValid(false);
	            String validMsg = context.getApplication().evaluateExpressionGet(context, "#{msg['agentMgmt.validate.currentStartDate']}", String.class);
	            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, validMsg, null));
	        }
	        Date endDate = (Date) value;
	              
	        if (endDate.compareTo(startDate) <= 0)
	        {
	        	startDateComponent.setValid(false);
	            String validMsg = context.getApplication().evaluateExpressionGet(context, "#{msg['agentMgmt.validate.startEndDate']}", String.class);
	            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, validMsg, null));
	        }
	    }
	    
    private class TimeIgnoringComparator implements Comparator<Date> {
  	  public int compare(Date d1, Date d2) {
  	    if (d1.getYear() != d2.getYear()) 
  	        return d1.getYear() - d2.getYear();
  	    if (d1.getMonth() != d2.getMonth()) 
  	        return d1.getMonth() - d2.getMonth();
  	    return d1.getDate() - d2.getDate();
  	  }
  	}

}
