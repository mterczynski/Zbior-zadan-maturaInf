package Zadania;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Zadanie66 {

	Scanner plik_trojki;
	ArrayList<ArrayList<Long>> trojki = new ArrayList<ArrayList<Long>> ();
	
	public Zadanie66() {
		try {
			plik_trojki = new Scanner(new File("Files/66/trojki.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while(plik_trojki.hasNext()) {
			ArrayList<Long> trojka = new ArrayList<Long>();
			trojka.add(plik_trojki.nextLong());
			trojka.add(plik_trojki.nextLong());
			trojka.add(plik_trojki.nextLong());
			
			trojki.add(trojka);
		}
		
		pp1();
		pp2();
		pp3();
		pp4();
	}
	
	void pp1() {
		ArrayList<ArrayList<Long>> szukaneTrojki = new ArrayList<ArrayList<Long>> ();
		trojki.stream().forEach((trojka)->{
			String pierwsza = trojka.get(0) + "";
			String druga = trojka.get(1) + "";
			long trzecia = trojka.get(2);
			
			long suma = 0;
			
			for(int i=0; i<(pierwsza).length(); i++) {
				suma += Integer.parseInt(pierwsza.charAt(i) + "");
			}
			for(int i=0; i<(druga).length(); i++) {
				suma += Integer.parseInt(druga.charAt(i) + "");
			}
			
			if(trzecia == suma) {
				szukaneTrojki.add(trojka);
			}
		});
		
		System.out.println("66.1: " + szukaneTrojki);
	}
	
	void pp2() {
		ArrayList<ArrayList<Long>> szukaneTrojki = new ArrayList<ArrayList<Long>> ();
		trojki.stream().forEach((trojka)->{
			long pierwsza = trojka.get(0);
			long druga = trojka.get(1);
			long trzecia = trojka.get(2);
			
			if(trzecia != pierwsza * druga) {
				return;
			}
			
			if(new BigInteger(pierwsza+"").isProbablePrime(10000000) && new BigInteger(druga+"").isProbablePrime(10000000)) {
				szukaneTrojki.add(trojka);
			}
		});
		
		System.out.println("66.2: " + szukaneTrojki);
	}
	
	void pp3() {
		ArrayList<ArrayList<Long>> szukaneTrojki = new ArrayList<ArrayList<Long>> ();
		ArrayList<Integer> indexySzukanych = new ArrayList<Integer> ();
		
		for(int i=0; i<trojki.size(); i++){
			ArrayList<Long> trojka = new ArrayList<Long>(trojki.get(i));
			Collections.sort(trojka);
			long pierwsza = trojka.get(0);
			long druga = trojka.get(1);
			long trzecia = trojka.get(2);	
			
			if(pierwsza * pierwsza + druga * druga == trzecia * trzecia) {
				szukaneTrojki.add(trojki.get(i));
				indexySzukanych.add(i);
			}
		}
		
		int prevIndex = indexySzukanych.get(0);
		System.out.println("66.3: ");
		for(int i=1; i<szukaneTrojki.size(); i++) {
			int index = indexySzukanych.get(i);
			
			if(index == prevIndex + 1) {
				// mamy parê
				System.out.println("para: ");
				System.out.println(szukaneTrojki.get(i-1));
				System.out.println(szukaneTrojki.get(i));
			}
			
			prevIndex = index;
		}
	}
	
	void pp4() {
		int ileTrojkatow = 0;
		ArrayList<ArrayList<ArrayList<Long>>> ciagCiagowTrojkatow = new ArrayList<ArrayList<ArrayList<Long>>> ();
		ciagCiagowTrojkatow.add(new ArrayList<ArrayList<Long>>()); // dodajemy nowy ciagTrojkatow
		
		for(int i=0; i<trojki.size(); i++) {
			ArrayList<Long> trojkaCp = new ArrayList<Long>(trojki.get(i));
			Collections.sort(trojkaCp);
			if(trojkaCp.get(0) + trojkaCp.get(1) > trojkaCp.get(2)) {
				// mamy trojkat
				ArrayList<ArrayList<Long>> ciagTrojkatow = ciagCiagowTrojkatow.get(ciagCiagowTrojkatow.size()-1);
				ciagTrojkatow.add(trojki.get(i));
				ileTrojkatow++;
			} else {
				ciagCiagowTrojkatow.add(new ArrayList<ArrayList<Long>>());
			}
		}
		
		
		System.out.println("66.4: ");
		
		int maxLen = 0;
		ArrayList<ArrayList<Long>> najdluzszyCiag = new ArrayList<ArrayList<Long>>();
		for(ArrayList<ArrayList<Long>> ciagTrojkatow: ciagCiagowTrojkatow) {
			if(ciagTrojkatow.size() > maxLen) {
				maxLen = ciagTrojkatow.size();
			}
		}
		
		System.out.println("max d³ugoœæ: " + maxLen);
		System.out.println("ileTrojkatow: " + ileTrojkatow);
	}

}
