package fr.dauphine.mido.privatemarket.validatorsEJB;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import fr.dauphine.mido.privatemarket.ejb.UtilisateurEJB;


@ManagedBean(name="verificationEmail")
@RequestScoped
public class VerificationEmailValidator implements Validator {
	private static final String EMAIL_EXISTANT = "Cette adresse email est déjà utilisée";
	
	@EJB
	private UtilisateurEJB utilisateurEJB;

	@Override
	public void validate(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {
		// TODO Auto-generated method stub
		String email = (String) value;
		
		if(utilisateurEJB.rechercher(email) != null)
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, EMAIL_EXISTANT, null));
	}
}
