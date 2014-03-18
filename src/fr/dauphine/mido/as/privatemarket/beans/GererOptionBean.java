package fr.dauphine.mido.as.privatemarket.beans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


import fr.dauphine.mido.as.privatemarket.ejb.OptionEJB;
import fr.dauphine.mido.as.privatemarket.entities.Stockoption;


@ManagedBean(name="gererOptionBean")
@RequestScoped
public class GererOptionBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private Stockoption stockoption;
	
	@EJB
	private OptionEJB optionEJB;
	
	public GererOptionBean(){
		stockoption = new Stockoption();
	}
	
	public String inscrire(){
		optionEJB.ajouter(stockoption);
		return "L'option à bien été ajouté sur le marché";
	}

	public Stockoption getStockoption(){
		return stockoption;
	}
}
