package it.unisalento.SWEng_project.validators;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.opensymphony.xwork2.validator.ValidationException;
import com.opensymphony.xwork2.validator.validators.FieldValidatorSupport;

public class BigDecimalValidator extends FieldValidatorSupport{
	
	private String pattern = "(?:\\b[0-9]+(?:\\.[0-9]*)?|\\.[0-9]+\\b)(?:[eE][-+]?[0-9]+\\b)?";

    // Create a Pattern object
    Pattern r = Pattern.compile(pattern);

	@Override
	public void validate(Object object) throws ValidationException {
		// RECUPERARE IL NOME DEL CAMPO
		String fieldname = getFieldName();
		// RECUPERARE IL VALORE DEL CAMPO
		System.out.println(fieldname);
		String value = (String) getFieldValue(fieldname, object);
		System.out.println(value);
		// creaimo il match object
		Matcher m = r.matcher(value);
		
	    if (!m.matches()) {
	    	//Richiamare addfielderror: il msg verrà sovrascritto nel file xml
			addFieldError(fieldname, "Il numero passato deve essere un numero decimale");
		
			
	    }
		
			
	}

	

}
