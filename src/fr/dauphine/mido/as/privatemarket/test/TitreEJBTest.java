package fr.dauphine.mido.as.privatemarket.test;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import fr.dauphine.mido.as.privatemarket.contrats.objet.Connection_DB;
import fr.dauphine.mido.as.privatemarket.ejb.TitreEJB;
import fr.dauphine.mido.as.privatemarket.entities.Titre;

public class TitreEJBTest  extends TestCase {

	TitreEJB tejb;
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		tejb = new TitreEJB();
	}

	@Test
	public void testAjouter() {
		Titre t = new Titre();
		t.setIdEntreprise(1);
		t.setIdVendeur(2);
		t.setStatut(0);
		t.setPrixInitial(10.00);
		tejb.ajouter(t);
		ArrayList<fr.dauphine.mido.as.privatemarket.contrats.objet.Titre> alT =  Connection_DB.ListeTitre("SELECT * FROM titre");
		boolean find = false;
		for (fr.dauphine.mido.as.privatemarket.contrats.objet.Titre titre : alT) {
			if(titre.equals(t)){
				find = true;
				break;
			}
		}
		assertTrue("Titre ajoute", find);
	}

}
