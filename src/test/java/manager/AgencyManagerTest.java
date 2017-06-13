package manager;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;

import org.junit.Before;
import org.junit.Test;

import model.AccountAlreadyExistingException;
import model.Address;
import model.Agency;
import model.Bank;
import model.CpCity;
@ManagedBean
public class AgencyManagerTest extends EjbContainerTest{

	@EJB
	private AgencyManager agencyManager;
	
	private Agency agency;
	private Address addressTest;
	private Bank bankTest;
	
	@Before
	public void init() throws Exception{
		tx.begin();
		CpCity cpCity = new CpCity("40120", "Roquefort");
		em.persist(cpCity);
		Address address = new Address("line 1", "line 2", cpCity);
		em.persist(address);
		Bank bank = new Bank("bank", "bank_code");
		em.persist(bank);
		tx.commit();
		
		addressTest = em.find(Address.class, address.getId());
		bankTest = em.find(Bank.class, bank.getId());
		agency = new Agency("agency", "12345", addressTest, bankTest);
	}
	
	@Test
	public void persistAgency() throws Exception{
		agencyManager.save(agency);
		Agency expectedAgency = agencyManager.findById(agency.getId());
		assertThat(expectedAgency.getAgencyName(), is("agency"));
		assertThat(expectedAgency.getCounterCode(), is("12345"));
		assertThat(expectedAgency.getAddress().getId(), is(addressTest.getId()));
		assertThat(expectedAgency.getBank().getId(), is(bankTest.getId()));
		
	}
}
