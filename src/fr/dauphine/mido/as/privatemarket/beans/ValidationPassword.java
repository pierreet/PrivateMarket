package fr.dauphine.mido.as.privatemarket.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.EditableValueHolder;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

@ManagedBean
public class ValidationPassword {
	private String input1;
	  private String input2;
	  private boolean input1Set;

	  public void validateField(FacesContext context, UIComponent component, Object value) {
	    if (input1Set) {
	      input2 = (String) value;
	      if (input1 == null || input1.length() < 6 || (!input1.equals(input2))) {
	    	  ((EditableValueHolder)component).setValid(false);
	        context.addMessage(component.getClientId(context), new FacesMessage("Password must be 6 chars+ & both fields identical"));
	      }
	    } else {
	      input1Set = true;
	      input1 = (String) value;
	    }
	  }
}
