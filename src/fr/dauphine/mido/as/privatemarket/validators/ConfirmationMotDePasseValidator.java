package fr.dauphine.mido.as.privatemarket.validators;

import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.faces.application.FacesMessage;;

@FacesValidator( value = "confirmationMotDePasseValidator" )
public class ConfirmationMotDePasseValidator implements Validator {
	private static final String CHAMP_MOT_DE_PASSE = "DeuxiemeMotDePasse";

	@Override
	public void validate(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {
		UIInput DeuxiemeMotDePasse = (UIInput) component.getAttributes().get( CHAMP_MOT_DE_PASSE );
		String mdp = (String) DeuxiemeMotDePasse.getValue();
		String confirmation = (String) value;
		
		if ( confirmation != null && !confirmation.equals(mdp) ) 
			throw new ValidatorException(new FacesMessage( FacesMessage.SEVERITY_ERROR,"Mots de passe différents", null ));
	}

}
