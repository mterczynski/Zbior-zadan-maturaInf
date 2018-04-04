package Zadania;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Zadanie77 {

	Scanner plik_dokad;
	Scanner plik_szyfr;
	String wiersz_dokad;
	String wiersz_szyfr;
	
	public Zadanie77() {
		try {
			plik_dokad = new Scanner(new File("Files/77/dokad.txt"));
			plik_szyfr = new Scanner(new File("Files/77/szyfr.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		wiersz_dokad = plik_dokad.nextLine();
		wiersz_szyfr = plik_szyfr.nextLine();
		
		//pp1();
//		pp2();
		pp3();
	}

	int getCharId(char a) {
		return a - 65;
	}
	
	void pp1() {
		String klucz = "LUBIMYCZYTAC";
		int ilePowtorzen = 1;
		int indexKlucza = 0;
		
		for(char c : wiersz_dokad.toCharArray()) {
			if(c == ' ') {
				System.out.print(' ');
			} else if(c == '.') {
				System.out.print('.');
			} else if(c == ','){
				System.out.print(',');
			} else {
				int nowyZnak = (getCharId(c) + getCharId(klucz.charAt(indexKlucza))) % 26 + 65;
				System.out.print((char)(nowyZnak));
				
				indexKlucza++;
				if(indexKlucza == 12) {
					ilePowtorzen++;
				}
				indexKlucza %= klucz.length();
			}
		}
		System.out.println();
		System.out.println(ilePowtorzen);
	}
	void pp2() {
		String klucz = "ZLODZIEJCZASU";
		int indexKlucza = 0;
		
		for(char c : wiersz_szyfr.toCharArray()) {
			if(c == ' ') {
				System.out.print(' ');
			} else if(c == '.') {
				System.out.print('.');
			} else if(c == ','){
				System.out.print(',');
			} else {
				int staryZnak = (getCharId(c) - getCharId(klucz.charAt(indexKlucza)) + 26) % 26 + 65;
				System.out.print((char) staryZnak);
				indexKlucza++;
				indexKlucza %= klucz.length();
			}
		}
	}
	void pp3() {
		ArrayList<Integer> litera_ile = new ArrayList<Integer>();
		int ileLiter = wiersz_szyfr.replaceAll("\\.", "").replaceAll(",", "").replaceAll(" ", "").length();
		for(int i=65; i<=90; i++) {
			char c = (char)i;
			System.out.print("iloœæ " + c + ": ");
			int ilosc = wiersz_szyfr.length() - wiersz_szyfr.replaceAll(c+"", "").length();
			System.out.println(ilosc);
			litera_ile.add(ilosc);
		}
		
		double k0 = 0;
		for(int ile : litera_ile) {
			k0 += ile * (ile - 1);
		}
			
		k0 /= (ileLiter * (ileLiter - 1));
		double d = 0.0285 / (k0 - 0.0385);
		DecimalFormat df = new DecimalFormat("0.00");
		System.out.println("Oszacowana d³ugoœæ klucza: " + df.format(d));
		System.out.println("Rzeczywista d³ugoœæ klucza: " + "ZLODZIEJCZASU".length());
	}
}
