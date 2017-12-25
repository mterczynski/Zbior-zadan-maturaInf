package Zadania;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.Function;

public class Zadanie63 {
	
	Scanner plikCiagi;
	ArrayList<String> ciagi = new ArrayList<String>();		
	ArrayList<Integer> ciagiJakoLiczby = new ArrayList<Integer>();
	
	public Zadanie63() {
		
		try {
			plikCiagi = new Scanner(new File("Files/63/ciagi.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while(plikCiagi.hasNext()) {
			String next = plikCiagi.next();
			ciagi.add(plikCiagi.next());
			ciagiJakoLiczby.add(Integer.parseInt(next, 2));
		}
		
		pp1();
		pp2();
		pp3();
	}

	private void pp1() {
		ArrayList<String> ciagiDwucykliczne = new ArrayList<String>();	
		for(String ciag: ciagi) {
			if(ciag.length() % 2 == 0) {
				if(ciag.substring(0, ciag.length()/2).equals(ciag.substring(ciag.length()/2, ciag.length()))) {
					ciagiDwucykliczne.add(ciag);
				}
			}
		}
		
		System.out.println("63.1");
		System.out.println(ciagiDwucykliczne);
	}
	
	private void pp2() {
		int ileBezDwochJedynekObokSiebie = 0;
		for(String ciag: ciagi) {
			boolean czySpelniaWarunek = true;
			for(int i=0; i<ciag.length()-1; i++) {
				if(ciag.charAt(i) == '1' && ciag.charAt(i+1) == '1') {
					czySpelniaWarunek = false;
				}
			}
			if(czySpelniaWarunek) {
				ileBezDwochJedynekObokSiebie++;
			}
		}
		
		System.out.println("63.2");
		System.out.println(ileBezDwochJedynekObokSiebie);
	}

	private void pp3() {
		Function<Integer,ArrayList<Integer>> getPrimeFacotrs = (number) ->{
			ArrayList<Integer> primeFactors = new ArrayList<Integer>();
			for(int i=2; i<=number; i++) {
				if(number % i == 0) {
					primeFactors.add(i);
					number /= i;
					i=1; // will be 2 after continue
					continue;
				}
			}
			return primeFactors;
		};
		
		ArrayList<Integer> halfPrimes = new ArrayList<Integer>();
		
		for(int liczba : ciagiJakoLiczby) {
			ArrayList<Integer> primeFactors = getPrimeFacotrs.apply(liczba);
			if(primeFactors.size() == 2) {
				halfPrimes.add(liczba);
			}
		}
		
		System.out.println("63.3:");
		System.out.println("Ilość liczb półpierwszych: " + halfPrimes.size());
		Collections.sort(halfPrimes);
		System.out.println("Najmniejsza liczba półpierwsza: " + halfPrimes.get(0));
		System.out.println("Najwi�ksza liczba półpierwsza: " + halfPrimes.get(halfPrimes.size()-1));
	}
}
