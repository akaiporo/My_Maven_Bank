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
		Query q = em.createQuery("SELECT p FROM PeriodicTransaction p");
		return q.getResultList();
	}
	
	public void DeleteTransaction(int id) {
		PeriodicTransaction periodictransaction = em.find(PeriodicTransaction.class, id);
		em.remove(periodictransaction);
	}
	
	public List<PeriodicTransaction> findAllByAccountId(int id){
		Query q = em.createQuery("SELECT p FROM PeriodicTransaction p WHERE p.account = :account");
		q.setParameter("account", em.find(Account.class,id)); //rechercher l'account par son id
		return q.getResultList();
	}
	
}
