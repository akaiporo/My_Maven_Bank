package manager;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Category;

@Stateless
public class CreateTransactionManager {

	@PersistenceContext(unitName="MyBankPersistence")
	private EntityManager em;
	
	public List<String> findAll() {
		Query q =  em.createQuery("SELECT pt.wording FROM Category pt", String.class);
		return q.getResultList();
		
		/*Category cat1=new Category("kigusf",null);
		List<Category> cats = new ArrayList<Category>();
		cats.add(cat1);
		
		return cats; 
		*/
		
		
	}

}
