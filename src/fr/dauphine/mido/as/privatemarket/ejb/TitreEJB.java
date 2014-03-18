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


import fr.dauphine.mido.as.privatemarket.entities.Titre;

@Stateless
public class TitreEJB {
	private static final String JPQL_SELECT_ALL = "SELECT t FROM Titre t";
	
	@PersistenceUnit(unitName="basePM")
	private EntityManagerFactory emf;
	
	
	
	public void ajouter(Titre titre){
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(titre);
		et.commit();
	}
	
	public List<Titre> alltable(){
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		List<Titre> listeTitre= new ArrayList<Titre>();
		Query requete = em.createQuery(JPQL_SELECT_ALL);
		try{
			listeTitre = (List<Titre>) requete.getResultList();
		}catch(NoResultException e){}
		
		et.commit();
		return listeTitre;
	}
}
