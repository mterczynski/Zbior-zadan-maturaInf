package Zadania;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Zadanie59 {
	
	Scanner plikLiczby;
	ArrayList<Integer> liczby = new ArrayList<Integer>();
	
	public Zadanie59(){
		try {
			plikLiczby = new Scanner(new File("Files/59/liczby.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while(plikLiczby.hasNext()) {
			liczby.add(plikLiczby.nextInt());
		}
		
		pp1();
		pp2();
		pp3();
	}
	
	private void pp1() {
		int ileLiczbSpelniajacychWarunki = 0;
		
		for(Integer liczba : liczby) {
			int liczbaCp = liczba;
			ArrayList<Integer> czynnikiPierwsze = new ArrayList<Integer>();
			
			for(int i=2; i<=Math.round(Math.sqrt(liczba)); i++) {
				if(liczbaCp % i == 0) {
					czynnikiPierwsze.add(i);
					liczbaCp /= i;
					i=1; // will be 2 after i++
				}
			}
			if(liczbaCp>1) {
				czynnikiPierwsze.add(liczbaCp);
			}	
			
			HashSet<Integer> rozneCzynnikiPierwsze = new HashSet<Integer>(czynnikiPierwsze);
			
			boolean czyMaParzystyDzielnik = false;
			for (Iterator<Integer> i = rozneCzynnikiPierwsze.iterator(); i.hasNext();) {
			    Integer element = i.next();
			    if (element % 2 == 0) {
			        // liczba nie spelnia warunku
			    	czyMaParzystyDzielnik = true;
			    	break;
			    }
			}
			
			if(rozneCzynnikiPierwsze.size() == 3 && !czyMaParzystyDzielnik) {
				ileLiczbSpelniajacychWarunki++;
			}
		}
		System.out.println("59.1:");
		System.out.println("Ilość liczb majacych dokładnie 3 różne nieparzyste czynniki pierwsze: " + ileLiczbSpelniajacychWarunki);
	}
	
	private void pp2() {
		int ilePalindromow = 0;
		for(int i=0; i<liczby.size(); i++) {
			int liczba = liczby.get(i);
			int odwrocona = Integer.parseInt(new StringBuilder(liczby.get(i).toString()).reverse().toString());
			String suma = String.valueOf(odwrocona + liczba);
			if(suma.equals(new StringBuilder(suma).reverse().toString())) {
				ilePalindromow++;
			}
		}
		System.out.println();
		System.out.println("59.2:");
		System.out.println("Ilość palindromów: " + ilePalindromow);
	}
	
	private void pp3() {
		HashMap<Integer, ArrayList<Integer>> moc_liczby = new HashMap<Integer, ArrayList<Integer>>();
		
		for(int i=1; i<=8; i++) {
			moc_liczby.put(i, new ArrayList<Integer>());
		}
	
		for(int i=0; i<liczby.size(); i++) {
			String liczbaString = liczby.get(i).toString();
			int iloczyn = Character.getNumericValue(liczbaString.charAt(0));
			for(int j=1; j<liczbaString.length(); j++) {;
				iloczyn *= Character.getNumericValue(liczbaString.charAt(j));
			}
			int moc = 1;
			while(iloczyn > 9) {
				String iloczynString = String.valueOf(iloczyn);
				iloczyn = Character.getNumericValue(iloczynString.charAt(0));
				for(int j=1; j<iloczynString.length(); j++) {
					iloczyn *= Character.getNumericValue(iloczynString.charAt(j));
				}
				moc++;
			}
			moc_liczby.get(moc).add(liczby.get(i));
		}
		
		System.out.println();
		System.out.println("59.3:");
		for(int i=1; i<=8; i++) {
			System.out.println("Ilość liczb o mocy: " + i +  " wynosi " + moc_liczby.get(i).size());
		}
		System.out.println("Minimalna liczba o mocy 1: " + Collections.min(moc_liczby.get(1)));
		System.out.println("Maksymalna liczba o mocy 1: " + Collections.max(moc_liczby.get(1)));
		System.out.println();
	}

}

