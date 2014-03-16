package fr.dauphine.mido.as.privatemarket.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import fr.dauphine.mido.as.privatemarket.entities.Utilisateur;



@Stateless
public class UtilisateurEJB {
	private static final String JPQL_SELECT_PAR_EMAIL = "SELECT u FROM Utilisateur u WHERE u.email=:email";
	private static final String JPQL_SELECT_ALL = "SELECT u FROM Utilisateur u";
	private static final String JPQL_SELECT_MEMBRE_SOCIETE_LIBRE = "SELECT u FROM Utilisateur u WHERE u.statut=1 AND u.identreprise=-1";
	
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
		
		/*Utilisateur tmp = rechercher(utilisateur.getEmail());

		if(tmp != null){
			if(utilisateur.getNom() != null)
				tmp.setNom(utilisateur.getNom());
				
			if(utilisateur.getPrenom() != null)
				tmp.setPrenom(utilisateur.getPrenom());
			
			if(utilisateur.getEmail() != null)
				tmp.setEmail(utilisateur.getEmail());
			
			if(utilisateur.getPays() != null)
				tmp.setPays(utilisateur.getPays());
			
			if(utilisateur.getCodePostale() == 0)
				tmp.setCodePostale(utilisateur.getCodePostale());
						
			if((utilisateur.getStatut() == 0) || (utilisateur.getStatut() == 1) || (utilisateur.getStatut() == 2))
				tmp.setStatut(utilisateur.getStatut());
			
			if(utilisateur.getIdEntreprise() == 0)
				tmp.setIdEntreprise(utilisateur.getIdEntreprise());
			
			em.merge(utilisateur);
		}*/
		em.merge(utilisateur);
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
	
	public Utilisateur rechercherParId(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Utilisateur utilisateur=null;
		utilisateur = em.find(Utilisateur.class, id);
		et.commit();	
		return utilisateur;
	}
	
	@SuppressWarnings("unchecked")
	public List<Utilisateur> alltable(){
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		List<Utilisateur> lutilisateur = new ArrayList<Utilisateur>();
		Query requete = em.createQuery(JPQL_SELECT_ALL);
		try{
			lutilisateur = (List<Utilisateur>) requete.getResultList();
		}catch(NoResultException e){}
		
		et.commit();
		return lutilisateur;
	}
	
	@SuppressWarnings("unchecked")
	public List<Utilisateur> listeMembreSociete(){
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		List<Utilisateur> lutilisateur = new ArrayList<Utilisateur>();
		Query requete = em.createQuery(JPQL_SELECT_MEMBRE_SOCIETE_LIBRE);
		try{
			lutilisateur = (List<Utilisateur>) requete.getResultList();
		}catch(NoResultException e){}
		
		et.commit();
		return lutilisateur;
	}

	
	


}
