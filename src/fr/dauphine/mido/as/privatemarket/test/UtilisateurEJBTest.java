package fr.dauphine.mido.as.privatemarket.test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import fr.dauphine.mido.as.privatemarket.contrats.objet.Connection_DB;
import fr.dauphine.mido.as.privatemarket.ejb.UtilisateurEJB;
import fr.dauphine.mido.as.privatemarket.entities.Utilisateur;

public class UtilisateurEJBTest  extends TestCase  {
	
	UtilisateurEJB uejb;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		uejb = new UtilisateurEJB();
	}

	@Test
	public void testAjouter() {
		Utilisateur u = new Utilisateur();
		u.setEmail("test@privatemarket.fr");
		u.setNom("Jean");
		u.setPrenom("Cerien");
		u.setPassword("2014$pm");
		u.setStatut(0);
		uejb.ajouter(u);
		assertTrue("Utilisateur ajoute", u.equals(uejb.rechercher("test@privatemarket.fr")));
	}

	@Test
	public void testSupprimer() {
		Utilisateur u = uejb.rechercher("test@privatemarket.fr");
		uejb.supprimer(u);
		assertFalse("Utilisateur supprime", uejb.rechercher("test@privatemarket.fr") == null);
	}

	@Test
	@Ignore
	public void testModifier() {
		Utilisateur u = uejb.rechercher("test@privatemarket.fr");
		u.setEmail("testModifier@privatemarket.fr");
		uejb.modifier(u);
		assertTrue("Utilisateur modifie", (uejb.rechercher("test@privatemarket.fr") != null && uejb.rechercher("testModifier@privatemarket.fr") == null));
		
	}

	@Test
	public void testRechercher() throws Exception {
		fr.dauphine.mido.as.privatemarket.entities.Utilisateur u = uejb.rechercher("clo@gmail.com");
		assertTrue("Utilisateur trouvee ", Connection_DB.getNomVendeur(u.getIdUtilisateur()) == "Dupont");
	}

	@Test
	public void testRechercherParId() throws Exception {
		
		fr.dauphine.mido.as.privatemarket.entities.Utilisateur u = uejb.rechercherParId(2);
		assertTrue("Utilisateur trouvee ", Connection_DB.getNomVendeur(u.getIdUtilisateur()) == "Dupont");
	}

}
