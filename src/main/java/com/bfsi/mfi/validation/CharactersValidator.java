package com.bfsi.mfi.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
@FacesValidator("charactersValidator")
public class CharactersValidator implements Validator
{
	/*SOP are Commented ==> Changes for Asomi Nirmal kanna S*/
	
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException 
	{
		String validCharacter = (String) value;
		
		Pattern pattern = Pattern.compile("^\\p{Alpha}+$");
		Matcher matcher;
		matcher = pattern.matcher(validCharacter);
		if(validCharacter.isEmpty())
		{
			//System.out.println('1');
			String validMsg = context.getApplication().evaluateExpressionGet(context, "#{msg['agentMgmt.validate.empty']}", String.class);
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, validMsg, null));
		}
		else if (validCharacter.length()<=2)
		{
			//System.out.println('2');
			String validMsg = context.getApplication().evaluateExpressionGet(context, "#{msg['agentMgmt.validate.lessthantwo']}", String.class);
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, validMsg, null));
		}
		else if(!(matcher.matches()))
		{
			//System.out.println('3');
			String validMsg = context.getApplication().evaluateExpressionGet(context, "#{msg['agentMgmt.validate.characters']}", String.class);
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, validMsg, null));
		}
	}
}