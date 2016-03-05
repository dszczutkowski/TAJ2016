package projekt1zad2;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CyfroKradTest {

	private PsikusImpl psikus;

	@Before
	public void Start() {
		psikus = new PsikusImpl();
	}
	
	@Test
	public void CyfroKradPowinienZabracJednaLiczbeTest() {
		String liczba1 = "012345";
		String liczba2 = psikus.CyfroKrad(Integer.parseInt(liczba1)).toString();
		assertEquals(liczba1.length()-1, liczba2.length());
	}
	
	@Test
	public void CyfroKradJednocyfrowaLiczbaTest() {
		assertNull(psikus.CyfroKrad(1));
		assertNull(psikus.CyfroKrad(0));
		assertNull(psikus.CyfroKrad(-1));
		
	}
	
	@Test
	public void CyfroKradWielocyfrowaLiczbaTest() {
		assertThat(psikus.CyfroKrad(41), either(is(4)).or(is(1)));
		assertThat(psikus.CyfroKrad(-41), either(is(-4)).or(is(-1)));
		assertThat(psikus.CyfroKrad(678), either(is(67)).or(is(78)).or(is(68)));
		assertThat(psikus.CyfroKrad(-678), either(is(-67)).or(is(-78)).or(is(-68)));
	}
	
	@Test
	public void CyfroKradGdyPrzekazujemyNullTest() {
		assertNull(psikus.CyfroKrad(null));
	}
	
	@After
	public void Koniec() {
		psikus = null;
	}
}