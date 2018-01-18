package Zadania;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Zadanie64 {
	
	class Obrazek{
		List<String> linie = new ArrayList<String>();
		String bityKolumn = "";
	}
	
	Scanner plik_obrazki;
	List<Obrazek> obrazki = new ArrayList<Obrazek>();
	
	public Zadanie64() {
		
		try {
			plik_obrazki = new Scanner(new File("Files/64/dane_obrazki.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while(plik_obrazki.hasNext()) {
			List<String> linie = new ArrayList<String>();
			for(int i=0; i<20; i++) {
				linie.add(plik_obrazki.next());
			}
			
			Obrazek obrazek = new Obrazek();
			obrazek.linie = linie;
			obrazek.bityKolumn = plik_obrazki.next();
			obrazki.add(obrazek);
		}
		
		//pp1();
		pp2();
		
	}
	
	void pp1() {
		int ileRewersow = 0;
		int maxCzarnych = 0;
		
		for(int i=0; i<obrazki.size(); i++) {
			int ileCzarnychWObrazku = 0;
			
			Obrazek obrazek = obrazki.get(i);
			for(int j=0; j<20; j++) {
				for(int k=0; k<20; k++) {
					if(obrazek.linie.get(j).charAt(k) == '1') {
						ileCzarnychWObrazku++;
					}
				}
			}
			
			if(ileCzarnychWObrazku > 200) {
				ileRewersow++;
			}
			
			maxCzarnych = Math.max(maxCzarnych, ileCzarnychWObrazku);
		}
		
		System.out.println();
		System.out.println("64.1: Iloœæ rewersów: " + ileRewersow + ", Max iloœæ czarnych px w obrazku: " + maxCzarnych);
		System.out.println();
	}
	
	void pp2() {
		
		int ileRekurencyjnych = 0;
		Obrazek pierwszyRekurencyjny = null;
		
		for(Obrazek obrazek : obrazki) {
			boolean czyReku = true;
			for(int i=0; i<10; i++) {
				String linia1 = obrazek.linie.get(i);
				String linia2 = obrazek.linie.get(i + 10);
				if(!linia1.equals(linia2) || ! linia1.substring(0, 5).equals(linia1.substring(5, 10))) {
					czyReku = false;
					break;
				}
			}
			if(czyReku) {
				ileRekurencyjnych++;
			}
			if(pierwszyRekurencyjny == null && czyReku) {
				pierwszyRekurencyjny = obrazek;
			}
		}
		
		System.out.println();
		System.out.println("64.2: Iloœæ obrazków rekurencyjnych: " + ileRekurencyjnych);
		System.out.println("Pierwszy obrazek rekurencyjny: ");
		for(int i=0; i<20; i++) {
			String linia = pierwszyRekurencyjny.linie.get(i);
			System.out.println(linia.substring(0, 20));
		}
	}
	
	void pp3() {
		
	}
	
	void pp4() {
		
	}
}
