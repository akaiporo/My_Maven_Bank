package manager;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.AccountType;

@Stateless
public class AccountTypeManager {
	@PersistenceContext(unitName="MyBankPersistence")
	protected EntityManager em;
	
	public List<AccountType> findAll(){
		List<AccountType> items = em.createQuery("SELECT a from AccountType a", AccountType.class).getResultList();
		return items;
	}
	
	public AccountType findById(int id){
		return em.find(AccountType.class, id);
	}
}
