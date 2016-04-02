package com.bfsi.mfi.validation;

import java.math.BigDecimal;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("numberValidator")
public class NumberValidation implements Validator 
{
	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

	    try {
	        
	        if (new BigDecimal(value.toString()).signum() == 0) 
	        {
	        	/*FacesMessage msg = new FacesMessage("Number should be greater than Zero");
	            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
	            throw new ValidatorException(msg);*/
	        	String validMsg = context.getApplication().evaluateExpressionGet(context, "#{msg['cashMgmt.message.numberzero']}", String.class);
	            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, validMsg, null));
	        }
	        
	    } catch (NumberFormatException ex) {
	        FacesMessage msg = new FacesMessage("Not a number");
	        msg.setSeverity(FacesMessage.SEVERITY_ERROR);
	        throw new ValidatorException(msg); 
	    }
	}
}
