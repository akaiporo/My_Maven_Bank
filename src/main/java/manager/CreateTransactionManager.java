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
	
	public List<Category> findAllCategories() {
		Query q =  em.createNamedQuery("Category.findAllName", String.class);
		Query z =  em.createNamedQuery("Category.findAll", Category.class);
		return z.getResultList();
	}

}
