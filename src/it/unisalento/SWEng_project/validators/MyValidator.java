package it.unisalento.SWEng_project.validators;

import com.opensymphony.xwork2.validator.ValidationException;
import com.opensymphony.xwork2.validator.validators.FieldValidatorSupport;

public class MyValidator extends FieldValidatorSupport{
	
	String nomedaescludere;

	@Override
	public void validate(Object object) throws ValidationException {
		// RECUPERARE IL NOME DEL CAMPO
		String fieldname = getFieldName();
		// RECUPERARE IL VALORE DEL CAMPO
		String value = (String) getFieldValue(fieldname, object);
		if (value.equalsIgnoreCase(nomedaescludere)) {
			//Richiamare addfielderror: il msg verrà sovrascritto nel file xml
			addFieldError(fieldname, "Errore");
		}
	}

	public String getNomedaescludere() {
		return nomedaescludere;
	}

	public void setNomedaescludere(String nomedaescludere) {
		this.nomedaescludere = nomedaescludere;
	}
}
