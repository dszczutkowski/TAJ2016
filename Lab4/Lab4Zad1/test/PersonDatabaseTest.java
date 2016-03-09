import static org.junit.Assert.*;

import java.sql.SQLException;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

public class PersonDatabaseTest {

	
	@Mock
	PersonDatabaseService service;
	private PersonMockServiceImpl serv;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		serv = new PersonMockServiceImpl();
		serv.setService(service);
	}

	@After
	public void tearDown() throws Exception {
		service=null;
		serv=null;		
	}

	@Test
	public void CorrectTest() throws SQLException, PersonException {
		Person person = new Person(1,"Adam","Nowak",2500);
		when(service.AddPerson(person)).thenReturn(new Integer(1));
		boolean result = serv.AddPerson(person);
		assertTrue(result);
		verify(service).AddPerson(person);
	}
	
	@Test(expected=PersonException.class)
	public void ExceptionTest() throws SQLException, PersonException{
		Person person = new Person();
		when(service.AddPerson(person)).thenThrow(new SQLException());
		boolean result = serv.AddPerson(person);
		assertFalse(result);
		verify(service).AddPerson(person);
	}
	
	@Test
	public void RemoveTest() throws SQLException, PersonException {
		Person person = new Person(1,"Adam","Nowak",2500);
		when(service.remove(person.getId())).thenReturn(new Integer(1));
		boolean result = serv.remove(person.getId());
		assertTrue(result);
		verify(service).remove(person.getId());
	}
	
	@Test
	public void ReadTest() throws SQLException, PersonException {
		Person person = new Person(1,"Adam","Nowak",2500);
		when(service.read(person.getId())).thenReturn(new Person());
		boolean result = serv.read(person.getId());
		assertTrue(result);
		verify(service).read(person.getId());
	}
	
	@Test
	public void UpdateTest() throws SQLException, PersonException {
		Person person = new Person(1,"Adam","Nowak",2500);
		when(service.update(person.getId())).thenReturn(new Integer(1));
		boolean result = serv.update(person.getId());
		assertTrue(result);
		verify(service).update(person.getId());
	}
	
	@Test(expected=PersonException.class)
	public void RemoveExceptionTest() throws SQLException, PersonException{
		Person person = new Person();
		when(service.remove(person.getId())).thenThrow(new SQLException());
		boolean result = serv.remove(person.getId());
		assertFalse(result);
		verify(service).remove(person.getId());
	}
	
	@Test(expected=PersonException.class)
	public void ReadExceptionTest() throws SQLException, PersonException{
		Person person = new Person();
		when(service.read(person.getId())).thenThrow(new SQLException());
		boolean result = serv.read(person.getId());
		assertFalse(result);
		verify(service).read(person.getId());
	}
	
	@Test(expected=PersonException.class)
	public void UpdateExceptionTest() throws SQLException, PersonException{
		Person person = new Person();
		when(service.update(person.getId())).thenThrow(new SQLException());
		boolean result = serv.update(person.getId());
		assertFalse(result);
		verify(service).update(person.getId());
	}

}
