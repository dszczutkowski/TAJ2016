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
public class HeheszkiParametryczne {
	int input;
	int expected;
	private PsikusImpl psikus;

	@Before
	public void Start() {
		psikus = new PsikusImpl();
	}

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { { 0, 0 } });
	}

	public HeheszkiParametryczne(int input, int expected) {
		this.input = input;
		this.expected = expected;
	}

	@Test
	public void HeheszkiParametryczneTest() {
		assertEquals(Integer.valueOf(this.expected), psikus.Heheszki(this.input));
	}
}
