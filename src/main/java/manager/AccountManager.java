package manager;

import java.lang.instrument.IllegalClassFormatException;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Account;
import model.PeriodicTransaction;

@Stateless
public class AccountManager {

	@PersistenceContext(unitName="MyBankPersistence")
	private EntityManager em;
	
	public void save(Account o) {
		try{
			em.persist(o);
		}
		catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

	/**
	 * Sauvegarde en base un changement sur un compte
	 */
	public void save(Account o, int id) {
		//Récupère le compte à modifier
		Account currentAccount = (Account)(findById(id));
		//Copy tout les éléments sauf l'id du nouveau compte vers l'ancien
		currentAccount = copy((Account)o);
		em.persist(currentAccount);
	}

	
	public Account findById(int id) {
		return em.find(Account.class, id);
	}
	
	public List<Account> findByName(String name) throws IllegalClassFormatException {
		Query q =  em.createQuery("SELECT a from Account a where a.account_number = :name");
		q.setParameter("name",name);
		if(q.getResultList().contains(Account.class)){
			return q.getResultList();
		}
		else{
			throw new IllegalClassFormatException("EntityManager query tried to return a list of non-Account object");
		}
		
	}
	
	private Account copy(Account a){
		return new Account(a.getAccountNumber(), a.getCreationDate(), a.getFirstTotal(), a.getOverdraft(),
					a.getInterestRate(), a.getAgency(), a.getCountryCode(), a.getAccountType(), a.getAlertThresh());
	}

	public List<Account> findAll() {
		return em.createQuery("SELECT a from Account a", Account.class).getResultList();
	}
	
	/**
	 *
	 * @param a nouveau compte
	 * @param id du compte à moidifier
	 */
	public void edit(Account a, int id){
		Account account = em.find(Account.class, id);
		
		account.setAccountNumber(a.getAccountNumber());
		account.setAccountType(a.getAccountType());
		account.setAgency(a.getAgency());
		account.setAlertThresh(a.getAlertThresh());
		account.setCountryCode(a.getCountryCode());
		account.setCreationDate(a.getCreationDate());
		account.setFirstTotal(a.getFirstTotal());
		account.setInterestRate(a.getInterestRate());
		account.setOverdraft(a.getOverdraft());
		account.setTransactions(a.getTransactions());
		
		em.persist(account);
		
	}
	

}
