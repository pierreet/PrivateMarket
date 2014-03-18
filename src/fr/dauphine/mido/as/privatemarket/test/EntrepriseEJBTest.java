package fr.dauphine.mido.as.privatemarket.test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import junit.framework.TestCase;

import org.junit.Test;

import fr.dauphine.mido.as.privatemarket.contrats.objet.Connection_DB;
import fr.dauphine.mido.as.privatemarket.contrats.objet.Entreprise;
import fr.dauphine.mido.as.privatemarket.ejb.EntrepriseEJB;

public class EntrepriseEJBTest extends TestCase {

	private EntrepriseEJB eejb;
	
	protected void setUp() throws Exception {
		super.setUp();
		eejb = new EntrepriseEJB();
	}
	
	@Test
	public void testAjouter() {

		fr.dauphine.mido.as.privatemarket.entities.Entreprise r = new fr.dauphine.mido.as.privatemarket.entities.Entreprise();
		r.setCode("4664");
		r.setAnnee("2002");
		r.setNom("Ma petite entreprise");
		eejb.ajouter(r);
		assertTrue("Entreprise ajoutee", r.equals(eejb.rechercher("Ma petite entreprise")));
	}

	@Test
	public void testRechercher() throws Exception {
	
		fr.dauphine.mido.as.privatemarket.entities.Entreprise r = eejb.rechercher("Kit Gaming");
		assertTrue("Entreprise trouvee ", Connection_DB.getNomEntreprise(r.getIdEntreprise()) == "Kit Gaming");

	}

}
