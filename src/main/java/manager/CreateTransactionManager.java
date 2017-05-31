package manager;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Category;

@Stateless
public class CreateTransactionManager {

	@PersistenceContext(unitName="MyBankPersistence")
	private EntityManager em;
	
	public List<Object> findAll() {
		//List categories=em.createNamedQuery("Category.findAll").getResultList();
		//System.out.println(((Category)categories.get(0)).getWording());
		Category cat1=new Category("kigusf",null);
		List<Object> cats = new ArrayList<Object>();
		cats.add(cat1);
		
		return cats; 
		
	}

}
