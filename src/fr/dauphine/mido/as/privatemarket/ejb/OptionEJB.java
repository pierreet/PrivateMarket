package fr.dauphine.mido.as.privatemarket.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import fr.dauphine.mido.as.privatemarket.entities.Stockoption;

@Stateless
public class OptionEJB {

	@PersistenceUnit(unitName="basePM")
	private EntityManagerFactory emf;
	
	public void ajouter(Stockoption stockoption){
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(stockoption);
		et.commit();
	}
	
}
