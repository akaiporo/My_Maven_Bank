package manager;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
	public void save(Object o, int id) {
		if(o.getClass().equals(Account.class)){
			em.persist(o);
		}
		else{
			throw new IllegalArgumentException(String.format("Can't save %s in the Account database table", o.getClass()));
		}
	}

	@Override
	public Object findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
