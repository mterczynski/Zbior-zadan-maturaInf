package Zadania;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Zadanie75 {
	
	ArrayList<String> slowa = new ArrayList<String>();
	
	String szyfruj(String wyraz, int a, int b) {
		String szyfrowany = "";
		for(int i=0; i<wyraz.length(); i++) {
			int znak = wyraz.charAt(i) - 97;
			int nowyZnak = (znak * a + b) % 26 + 97;
			szyfrowany += (char)nowyZnak;
		}
		return szyfrowany;
	}
	
	public Zadanie75() {
		try {
			Scanner plik_tekst = new Scanner(new File("Files/75/tekst.txt"));
			while(plik_tekst.hasNext()) {
				slowa.add(plik_tekst.next());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		pp1();
		pp2();
		pp3();
	}

	void pp1() {
		System.out.println("75.1: ");
		for(String slowo : slowa) {
			if(slowo.charAt(0) == 'd' && slowo.charAt(slowo.length() -1) == 'd') {
				System.out.println(slowo);
			}
		}
	}
	void pp2() {
		System.out.println();
		System.out.println("75.2: ");
		for(String slowo : slowa) {
			if(slowo.length() >= 10) {
				for(int i=0; i<slowo.length(); i++) {
					int znak = slowo.charAt(i) - 97;
					int nowyZnak = (znak * 5 + 2) % 26 + 97;
					System.out.print((char)nowyZnak);
				}
				System.out.println();
			}
		}
	}
	void pp3() {
		ArrayList<String> zwykle = new ArrayList<String>();
		ArrayList<String> zaszyfrowane = new ArrayList<String>();
		try {
			Scanner probka = new Scanner(new File("Files/75/probka.txt"));
			while(probka.hasNext()) {
				zwykle.add(probka.next());
				zaszyfrowane.add(probka.next());
			}	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("75.3:");
		for(int i=0; i<5; i++) {
			String zwykly= zwykle.get(i);
			String zaszyfrowany = zaszyfrowane.get(i);
			
			int kluczSzyfrujacyA = 999;
			int kluczSzyfrujacyB = 999; 
			for(int a=0; a<=25; a++) {
				for(int b=0; b<=25; b++) {
					if(szyfruj(zwykly,a,b).equals(zaszyfrowany)) {
						kluczSzyfrujacyA = a;
						kluczSzyfrujacyB = b;
						// double break
						a = 60;
						b = 60;
					}
				}
			}	
			
			int kluczDeszyfrujacyA = 999;
			int kluczDeszyfrujacyB = 999; 
			for(int a=0; a<=25; a++) {
				for(int b=0; b<=25; b++) {
					if(szyfruj(zaszyfrowany,a,b).equals(zwykly)) {
						kluczDeszyfrujacyA = a;
						kluczDeszyfrujacyB = b;
						// double break
						a = 60;
						b = 60;
					}
				}
			}	
			System.out.println("klucz szyfrujacy (A,B) : (" + kluczSzyfrujacyA + "," + kluczSzyfrujacyB + ")");
			System.out.println("klucz deszyfrujacy (A,B) : (" + kluczDeszyfrujacyA + "," + kluczDeszyfrujacyB + ")");
		}
	}
}
