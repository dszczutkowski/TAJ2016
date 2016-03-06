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
public class HultajChochlaParametryczne {
	int input;
	int expected;
	private PsikusImpl psikus;

	@Before
	public void Start() {
		psikus = new PsikusImpl();
	}

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { { 21, 12 }, { 34, 43 }, { -56, -65 }, { 77, 77 } });
	}

	public HultajChochlaParametryczne(int input, int expected) {
		this.input = input;
		this.expected = expected;
	}

	@Test
	public void HultajChochlaParametryczneTest() throws NieudanyPsikusException {
		assertEquals(Integer.valueOf(this.expected), psikus.HultajChochla(this.input));
	}
}
