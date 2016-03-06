package projekt1zad2;

import java.util.ArrayList;
import java.util.Random;

public class PsikusImpl implements Psikus {

	Random rnd = new Random();
	private int liczba;

	public void ustawLiczba(int liczba) {
		this.liczba = liczba;
	}

	public PsikusImpl() {

	}

	public PsikusImpl(int liczba) {
		this.liczba = liczba;
	}

	public Integer CyfroKrad(Integer liczba) {
		boolean ujemna = false;
		if (liczba < 0)
			ujemna = true;

		liczba = Math.abs(liczba);
		String liczbaToString = liczba.toString();

		if (liczbaToString.length() <= 1)
			return null;
		else {
			int pozycja = rnd.nextInt(liczbaToString.length());
			StringBuilder sb = new StringBuilder(liczbaToString);
			sb.deleteCharAt(pozycja);
			int wynik = Integer.parseInt(sb.toString());

			if (ujemna) {
				return -wynik;
			} else
				return wynik;
		}
	}

	public Integer HultajChochla(Integer liczba) throws NieudanyPsikusException {
		boolean ujemna = false;
		if (liczba < 0)
			ujemna = true;
		
		liczba = Math.abs(liczba);
		String liczbaStr = liczba.toString();
		
		if (liczbaStr.length() < 2)
			throw new NieudanyPsikusException();
		else {
			StringBuilder sb = new StringBuilder(liczbaStr);
			int p1 = rnd.nextInt(liczbaStr.length());
			int p2;
			do
				p2 = rnd.nextInt(liczbaStr.length());
			while (p2 == p1);

			char znak1 = sb.charAt(p1);
			char znak2 = sb.charAt(p2);
			sb.setCharAt(p2, znak1);
			sb.setCharAt(p1, znak2);
			Integer wynik = Integer.parseInt(sb.toString());
			
			if (ujemna)
				return -wynik;
			return wynik;
		}
	}

	public Integer Nieksztaltek(Integer liczba) {
		ArrayList<Integer> pozycje = new ArrayList<Integer>();
		String liczbaStr = liczba.toString();
		StringBuilder sb = new StringBuilder(liczbaStr);
		
		for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i) == '3' || sb.charAt(i) == '7' || sb.charAt(i) == '6')
				pozycje.add(i);
		}
		
		if (pozycje.size() == 0)
			return Integer.parseInt(sb.toString());
		else {
			int p = rnd.nextInt(pozycje.size());
			
			if (sb.charAt(pozycje.get(p)) == '3')
				sb.setCharAt((pozycje.get(p)), '8');
			else if (sb.charAt(pozycje.get(p)) == '7')
				sb.setCharAt((pozycje.get(p)), '1');
			else if (sb.charAt(pozycje.get(p)) == '6')
				sb.setCharAt((pozycje.get(p)), '9');

			return Integer.parseInt(sb.toString());
		}
	}

	public Integer Heheszki(Integer liczba) {
		if (liczba == 0)
			return 0;

		boolean ujemna = false;
		if (liczba < 0)
			ujemna = true;

		liczba = Math.abs(liczba);

		if (ujemna)
			return -(Integer) rnd.nextInt((int) liczba);
		else
			return (Integer) rnd.nextInt((int) liczba);
	}

	public boolean Titit(Integer liczba_dziel) {
		if (liczba % liczba_dziel == 0)
			return true;
		else
			return false;
	}

}
