package manager;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Account;
import model.Category;
import model.TargetTransaction;
import model.TransactionType;

@Stateless
public class CreateTransactionManager {

	@PersistenceContext(unitName="MyBankPersistence")
	private EntityManager em;
	
	public List<Category> findAllCategories() {
		return em.createNamedQuery("Category.findAll", Category.class).getResultList();
	}

	public List<TransactionType> findAllTypes() {
		return em.createNamedQuery("TransactionType.findAll", TransactionType.class).getResultList();
	}

	public List<TargetTransaction> findAllTargets() {
		return em.createNamedQuery("TargetTransaction.findAll", TargetTransaction.class).getResultList();
	}

	public List<Account> findAllAccounts() {
		return em.createNamedQuery("Account.findAll", Account.class).getResultList();
	}

}
