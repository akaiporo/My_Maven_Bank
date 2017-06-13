package manager;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.AccountAlreadyExistingException;
import model.AccountType;
import model.Agency;
import model.ItemDoesNotExistException;

@Stateless
public class AgencyManager {
	
	@PersistenceContext(unitName="MyBankPersistence")
	protected EntityManager em;
	
	public void save(Agency a) throws AccountAlreadyExistingException{
		em.persist(a);
	}
	
	public Agency findById(int id) {
		return em.find(Agency.class, id);
	}
	
	public List<Agency> findAll(){
		List<Agency> items = em.createQuery("SELECT a from Agency a", Agency.class).getResultList();
		return items;
	}
	
	public Agency findyName(String name) throws ItemDoesNotExistException{
		Query q =  em.createQuery("SELECT a from AccountType a where a.accountType = :type", Agency.class);
		q.setParameter("type",name);
		try{
			return (Agency) q.getSingleResult();
		}
		catch(Exception e){
			throw new ItemDoesNotExistException();
		}
	}
	

}
