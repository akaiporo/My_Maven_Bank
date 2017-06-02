package manager;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Account;
import model.Category;
import model.PeriodUnit;
import model.PeriodicTransaction;
import model.TargetTransaction;
import model.TransactionType;


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
	
	public List<Category> findAllCategories() {
		return em.createNamedQuery("Category.findAll", Category.class).getResultList();
	}

	public List<TransactionType> findAllTypes() {
		return em.createNamedQuery("TransactionType.findAll", TransactionType.class).getResultList();
	}

	public List<TargetTransaction> findAllTargets() {
		return em.createNamedQuery("TargetTransaction.findAll", TargetTransaction.class).getResultList();
	}

	public void saveTransaction(String wording, Double transaction_value, Date date_operation, Date end_date_transaction,
			  int day_number, String description, TransactionType transactionType, TargetTransaction targetTransaction, Category category,
			  PeriodUnit periodUnit, Account account){
		PeriodicTransaction saved=new PeriodicTransaction(wording, transaction_value,date_operation,end_date_transaction, 
				day_number,description, transactionType,targetTransaction,category, periodUnit);
		saved.setAccount(account);
		em.persist(saved);
	}
	
	public Category findCatById(int id){
		return em.find(Category.class, id);
	}
	public TargetTransaction findTarById(int id){
		return em.find(TargetTransaction.class, id);
	}
	public TransactionType findTypById(int id){
		return em.find(TransactionType.class, id);
	}
	
	public Double getAmount(String rdsign, String value){
		if (rdsign.equals("moins")){
			return -Math.abs(Double.valueOf(value)); 		
		}
		else return Math.abs(Double.valueOf(value));
	}

	
}
