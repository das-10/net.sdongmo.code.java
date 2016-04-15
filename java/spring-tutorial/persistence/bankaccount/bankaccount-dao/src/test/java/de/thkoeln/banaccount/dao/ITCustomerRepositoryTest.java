package de.thkoeln.banaccount.dao;

import static org.junit.Assert.*;

import javax.transaction.Transactional;

import static org.hamcrest.Matchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

import de.thkoeln.bankaccount.dao.Aplication;
import de.thkoeln.bankaccount.dao.Customer;
import de.thkoeln.bankaccount.dao.CustomerRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Aplication.class)
@DatabaseSetup(ITCustomerRepositoryTest.DATASET)
@Transactional
public class ITCustomerRepositoryTest {
	
	protected static final String DATASET = "classpath:bankaccount.xml";
	
	@Autowired
	private CustomerRepository repository;

	@Test
	public void saveCustomerCorrectly() {
		Customer peter = new Customer("Peter");
		assertTrue(repository.save(peter).getId()>0);
	}

}
