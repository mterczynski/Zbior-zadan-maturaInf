package Zadania;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Zadanie61 {
	
	Scanner plikCiagi;
	Scanner plikBledne;
	
	ArrayList<ArrayList<Integer>> ciagi = new ArrayList<ArrayList<Integer>>();
	ArrayList<ArrayList<Integer>> bledneCiagi = new ArrayList<ArrayList<Integer>>();
	
	public Zadanie61() {
		
		try {
			plikCiagi = new Scanner(new File("Files/61/ciagi.txt"));
			plikBledne = new Scanner(new File("Files/61/bledne.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		while(plikCiagi.hasNext()) {
			int dlugoscCiagu = plikCiagi.nextInt();
			ArrayList<Integer> aktualnyCiag = new ArrayList<Integer>();
			
			for(int i=0; i<dlugoscCiagu; i++) {
				aktualnyCiag.add(plikCiagi.nextInt());
			}
			ciagi.add(aktualnyCiag);
		}
		while(plikBledne.hasNext()) {
			int dlugoscCiagu = plikBledne.nextInt();
			ArrayList<Integer> aktualnyCiag = new ArrayList<Integer>();
			
			for(int i=0; i<dlugoscCiagu; i++) {
				aktualnyCiag.add(plikBledne.nextInt());
			}
			bledneCiagi.add(aktualnyCiag);
		}
		
		pp1();
		pp2();
		pp3();
			
	}
	
	private void pp1() {
		ArrayList<ArrayList<Integer>> ciagiArytmetyczne = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0; i<ciagi.size(); i++) {
			ArrayList<Integer> ciag = ciagi.get(i);
			int roznica = ciag.get(1) - ciag.get(0);
			boolean czyArytmetyczny = true;
			for(int j=2; j<ciag.size(); j++) {
				if(ciag.get(j) - ciag.get(j-1) != roznica) {
					czyArytmetyczny = false;
					break;
				}
			}
			if(czyArytmetyczny) {
				ciagiArytmetyczne.add(ciag);
			}
		}
		
		int maxRoznica = -1;
		
		for(int i=0; i<ciagiArytmetyczne.size(); i++) {
			int roznica = ciagiArytmetyczne.get(i).get(1) - ciagiArytmetyczne.get(i).get(0);
			if(roznica > maxRoznica) {
				maxRoznica = roznica;
			}
		}
		
		System.out.println("61.1:");
		System.out.println("Ilosc ciagow arytmetycznych: " + ciagiArytmetyczne.size());
		System.out.println("Maksymalna roznica ciagu arytmetycznego: " + maxRoznica);
		System.out.flush();
	}
	private void pp2() {
		System.out.println();
		System.out.println("61.2:");
		
		for(ArrayList<Integer> ciag : ciagi) {
			int maxCube = -1; // -1 oznacza brak szescianu liczby naturalnej w ciagu
			for(int liczba : ciag) {
				int cbrtAndBack = (int)Math.pow(((int)Math.cbrt(liczba)), 3);
				if(cbrtAndBack == liczba) {
					maxCube = liczba;
				};
			}
			if(maxCube >= 0) {
				System.out.println(maxCube);
			}
		}
	}
	private void pp3() {
		System.out.println("61.3: ");
		for(int i=0; i<bledneCiagi.size(); i++) {
			ArrayList<Integer> ciag = bledneCiagi.get(i);
			ArrayList<Integer> roznice = new ArrayList<Integer>();
			for(int j=1; j<ciag.size(); j++) {
				int roznica = ciag.get(j) - ciag.get(j-1);
				roznice.add(roznica);
			}
			HashMap<Integer, Integer> roznica_count = new HashMap<Integer, Integer>();
			for(int roznica : roznice) {
				if(roznica_count.get(roznica) == null) {
					roznica_count.put(roznica, 1);
				} else {
					roznica_count.put(roznica, roznica_count.get(roznica)+1);
				}
			}
			
			Integer blednaRoznica1 = null; 
			Integer blednaRoznica2 = null;
			
			for(Map.Entry<Integer, Integer>  entry: roznica_count.entrySet()) {
				int count = entry.getValue();
				if(count == 1) {
					if(blednaRoznica1 == null) {
						blednaRoznica1 = entry.getKey();
					} else {
						blednaRoznica2 = entry.getKey();
					}
				} 
			}
			
			int indexBlednej1 = roznice.indexOf(blednaRoznica1);
			
			if(blednaRoznica2 == null) { // => bledny wyraz znajduje sie na poczatku lub koncu ciagu
				if(indexBlednej1 == 0) {
					System.out.println(ciag.get(0));
				} else {
					System.out.println(ciag.get(ciag.size()-1));
				}
			} else {
				int indexBlednej2 = roznice.indexOf(blednaRoznica2);
				if(indexBlednej2 > indexBlednej1) {
					System.out.println(ciag.get(indexBlednej2));
				} else {
					System.out.println(ciag.get(indexBlednej1));
				}
			}				
		}
	}	
}
