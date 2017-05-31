package manager;

import java.lang.instrument.IllegalClassFormatException;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Agency;

@Stateless
public class AgencyManager implements Manager {

	@PersistenceContext(unitName="MyBankPersistence")
	private EntityManager em;
	
	@Override
	public void save(Object o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void save(Object o, int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object findById(int id) {
		return em.find(Agency.class, id);
	}

	@Override
	public List<Object> findByName(String name) throws IllegalClassFormatException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> findAll() {
		return em.createQuery("SELECT a from Agency a").getResultList();
	}
	

}
