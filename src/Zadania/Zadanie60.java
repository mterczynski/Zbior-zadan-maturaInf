package Zadania;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Zadanie60 {
	
	Scanner plikLiczby;
	ArrayList<Integer> liczby = new ArrayList<Integer>();
	
	public Zadanie60() {
		try {
			plikLiczby = new Scanner(new File("Files/60/liczby.txt"));
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		while(plikLiczby.hasNext()) {
			liczby.add(plikLiczby.nextInt());
		}
		
		pp1();
		pp2();
		pp3();
	}
	
	
	private void pp1() {
		int ileMniejszychOd1000 = 0;
		int przedostatnia = 0;
		int ostatnia = 0;
		for(int i=0; i<liczby.size(); i++) {
			if(liczby.get(i) < 1000) {
				ileMniejszychOd1000++;
				przedostatnia = ostatnia;
				ostatnia = liczby.get(i);
			}
		}
		System.out.println("60.1: ");
		System.out.println("Ilość liczb mniejszych od 1000: " + ileMniejszychOd1000);
		System.out.println("Dwie ostatnie liczby: " + przedostatnia + ", " + ostatnia);
	}
	private void pp2() {
		System.out.println("60.2: ");
		for(int i=0; i<liczby.size(); i++) {
			int liczba = liczby.get(i);
			ArrayList<Integer> dzielniki = new ArrayList<Integer>();
			for(int j=1; j<=liczba; j++) {
				if(liczba % j == 0) {
					dzielniki.add(j);
				}
			}
			
			if(dzielniki.size() == 18) {
				System.out.println(liczba);
				System.out.println(dzielniki);
			}
		}
	}
	private void pp3() {
		Collections.sort(liczby);
		Collections.reverse(liczby);
		
		for(int i=0; i<liczby.size(); i++) {
			int liczba = liczby.get(i);
			ArrayList<Integer> dzielnikiPoza1 = new ArrayList<Integer>();
			for(int j=2; j<=liczba; j++) {
				if(liczba % j == 0) {
					dzielnikiPoza1.add(j);
				}
			}
			
			boolean czyJestWzgledniePierwsza = true;
			for(int j=i+1; j<liczby.size()-i-1; j++) {
				czyJestWzgledniePierwsza = true;
				for(int k=0; k<dzielnikiPoza1.size(); k++) {
					if(liczby.get(j) % dzielnikiPoza1.get(k) == 0) {
						// liczba nie jest wzglednie pierwsza;
						czyJestWzgledniePierwsza = false;
						j = 100000;
						break;
					}
				}	
			}
			if(czyJestWzgledniePierwsza) {
				System.out.println();
				System.out.println("60.3: ");
				System.out.println("Największa względnie pierwsza liczba to: " + liczba);
				System.out.println();
				break;
			}	
		}
	}
}
