package Zadania;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Zadanie58 {
	Scanner plik_dane1;
	Scanner plik_dane2;
	Scanner plik_dane3;
	
	ArrayList<Integer> temperatury1 = new ArrayList<Integer>();
	ArrayList<Integer> temperatury2 = new ArrayList<Integer>();
	ArrayList<Integer> temperatury3 = new ArrayList<Integer>();
	
	ArrayList<Integer> czasy1 = new ArrayList<Integer>();
	ArrayList<Integer> czasy2 = new ArrayList<Integer>();
	ArrayList<Integer> czasy3 = new ArrayList<Integer>();
	
	public Zadanie58() {
		// odczytaj dane z plików:
		try {
			plik_dane1 = new Scanner(new File("Files/58/dane_systemy1.txt"));
			plik_dane2 = new Scanner(new File("Files/58/dane_systemy2.txt"));
			plik_dane3 = new Scanner(new File("Files/58/dane_systemy3.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while(plik_dane1.hasNext()) {
			int czas = Integer.parseInt(plik_dane1.next(), 2);
			int temperatura = Integer.parseInt(plik_dane1.next(), 2);
			temperatury1.add(temperatura);
			czasy1.add(czas);
		}
		while(plik_dane2.hasNext()) {
			int czas = Integer.parseInt(plik_dane2.next(), 4);
			int temperatura = Integer.parseInt(plik_dane2.next(), 4);
			temperatury2.add(temperatura);
			czasy2.add(czas);
		}
		while(plik_dane3.hasNext()) {
			int czas = Integer.parseInt(plik_dane3.next(), 8);
			int temperatura = Integer.parseInt(plik_dane3.next(), 8);
			temperatury3.add(temperatura);
			czasy3.add(czas);
		}

		// uruchom podzadania:
		pp1();
		pp2();
		pp3();
		pp4();
	}
	

	void pp1() {
		ArrayList<Integer> temperatury1Cp = new ArrayList<Integer>(temperatury1);
		ArrayList<Integer> temperatury2Cp = new ArrayList<Integer>(temperatury2);
		ArrayList<Integer> temperatury3Cp = new ArrayList<Integer>(temperatury3);
		
		Collections.sort(temperatury1Cp);
		Collections.sort(temperatury2Cp);
		Collections.sort(temperatury3Cp);
		
		System.out.println("58.1: ");
		System.out.println("Najni¿szy wynik stacji 1: " + Integer.toString(temperatury1Cp.get(0), 2));
		System.out.println("Najni¿szy wynik stacji 2: " + Integer.toString(temperatury2Cp.get(0), 2));
		System.out.println("Najni¿szy wynik stacji 3: " + Integer.toString(temperatury3Cp.get(0), 2));
	};
	void pp2() {
		int ileBlednychWeWszystkich3 = 0;
		for(int i=0; i<czasy1.size(); i++) {
			if(czasy1.get(i) % 12 !=0 && czasy2.get(i) % 12 !=0 && czasy3.get(i) % 12 !=0) {
				ileBlednychWeWszystkich3++;
			}
		}
		
		System.out.println("58.2: ");
		System.out.println("Iloœæ b³êdnych pomiarów we wszystkich 3 stacjach w tym samym czasie: " + ileBlednychWeWszystkich3);
	};
	void pp3() {
		int rekord1 = -1000;
		int rekord2 = -1000;
		int rekord3 = -1000;
		int ileDniRekordowych = 0;
		for(int i=0; i<temperatury1.size(); i++) {
			if(temperatury1.get(i) > rekord1 || temperatury2.get(i) > rekord2 || temperatury3.get(i) > rekord3) {
				ileDniRekordowych++;
			}
			if(temperatury1.get(i) > rekord1) {
				rekord1 = temperatury1.get(i);
			}
			if(temperatury2.get(i) > rekord2) {
				rekord2 = temperatury2.get(i);
			}
			if(temperatury3.get(i) > rekord3) {
				rekord3 = temperatury3.get(i);
			}
		}
		System.out.println("58.3: ");
		System.out.println("Iloœæ dni rekordowych: " + ileDniRekordowych);
	};
	void pp4() {
		int maxSkok = 0;	
		
		for(int i=0; i<temperatury1.size(); i++) {
			for(int j=i+1; j<temperatury1.size(); j++) {
				int kwadrat = (int)Math.pow(temperatury1.get(i) - temperatury1.get(j), 2);
				int roznica = j - i;
				double skokNiezaokroglony = (double)kwadrat / (double)roznica;
				int skok = (int) Math.ceil(skokNiezaokroglony);
				//System.out.println(skok);
				if(skok > maxSkok) {
					maxSkok = skok;
				}
			}
		}
		
		System.out.println("58.4: ");
		System.out.println("Zadanie 58.4: Max. skok temperatury to " + maxSkok);
	};
}
