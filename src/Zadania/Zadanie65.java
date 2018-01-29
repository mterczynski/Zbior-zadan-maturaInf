package Zadania;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Ulamek{
	public Ulamek(int a, int b) {
		this.licznik = a;
		this.mianownik = b;
	}
	public int licznik;
	public int mianownik;
	
	public double getVal() {
		return (double)this.licznik / (double)this.mianownik;
	}
	
	public Ulamek nieskracalny() {
		int newL = licznik;
		int newM = mianownik;
		
		for(int dzielnik=newL; dzielnik>1; dzielnik--) {
			if(newL % dzielnik != 0 ) {
				continue;
			}
			if(newM % dzielnik == 0) {
				// mamy dzielnik
				newL /= dzielnik;
				newM /= dzielnik;
				dzielnik = newL;
			}
		}
		
		return new Ulamek(newL, newM);
	}
}

public class Zadanie65 {

	Scanner plik_ulamki;
	ArrayList<Ulamek> ulamki = new ArrayList<Ulamek>();
	
	public Zadanie65() {
		try {
			plik_ulamki = new Scanner(new File("Files/65/dane_ulamki.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(plik_ulamki.hasNext()) {
			int l = plik_ulamki.nextInt();
			int m = plik_ulamki.nextInt();
			ulamki.add(new Ulamek(l, m));
		}
		
		pp1();
		pp2();
		pp3();
		pp4();
	}
	
	void pp1() {
		Ulamek minUlamek = ulamki.get(0);
		
		for(int i=1; i<1000; i++) {
			Ulamek ulamek = ulamki.get(i);
			if(ulamek.getVal() < minUlamek.getVal()) {
				minUlamek = ulamek;
			} else if( ulamek.getVal() == minUlamek.getVal()) {
				if(ulamek.mianownik < minUlamek.mianownik) {
					minUlamek = ulamek;
				}
			}
		}
		
		System.out.println("65.1: " + minUlamek.licznik + "/" + minUlamek.mianownik);
	}
	
	void pp2() {
		int ile = 0;
		
		for(int i=0; i<1000; i++) {
			Ulamek ulamek = ulamki.get(i);
			int l = ulamek.licznik;
			int m = ulamek.mianownik;
			
			boolean czyNieskracalny = true;
			for(int dzielnik=l; dzielnik>1; dzielnik--) {
				if(l % dzielnik != 0 ) {
					continue;
				}
				if(m % dzielnik == 0) {
					czyNieskracalny = false;
				}
			}
			
			if(czyNieskracalny) {
				ile++;
			}
		}
		
		System.out.println("65.2: " + ile);
	}
	
	void pp3() {
		int suma = 0;
		
		for(int i=0; i<1000; i++) {
			Ulamek uproszczony = ulamki.get(i).nieskracalny();
			suma += uproszczony.licznik;
		}
		
		System.out.println("65.3: " + suma);
	}
	
	void pp4() {
		long b = 2*2 * 3*3 * 5*5 * 7*7 * 13;
		long licznik = 0;
		
		for(Ulamek ulamek : ulamki) {
			licznik += b*ulamek.licznik / ulamek.mianownik;
		}
		
		System.out.println("65.4: " + licznik);
	}
}
