package fr.dauphine.mido.as.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import fr.dauphine.mido.as.entities.Utilisateur;

@Stateless
public class UtilisateurEJB {
	private static final String JPQL_SELECT_PAR_EMAIL = "SELECT u FROM Utilisateur u WHERE u.email=:email";
	
	@PersistenceUnit(unitName="test")
	private EntityManagerFactory emf;
	
	
	public void ajouter(Utilisateur utilisateur){
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(utilisateur);
		et.commit();
	}
	
	public void supprimer(Utilisateur utilisateur){
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(utilisateur);
		et.commit();
	}
	
	public Utilisateur rechercher(String email){
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Utilisateur utilisateur=null;
		Query requete = em.createQuery(JPQL_SELECT_PAR_EMAIL);
		requete.setParameter("email", email);
		try{
			utilisateur = (Utilisateur) requete.getSingleResult();
		} catch(NoResultException e){
		}
		et.commit();	
		return utilisateur;
	}

}
