package privatemarket.contrats.objet;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class EssaiJSF {
	final String world = "Un essai de JSF avec un managed bean";

	public String getworld() {
		return world;
	}
}