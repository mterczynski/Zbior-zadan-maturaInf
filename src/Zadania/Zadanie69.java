package Zadania;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

public class Zadanie69 {

	ArrayList<String> geonotypy = new ArrayList<String>();
	
	ArrayList<String> wezGeny(String genotyp){
		ArrayList<String> geny = new ArrayList<String>();
		String obecnyGen = "";
		for(int i=1; i<genotyp.length(); i++) {
			if(obecnyGen.equals("")) {
				if(genotyp.charAt(i-1) == 'A' && genotyp.charAt(i) == 'A') {
					// start genu
					obecnyGen = "AA";
				}
			} else if(genotyp.charAt(i) == 'B' && i<genotyp.length()-1 && genotyp.charAt(i+1) == 'B') {
				// koniec genu
				obecnyGen += "BB";
				geny.add(obecnyGen);
				obecnyGen = "";
				i++;
			} else {
				obecnyGen += genotyp.charAt(i);
			}
		}

		return geny;
	}
	
	ArrayList<String> wezGenyZPrawej(String genotyp){
		ArrayList<String> geny = new ArrayList<String>();
		String obecnyGen = "";
		for(int i=genotyp.length()-1; i>=0; i--) {
			if(obecnyGen.equals("")) {
				if(i>0 && genotyp.charAt(i-1) == 'A' && genotyp.charAt(i) == 'A') {
					// start genu
					obecnyGen = "AA";
					i--;
				}
			} else if(genotyp.charAt(i) == 'B' && i>0 && genotyp.charAt(i-1) == 'B') {
				// koniec genu
				obecnyGen += "BB";
				geny.add(obecnyGen);
				obecnyGen = "";
				i--;
			} else {
				obecnyGen += genotyp.charAt(i);
			}
		}

		return geny;
	}
	
	public Zadanie69() {
		try {
			Scanner plik_daneGen = new Scanner(new File("Files/69/dane_geny.txt"));
			while(plik_daneGen.hasNext()) {
				geonotypy.add(plik_daneGen.next());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		pp1();
		pp2();
		pp3();
		pp4();
	}

	void pp1() {
		HashMap<Integer, ArrayList<String>> dlugoscGenotypu_osobniki = new HashMap<Integer, ArrayList<String>>();
		for(String genotyp : geonotypy) {
			int dlugosc = genotyp.length();
			if(dlugoscGenotypu_osobniki.containsKey(dlugosc)) {
				dlugoscGenotypu_osobniki.get(dlugosc).add(genotyp);
			} else {
				ArrayList<String> osobniki = new ArrayList<String>();
				osobniki.add(genotyp);
				dlugoscGenotypu_osobniki.put(dlugosc, osobniki);
			}
		}
		int max = 0;
		for(Entry<Integer, ArrayList<String>> entry : dlugoscGenotypu_osobniki.entrySet()) {
			max = Math.max(max, entry.getValue().size());
		}
		
		System.out.println("69.1: ");
		System.out.println("Iloœæ gatunków: " + dlugoscGenotypu_osobniki.size());
		System.out.println("Najwiêksza iloœæ osobników w gatunku: " + max);
	}
	
	void pp2() {
		int ileOsobnikowZMutacja = 0;
		for(String genotyp : geonotypy) {
			ArrayList<String> geny = wezGeny(genotyp);
			for(String gen : geny) {
				if(gen.replaceAll("BCDDC", "").length() < gen.length()) {
					ileOsobnikowZMutacja++;
					break;
				}
			}
		}
		System.out.println("69.2: " + ileOsobnikowZMutacja);
	}

	void pp3() {
		int maxGenowUJednego = 0;
		int dlugoscNajdluzszegoGenu = 0;
		for(String genotyp : geonotypy) {
			ArrayList<String> geny = wezGeny(genotyp);
			maxGenowUJednego = Math.max(maxGenowUJednego, geny.size());
			for(String gen : geny) {
				dlugoscNajdluzszegoGenu = Math.max(dlugoscNajdluzszegoGenu, gen.length());
			}
		}
		System.out.println("69.3: ");
		System.out.println("Max genów u jednego osobnika: " + maxGenowUJednego);
		System.out.println("D³ugoœæ najd³u¿szego genu: " + dlugoscNajdluzszegoGenu);
	}
	
	void pp4() {
		int ileOdpornych = 0;
		int ileSilnieOdpornych = 0;
		
		for(String genotyp : geonotypy) {
			if(String.join("", wezGeny(genotyp)).equals(String.join("", wezGenyZPrawej(genotyp)))) {
				ileOdpornych++;
			}
			if(genotyp.equals(new StringBuilder(genotyp).reverse().toString())) {
				ileSilnieOdpornych++;
			}
		}
		
		System.out.println("69.4: ");
		System.out.println("Ile odpornych: " + ileOdpornych);
		System.out.println("Ile silnie odpornych: " + ileSilnieOdpornych);
	}
	
}
