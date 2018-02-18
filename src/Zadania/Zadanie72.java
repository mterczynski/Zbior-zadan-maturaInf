package Zadania;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Zadanie72 {

	ArrayList<String> lines = new ArrayList<String>();
	
	public Zadanie72() {
		try {
			Scanner sc = new Scanner(new File("Files/72/napisy.txt"));
			while(sc.hasNext()) {
				lines.add(sc.nextLine());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		pp1();
		pp2();
		pp3();
	}

	void pp1() {
		System.out.println("72.1: ");
		int ileWierszy = 0;
		boolean czyPierwszy = true;
		for(String linia : lines) {
			String str1 = linia.split(" ")[0];
			String str2 = linia.split(" ")[1];
			if(str1.length() >= 3 * str2.length() || str2.length() >= 3 * str1.length()) {
				ileWierszy++;
				if(czyPierwszy) {
					System.out.println("Pierwsza para:");
					System.out.println(linia);
					czyPierwszy = false;
				}
			}
		}
		
		System.out.println("Iloœæ wierszy: " + ileWierszy);
	}
	void pp2() {
		System.out.println("72.2: ");
		for(String linia : lines) {
			String str1 = linia.split(" ")[0];
			String str2 = linia.split(" ")[1];
			if(str2.length() <= str1.length()) {
				continue;
			}
			if(!str2.startsWith(str1)) {
				continue;
			}

			System.out.println("wiersz : " + linia);
			System.out.println("ci¹g znaków do dopisania : ");
			System.out.println(str2.substring(str1.length(), str2.length()));
		}
	}
	void pp3() {
		System.out.println("72.3: ");
		
		int maxDlugoscZakonczenia = 0;
		ArrayList<String> linieZNajdluzszymi = new ArrayList<String>();
		for(String linia : lines) {
			String str1 = linia.split(" ")[0];
			String str2 = linia.split(" ")[1];
			int zakonczenieDlugosc = 0;
			String zakonczenie = "";
			for(int i=1; i<=str1.length() && i<=str2.length(); i++) {
				char znak1 = str1.charAt(str1.length()-i);
				char znak2 = str2.charAt(str2.length()-i);
				if(znak1 == znak2) {
					zakonczenieDlugosc++;
					zakonczenie += znak1;
				} else {
					break;
				}
			}
			
			if(zakonczenieDlugosc > maxDlugoscZakonczenia) {
				maxDlugoscZakonczenia = zakonczenieDlugosc;
				linieZNajdluzszymi = new ArrayList<String>(); 
				linieZNajdluzszymi.add(linia);
			} else if(zakonczenieDlugosc == maxDlugoscZakonczenia) {
				linieZNajdluzszymi.add(linia);
			}
		}
		
		System.out.println("Najd³u¿sze zakoñczenie ma d³ugoœæ: " + maxDlugoscZakonczenia);
		System.out.println(linieZNajdluzszymi);
	}
}
