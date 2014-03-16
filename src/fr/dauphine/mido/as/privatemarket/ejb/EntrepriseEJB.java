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

import fr.dauphine.mido.as.privatemarket.entities.Entreprise;



@Stateless
public class EntrepriseEJB {
	private static final String JPQL_SELECT_ALL = "SELECT e FROM Entreprise e";
	private static final String JPQL_SELECT_ENTR_NOM = "SELECT e FROM Entreprise e WHERE e.nom=:nom";
	
	@PersistenceUnit(unitName="basePM")
	private EntityManagerFactory emf;
	
	public void ajouter(Entreprise entreprise){
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(entreprise);
		et.commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<Entreprise> alltable(){
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		List<Entreprise> lEntreprise= new ArrayList<Entreprise>();
		Query requete = em.createQuery(JPQL_SELECT_ALL);
		try{
			lEntreprise = (List<Entreprise>) requete.getResultList();
		}catch(NoResultException e){}
		
		et.commit();
		return lEntreprise;
	}
	
	public Entreprise rechercher(String nom){
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Entreprise tmp = null;
		Query requete = em.createQuery(JPQL_SELECT_ENTR_NOM);
		requete.setParameter("nom", nom);
		try{
			tmp = (Entreprise) requete.getSingleResult();
		} catch(NoResultException e){
		}
		et.commit();	
		return tmp;
	}
	
}
