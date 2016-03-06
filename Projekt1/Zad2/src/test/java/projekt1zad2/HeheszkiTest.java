package projekt1zad2;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import projekt1zad2.NieudanyPsikusException;
import projekt1zad2.PsikusImpl;

public class HeheszkiTest {

	private PsikusImpl psikus;

	@Before
	public void Start() {
		psikus = new PsikusImpl();
	}

	@Test(expected = NieudanyPsikusException.class)
	public void NieudanyPsikusExceptionTest() throws NieudanyPsikusException {
		psikus.Heheszki(0);
	}

	@Test
	public void HeheszkiPrzedialDodatniTest() throws NieudanyPsikusException {
		assertThat(psikus.Heheszki(1), is(1));
		assertThat(psikus.Heheszki(9), is(both(greaterThanOrEqualTo(0)).and(lessThan(9))));
	}

	@Test
	public void HeheszkiPrzedialUjemnyTest() throws NieudanyPsikusException {
		assertThat(psikus.Heheszki(-1), is(-1));
		assertThat(psikus.Heheszki(-9), is(both(greaterThan(-9)).and(lessThanOrEqualTo(0))));
	}

	@After
	public void Koniec() {
		psikus = null;
	}
}
