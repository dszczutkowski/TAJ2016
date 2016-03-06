package projekt1zad2;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TititParametryczne {
	int input;
	boolean expected;
	private PsikusImpl psikus;

	@Before
	public void Start() {
		psikus = new PsikusImpl(55);
	}

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { { 5, true }, { 2, false }, { 55, true }, { -5, true } });
	}

	public TititParametryczne(int input, boolean expected) {
		this.input = input;
		this.expected = expected;
	}

	@Test
	public void TititParametryczneTest() {
		assertEquals(Boolean.valueOf(this.expected), psikus.Titit(this.input));
	}
}
