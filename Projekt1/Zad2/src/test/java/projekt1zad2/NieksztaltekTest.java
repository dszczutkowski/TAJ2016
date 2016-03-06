package projekt1zad2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class NieksztaltekTest {

	private PsikusImpl psikus;

	@Before
	public void Start() {
		psikus = new PsikusImpl();
	}

	@Test
	public void NieksztaltekZmieniaCyfryTest() {
		assertThat(psikus.Nieksztaltek(0), is(0));
		assertThat(psikus.Nieksztaltek(1), is(1));
		assertThat(psikus.Nieksztaltek(13), is(18));
		assertThat(psikus.Nieksztaltek(-13), is(-18));
		assertThat(psikus.Nieksztaltek(17), is(11));
		assertThat(psikus.Nieksztaltek(-17), is(-11));
		assertThat(psikus.Nieksztaltek(61), is(91));
		assertThat(psikus.Nieksztaltek(-61), is(-91));
		assertThat(psikus.Nieksztaltek(37), either(is(87)).or(is(31)));
		assertThat(psikus.Nieksztaltek(-37), either(is(-87)).or(is(-31)));
		assertThat(psikus.Nieksztaltek(673), either(is(973)).or(is(613)).or(is(678)));
		assertThat(psikus.Nieksztaltek(-673), either(is(-973)).or(is(-613)).or(is(-678)));
	}

	@After
	public void Koniec() {
		psikus = null;
	}
}