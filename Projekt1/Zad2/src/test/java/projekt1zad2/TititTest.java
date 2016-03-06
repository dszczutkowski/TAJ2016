package projekt1zad2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;

public class TititTest {

	private PsikusImpl psikus;

	@Before
	public void Start() {
		psikus = new PsikusImpl(55);
	}

	@Test
	public void TititDzielenieTest() {
		assertThat(psikus.Titit(5), is(true));
		assertThat(psikus.Titit(2), is(false));
		psikus.ustawLiczba(56);
		assertThat(psikus.Titit(2), is(true));
		assertThat(psikus.Titit(5), is(false));
	}

	@After
	public void Koniec() {
		psikus = null;
	}
}
