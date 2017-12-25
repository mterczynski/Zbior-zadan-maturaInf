package Zadania;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Zadanie62 {


	Scanner plik1;
	Scanner plik2;
	
	ArrayList<String> osemkowe = new ArrayList<String>();
	ArrayList<Integer> osemkoweInt = new ArrayList<Integer>();
	ArrayList<Integer> dziesietneInt = new ArrayList<Integer>();
	
	public Zadanie62() {
		
		try {
			plik1 = new Scanner(new File("Files/62/liczby1.txt"));
			plik2 = new Scanner(new File("Files/62/liczby2.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		while(plik1.hasNext()) {
			String next = plik1.next();
			osemkoweInt.add(Integer.parseInt(next, 8));
			osemkowe.add(next);
		}
		while(plik2.hasNext()) {
			dziesietneInt.add(Integer.parseInt(plik2.next()));
		}
		
		pp1();
		pp2();
		pp3();
		pp4();
	}
	
	private void pp1() {
		Collections.sort(osemkoweInt);
		String max = Integer.toString(osemkoweInt.get(osemkoweInt.size() - 1), 8);
		String min = Integer.toString(osemkoweInt.get(0), 8);
		
		System.out.println("62.1");
		System.out.println("Min: " + min);
		System.out.println("Max: " + max);
	}
	private void pp2() {
		ArrayList<ArrayList<Integer>> ciagiMalejace = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> aktualnyCiagMalejacy = new ArrayList<Integer>();
		
		aktualnyCiagMalejacy.add(dziesietneInt.get(0));
		
		for(int i=1; i<dziesietneInt.size(); i++) {
			int liczba = dziesietneInt.get(i);
			if(aktualnyCiagMalejacy.size() == 0 || liczba >= aktualnyCiagMalejacy.get(aktualnyCiagMalejacy.size()-1)) {
				aktualnyCiagMalejacy.add(liczba);
			} else { // koniec ciagu
				ciagiMalejace.add(aktualnyCiagMalejacy);
				aktualnyCiagMalejacy = new ArrayList<Integer>(); 
				aktualnyCiagMalejacy.add(liczba);
			}
		}
		// znalezienie najdluzszego ciagu:
		ArrayList<Integer> najdluzszyCiagMalejacy = ciagiMalejace.get(0);
		for(int i=0; i<ciagiMalejace.size(); i++) {
			if(ciagiMalejace.get(i).size() > najdluzszyCiagMalejacy.size()) {
				najdluzszyCiagMalejacy = ciagiMalejace.get(i);
			}
		}
		
		System.out.println(najdluzszyCiagMalejacy);
	}
	private void pp3() {
		ArrayList<Integer> wierszeWKtorychLiczbySaTakieSame = new ArrayList<Integer>();
		ArrayList<Integer> wierszeWKtorychLiczba1JestWieksza = new ArrayList<Integer>();
		
		for(int i=0; i<dziesietneInt.size(); i++) {
			int osemkowaInt = Integer.parseInt(osemkowe.get(i), 8);
			int dziesietnaInt = dziesietneInt.get(i);
			if(osemkowaInt == dziesietnaInt) {
				wierszeWKtorychLiczbySaTakieSame.add(i + 1);
			} else if(dziesietnaInt > osemkowaInt) {
				wierszeWKtorychLiczba1JestWieksza.add(i + 1);
			}
		}
		
		System.out.println("62.2");
		System.out.println("Ilosc wierszy w ktorych liczby sa takie same: " + wierszeWKtorychLiczbySaTakieSame.size());
		System.out.println("Ilosc wierszy w ktorych liczba1 jest wiêksza: " + wierszeWKtorychLiczba1JestWieksza.size());
	}
	private void pp4() {
		int ileRazy6 = 0;
		int ileRazy6wZapisie8 = 0;
		for(int i=0; i<1000; i++) {
			String liczba = dziesietneInt.get(i) + "";
			ileRazy6 += liczba.length() - liczba.replaceAll("6", "").length();
			String liczba8 = Integer.toString(dziesietneInt.get(i), 8);
			ileRazy6wZapisie8 += liczba8.length() - liczba8.replaceAll("6", "").length();
		}
		
		System.out.println("62.3");
		System.out.println("Ilosc 6: " + ileRazy6);
		System.out.println("Ilosc 6 gdy zapiszemy liczby osemkowo: " + ileRazy6wZapisie8);
	}	
}
