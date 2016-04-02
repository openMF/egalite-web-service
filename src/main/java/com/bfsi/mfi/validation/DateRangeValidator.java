package com.bfsi.mfi.validation;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("dateRangeValidator")
public class DateRangeValidator implements Validator 
{
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

        if (startDate == null) {
            return; 
        }

        Date endDate = (Date) value;
        // bug EGALITE-204 fixes
       // if (startDate.after(endDate))        
        if (endDate.compareTo(startDate) <= 0)
        {
        	startDateComponent.setValid(false);
            String validMsg = context.getApplication().evaluateExpressionGet(context, "#{msg['agentMgmt.validate.startEndDate']}", String.class);
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, validMsg, null));
        }
        
        /*if (curr_date.after(endDate))
        {
        	startDateComponent.setValid(false);
            String validMsg = context.getApplication().evaluateExpressionGet(context, "#{msg['agentMgmt.validate.startEndDate']}", String.class);
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, validMsg, null));
        }*/
    }

}