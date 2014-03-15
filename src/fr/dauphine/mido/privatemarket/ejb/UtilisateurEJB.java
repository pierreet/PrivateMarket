package fr.dauphine.mido.privatemarket.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import fr.dauphine.mido.privatemarket.entities.Utilisateur;


@Stateless
public class UtilisateurEJB {
	private static final String JPQL_SELECT_PAR_EMAIL = "SELECT u FROM Utilisateur u WHERE u.email=:email";
	private static final String JPQL_SELECT_ALL = "SELECT u FROM Utilisateur u";
	
	@PersistenceUnit(unitName="basePM")
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
	
	public void modifier(Utilisateur utilisateur){
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		Utilisateur tmp = rechercher(utilisateur.getEmail());

		if(tmp != null){
			if(utilisateur.getNom() != null)
				tmp.setNom(utilisateur.getNom());
				
			if(utilisateur.getPrenom() != null)
				tmp.setPrenom(utilisateur.getPrenom());
			
			em.merge(tmp);
		}
		
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
	
	public List<Utilisateur> alltable(){
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		List<Utilisateur> lutilisateur=null;
		Query requete = em.createQuery(JPQL_SELECT_ALL);
		try{
			lutilisateur = (List<Utilisateur>) requete.getResultList();
		}catch(NoResultException e){}
		
		et.commit();
		return lutilisateur;
	}

}
