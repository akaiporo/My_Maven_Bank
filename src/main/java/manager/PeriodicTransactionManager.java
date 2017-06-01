package manager;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Account;
import model.PeriodicTransaction;


@Stateless
public class PeriodicTransactionManager {

	
	@PersistenceContext(unitName="MyBankPersistence")
	private EntityManager em;
	
	public List<PeriodicTransaction> findAll() {
		em.find(PeriodicTransaction.class, 1);
				
		Query q = em.createQuery("SELECT p FROM PeriodicTransaction p WHERE p.account = :account");
		q.setParameter("account", em.find(Account.class,5)); //rechercher l'account par son id
		 return q.getResultList();
	}
	
	public void DeleteTransaction(int id) {
		
		PeriodicTransaction periodictransaction = em.find(PeriodicTransaction.class, id);
		em.remove(periodictransaction);
		
		
		
	}
	
}
