package manager;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.PeriodicTransaction;


@Stateless
public class PeriodicTransactionManager {

	
	@PersistenceContext(unitName="MyBankPersistence")
	private EntityManager em;
	
	public List<PeriodicTransaction> findAll() {
		em.find(PeriodicTransaction.class, 1);
		
		 return em.createNamedQuery("PeriodicTransaction.findAll", PeriodicTransaction.class).getResultList();
	}
	
}
