package projekt1zad2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class HultajChochlaTest {

	private PsikusImpl psikus;

	@Before
	public void Start() {
		psikus = new PsikusImpl();
	}

	@Test(expected = NieudanyPsikusException.class)
	public void NieudanyPsikusExceptionTest() throws NieudanyPsikusException {
		psikus.HultajChochla(1);
		psikus.HultajChochla(0);
		psikus.HultajChochla(-1);
		psikus.HultajChochla(null);
	}

	@Test
	public void HultajChochlaPowinienZmienicMiejscaTest() throws NieudanyPsikusException {
		assertThat(psikus.HultajChochla(10), is(1));
		assertThat(psikus.HultajChochla(-10), is(-1));
		assertThat(psikus.HultajChochla(23), is(32));
		assertThat(psikus.HultajChochla(-23), is(-32));
		assertThat(psikus.HultajChochla(123), either(is(132)).or(is(321)).or(is(213)));
		assertThat(psikus.HultajChochla(-123), either(is(-132)).or(is(-321)).or(is(-213)));
	}

	@After
	public void Koniec() {
		psikus = null;
	}
}