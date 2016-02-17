package main;

public class NWD {

	public int nwd(int a, int b) {
		if (b<=0 || a<=0)
			throw new IllegalArgumentException();
		else {
			int tmp;
			while (b != 0) {
				tmp = a % b;
				a = b;
				b = tmp;
			}
			return a;
		}
	}
}
