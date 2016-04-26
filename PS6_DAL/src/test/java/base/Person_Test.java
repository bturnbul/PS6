package base;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.PersonDomainModel;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;

public class Person_Test {
	
	 PersonDomainModel p;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	

		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	
	
	
	}

	@Before
	public void setUp() throws Exception {
		
		p = new PersonDomainModel();
		p.setPersonID(UUID.randomUUID());
		p.setFirstName("Bill");
		p.setLastName("Smith");
		p.setStreet("123 main street");
		p.setPostalCode(24689);
		p.setCity("newark");
		p.setBirthday(LocalDate.of(1984, 3, 14));
	}

	@After
	public void tearDown() throws Exception {
		
		p = null;
	
	}

	@Test
	public void test() {
	PersonDAL.addPerson(p)	;
	assertNotNull(PersonDAL.getPerson(p.getPersonID()));
	assertTrue(PersonDAL.getPersons() instanceof ArrayList);
	}
	@Test
	public void test2() {
		p.setCity("Elkton");
		PersonDAL.updatePerson(p);
		String city = PersonDAL.getPerson(p.getPersonID()).getCity();
		assertEquals(city, "Elkton");
	}
	
	@Test
	public void test3(){
	PersonDAL.deletePerson(p.getPersonID());
	assertTrue(PersonDAL.getPersons().isEmpty());
	}
	

}
