package manager;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Agency;

@Stateless
public class AgencyManager {
	
	@PersistenceContext(unitName="MyBankPersistence")
	protected EntityManager em;
	
	public Agency findById(int id) {
		return em.find(Agency.class, id);
	}
	
	public List<Agency> findAll(){
		List<Agency> items = em.createQuery("SELECT a from Agency a", Agency.class).getResultList();
		return items;
	}
	

}
