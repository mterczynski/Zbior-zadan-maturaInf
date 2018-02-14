package Zadania;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class Zadanie74 {

	ArrayList<String> hasla = new ArrayList<String>();
	
	public Zadanie74() {
		try {
			Scanner plik_hasla = new Scanner(new File("Files/74/hasla.txt"));
			while(plik_hasla.hasNext()) {
				hasla.add(plik_hasla.next());
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
		int ileNumer = 0;
		for(String haslo : hasla) {
			if(haslo.replaceAll("[A-Z]", "").replaceAll("[a-z]","").length() == haslo.length()) {
				ileNumer++;
			}
		}
		System.out.println("74.1: " + ileNumer);
	}
	
	void pp2() {
		TreeMap<String, Integer> haslo_ile = new TreeMap<String, Integer>();
		for(String haslo : hasla) {
			if(haslo_ile.containsKey(haslo)) {
				haslo_ile.put(haslo, haslo_ile.get(haslo) + 1);
			} else {
				haslo_ile.put(haslo, 1);
			}
		}
		System.out.println();
		System.out.println("74.2: ");
		for(Entry<String, Integer> entry : haslo_ile.entrySet()) {
			if(entry.getValue() >= 2) {
				System.out.println(entry.getKey());
			}
		}
	}
	
	void pp3() {
		int ileHasel = 0;
		for(String haslo : hasla) {
			ArrayList<Integer> znaki = new ArrayList<Integer>();
			for(int i=0; i<haslo.length(); i++) {
				znaki.add((int)(haslo.charAt(i)));
			}
			for(int i=3; i<haslo.length(); i++) {
				ArrayList<Integer> grupa4 = new ArrayList<Integer>();
				grupa4.add(znaki.get(i));
				grupa4.add(znaki.get(i-1));
				grupa4.add(znaki.get(i-2));
				grupa4.add(znaki.get(i-3));
				Collections.sort(grupa4);
				if(grupa4.get(0) + 1 == grupa4.get(1) && grupa4.get(1) + 1 == grupa4.get(2) && grupa4.get(2) + 1 == grupa4.get(3))
				{
					ileHasel++;
					break;
				}
			}	
		}
		System.out.println("74.3: " + ileHasel);
	}
	
	void pp4() {
		int ileSpelnia = 0;
		for(String haslo : hasla) {
			boolean numer = haslo.length() > haslo.replaceAll("[0-9]", "").length();
			boolean mala = haslo.length() > haslo.replaceAll("[a-z]", "").length();
			boolean duza = haslo.length() > haslo.replaceAll("[A-Z]", "").length();
			if(numer && mala && duza) {
				ileSpelnia++;
			}
		}
		System.out.println("74.4: " + ileSpelnia);
	}

}
