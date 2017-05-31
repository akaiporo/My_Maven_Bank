package manager;

import java.lang.instrument.IllegalClassFormatException;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Account;

@Stateless
public class AccountManager implements Manager {

	@PersistenceContext(unitName="MyBankPersistence")
	private EntityManager em;
	
	@Override
	public void save(Object o) {
		if(o.getClass().equals(Account.class)){
			em.persist(o);
		}
		else{
			throw new IllegalArgumentException(String.format("Can't save %s in the Account database table", o.getClass()));
		}
	}

	@Override
	/**
	 * Sauvegarde en base un changement sur un compte
	 */
	public void save(Object o, int id) {
		if(o.getClass().equals(Account.class)){
			//Récupère le compte à modifier
			Account currentAccount = (Account)(findById(id));
			//Copy tout les éléments sauf l'id du nouveau compte vers l'ancien
			currentAccount = copy((Account)o);
			em.persist(currentAccount);
		}
		else{
			throw new IllegalArgumentException(String.format("Can't save %s in the Account database table", o.getClass()));
		}
	}

	@Override
	public Object findById(int id) {
		return em.find(Account.class, id);
	}

	@Override
	public List<Object> findByName(String name) throws IllegalClassFormatException {
		String query = String.format("SELECT a from Account a where a.account_number = %s", name);
		if(em.createQuery(query).getResultList().contains(Account.class)){
			return em.createQuery(query).getResultList();
		}
		else{
			throw new IllegalClassFormatException("EntityManager query tried to return a list of non-Account object");
		}
		
	}
	
	private Account copy(Account a){
		return new Account(a.getAccountNumber(), a.getCreationDate(), a.getFirstTotal(), a.getOverdraft(),
					a.getInterestRate(), a.getAgency(), a.getCountryCode(), a.getAccountType(), a.getAlertThresh());
	}
	

}
