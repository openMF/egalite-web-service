package com.bfsi.mfi.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("emailValidator")
public class EmailValidator implements Validator
{	
	private static final String EMAIL_PATTERN = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private Pattern pattern;
	private Matcher matcher;
	private boolean isValidEmail = false;
		
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException 
	{	
		// Bug EGALITE-200  **vishal
		pattern = Pattern.compile(EMAIL_PATTERN);
		String email = (String) value;
		matcher = pattern.matcher(email);
		isValidEmail = matcher.matches();		
	//	if((!email.contains("@")) & (!email.contains(".")) ) 
		if(!isValidEmail)
		{
			String validMsg = context.getApplication().evaluateExpressionGet(context, "#{msg['agentMgmt.validate.emailAddress']}", String.class);
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, validMsg, null));
    	}
	}
}