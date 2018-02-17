package Zadania;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Zadanie86 {

	ArrayList<String> dane = new ArrayList<String>();
	ArrayList<String> nazwyKomitetow = new ArrayList<String>();
	long[][] okreg_glosyKomitetow = new long[20][5];
	
	public Zadanie86() {
		try {
			Scanner plik_dane = new Scanner(new File("Files/86/dane_wybory.txt"));
			while(plik_dane.hasNext()) {
				dane.add(plik_dane.nextLine());
			}
			
			int lineIndex = 0;
			for(String linia : dane) {
				String nazwaKomitetu = linia.split(" ")[0];
				nazwyKomitetow.add(nazwaKomitetu);
				okreg_glosyKomitetow[lineIndex][0] = Long.parseLong(linia.split(" ")[1]);
				okreg_glosyKomitetow[lineIndex][1] = Long.parseLong(linia.split(" ")[2]);
				okreg_glosyKomitetow[lineIndex][2] = Long.parseLong(linia.split(" ")[3]);
				okreg_glosyKomitetow[lineIndex][3] = Long.parseLong(linia.split(" ")[4]);
				okreg_glosyKomitetow[lineIndex][4] = Long.parseLong(linia.split(" ")[5]);
				lineIndex++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		pp1();
		pp2();
		pp3();
		pp4a();
		pp4b();
		pp5();
	}

	void pp1() {
	}
	void pp2() {
		ArrayList<Double> k1Procenty = new ArrayList<Double>();
		ArrayList<Double> k2Procenty = new ArrayList<Double>();
		ArrayList<Double> k3Procenty = new ArrayList<Double>();
		ArrayList<Double> k4Procenty = new ArrayList<Double>();
		ArrayList<Double> k5Procenty = new ArrayList<Double>();
		
		for(String linia : dane) {
			long k1 = new Long(linia.split(" ")[1]);
			long k2 = new Long(linia.split(" ")[2]);
			long k3 = new Long(linia.split(" ")[3]);
			long k4 = new Long(linia.split(" ")[4]);
			long k5 = new Long(linia.split(" ")[5]);
			long total = k1+k2+k3+k4+k5;
			k1Procenty.add((double)k1/total);
			k2Procenty.add((double)k2/total);
			k3Procenty.add((double)k3/total);
			k4Procenty.add((double)k4/total);
			k5Procenty.add((double)k5/total);
		}
		
		String matecznik_1 = "";
		String matecznik_2 = "";
		String matecznik_3 = "";
		String matecznik_4 = "";
		String matecznik_5 = "";
		
		double max1 = 0;
		double max2 = 0;
		double max3 = 0;
		double max4 = 0;
		double max5 = 0;
		
		for(int i=0; i<k1Procenty.size(); i++) {
			if(k1Procenty.get(i) > max1) {
				max1 = k1Procenty.get(i);
				matecznik_1 = nazwyKomitetow.get(i);
			}
			if(k2Procenty.get(i) > max2) {
				max2 = k2Procenty.get(i);
				matecznik_2 = nazwyKomitetow.get(i);
			}
			if(k3Procenty.get(i) > max3) {
				max3 = k3Procenty.get(i);
				matecznik_3 = nazwyKomitetow.get(i);
			}
			if(k4Procenty.get(i) > max4) {
				max4 = k4Procenty.get(i);
				matecznik_4 = nazwyKomitetow.get(i);
			}
			if(k5Procenty.get(i) > max5) {
				max5 = k5Procenty.get(i);
				matecznik_5 = nazwyKomitetow.get(i);
			}
		}
		
		System.out.println("86.2: ");
		System.out.println("Matecznik K1: " + matecznik_1);
		System.out.println("Matecznik K2: " + matecznik_2);
		System.out.println("Matecznik K3: " + matecznik_3);
		System.out.println("Matecznik K4: " + matecznik_4);
		System.out.println("Matecznik K5: " + matecznik_5);
	}
	void pp3() {
	
		ArrayList<Integer> komitet_max = new ArrayList<Integer>();
		for(int i=0; i<5; i++) {
			komitet_max.add(0);
		}
		
		for(String linia : dane) {
			ArrayList<Integer> komitet_ileMandatow = new ArrayList<Integer>();
			for(int i=0; i<5; i++) {
				komitet_ileMandatow.add(0);
			}
			long glosy1 = new Long(linia.split(" ")[1]);
			long glosy2 = new Long(linia.split(" ")[2]);
			long glosy3 = new Long(linia.split(" ")[3]);
			long glosy4 = new Long(linia.split(" ")[4]);
			long glosy5 = new Long(linia.split(" ")[5]);
			long total = glosy1+glosy2+glosy3+glosy4+glosy5;
			int pozostalychMandatow = 20;
			while(pozostalychMandatow>0) {
				ArrayList<Double> komitet_wspolczynnik = new ArrayList<Double>(); 
				komitet_wspolczynnik.add((double)glosy1 / (2*komitet_ileMandatow.get(0) + 1));
				komitet_wspolczynnik.add((double)glosy2 / (2*komitet_ileMandatow.get(1) + 1));
				komitet_wspolczynnik.add((double)glosy3 / (2*komitet_ileMandatow.get(2) + 1));
				komitet_wspolczynnik.add((double)glosy4 / (2*komitet_ileMandatow.get(3) + 1));
				komitet_wspolczynnik.add((double)glosy5 / (2*komitet_ileMandatow.get(4) + 1));
				double maxWspolczynnik = Collections.max(komitet_wspolczynnik);
				int index = komitet_wspolczynnik.indexOf(maxWspolczynnik);
				komitet_ileMandatow.set(index, komitet_ileMandatow.get(index)+1);
				
				pozostalychMandatow--;
			}	
			for(int i=0; i<5; i++) {
				komitet_max.set(i, Math.max(komitet_max.get(i), komitet_ileMandatow.get(i)));
			}
		}
		
		System.out.println("86.3 ");
		System.out.println(komitet_max);
	}
	void pp4a() {
		ArrayList<Integer> komitet_ileGlosow = new ArrayList<Integer>();
		for(int i=0; i<5; i++) {
			komitet_ileGlosow.add(0);
		}
		
		for(String linia : dane) {
			ArrayList<Integer> komitet_ileMandatow = new ArrayList<Integer>();
			for(int i=0; i<5; i++) {
				komitet_ileMandatow.add(0);
			}
			long glosy1 = new Long(linia.split(" ")[1]);
			long glosy2 = new Long(linia.split(" ")[2]);
			long glosy3 = new Long(linia.split(" ")[3]);
			long glosy4 = new Long(linia.split(" ")[4]);
			long glosy5 = new Long(linia.split(" ")[5]);
			long total = glosy1+glosy2+glosy3+glosy4+glosy5;
			int pozostalychMandatow = 20;
			while(pozostalychMandatow>0) {
				ArrayList<Double> komitet_wspolczynnik = new ArrayList<Double>(); 
				komitet_wspolczynnik.add((double)glosy1 / (2*komitet_ileMandatow.get(0) + 1));
				komitet_wspolczynnik.add((double)glosy2 / (2*komitet_ileMandatow.get(1) + 1));
				komitet_wspolczynnik.add((double)glosy3 / (2*komitet_ileMandatow.get(2) + 1));
				komitet_wspolczynnik.add((double)glosy4 / (2*komitet_ileMandatow.get(3) + 1));
				komitet_wspolczynnik.add((double)glosy5 / (2*komitet_ileMandatow.get(4) + 1));
				double maxWspolczynnik = Collections.max(komitet_wspolczynnik);
				int index = komitet_wspolczynnik.indexOf(maxWspolczynnik);
				komitet_ileMandatow.set(index, komitet_ileMandatow.get(index)+1);
				
				pozostalychMandatow--;
			}	
			for(int i=0; i<5; i++) {
				komitet_ileGlosow.set(i, komitet_ileGlosow.get(i)+komitet_ileMandatow.get(i));
			}
			
		}
		
		System.out.println("86.4 a): ");
		System.out.println(komitet_ileGlosow);
	}
	void pp4b() {
		ArrayList<ArrayList<Long>> okreg_komitet_glosy = new ArrayList<ArrayList<Long>>();
		for(int i=0; i<4; i++) {
			ArrayList<Long> komitet_glosy = new ArrayList<Long>();
			for(int j=0; j<5; j++) {
				komitet_glosy.add(0l);
			}
			okreg_komitet_glosy.add(komitet_glosy);
		}
		
		for(String linia: dane) {
			int indeksRegionu = linia.charAt(0) - 65;
			long glosy1 = new Long(linia.split(" ")[1]);
			long glosy2 = new Long(linia.split(" ")[2]);
			long glosy3 = new Long(linia.split(" ")[3]);
			long glosy4 = new Long(linia.split(" ")[4]);
			long glosy5 = new Long(linia.split(" ")[5]);
			
			okreg_komitet_glosy.get(indeksRegionu).set(0, glosy1 + okreg_komitet_glosy.get(indeksRegionu).get(0));
			okreg_komitet_glosy.get(indeksRegionu).set(1, glosy2 + okreg_komitet_glosy.get(indeksRegionu).get(1));
			okreg_komitet_glosy.get(indeksRegionu).set(2, glosy3 + okreg_komitet_glosy.get(indeksRegionu).get(2));
			okreg_komitet_glosy.get(indeksRegionu).set(3, glosy4 + okreg_komitet_glosy.get(indeksRegionu).get(3));
			okreg_komitet_glosy.get(indeksRegionu).set(4, glosy5 + okreg_komitet_glosy.get(indeksRegionu).get(4));
		}
		
		ArrayList<Integer> komitet_glosy = new ArrayList<Integer>();
		for(int i=0; i<5; i++) {
			komitet_glosy.add(0);
		}
		
		// zliczenie mandatów dla ka¿dego regionu:
		for(int i=0; i<4; i++) {
			ArrayList<Long> glosy = okreg_komitet_glosy.get(i);
			ArrayList<Integer> komitet_ileMandatowWTymOkregu = new ArrayList<Integer>();
			for(int j=0; j<5; j++) {
				komitet_ileMandatowWTymOkregu.add(0);
			}
			
			int pozostalychMandatow = 100;
			while(pozostalychMandatow>0) {
				ArrayList<Double> komitet_wspolczynnik = new ArrayList<Double>(); 
				komitet_wspolczynnik.add((double)glosy.get(0) / (2*komitet_ileMandatowWTymOkregu.get(0) + 1));
				komitet_wspolczynnik.add((double)glosy.get(1) / (2*komitet_ileMandatowWTymOkregu.get(1) + 1));
				komitet_wspolczynnik.add((double)glosy.get(2) / (2*komitet_ileMandatowWTymOkregu.get(2) + 1));
				komitet_wspolczynnik.add((double)glosy.get(3) / (2*komitet_ileMandatowWTymOkregu.get(3) + 1));
				komitet_wspolczynnik.add((double)glosy.get(4) / (2*komitet_ileMandatowWTymOkregu.get(4) + 1));
				double maxWspolczynnik = Collections.max(komitet_wspolczynnik);
				int index = komitet_wspolczynnik.indexOf(maxWspolczynnik);
				komitet_ileMandatowWTymOkregu.set(index, komitet_ileMandatowWTymOkregu.get(index)+1);
				
				pozostalychMandatow--;
			}	
			
			for(int j=0; j<5; j++) {
				komitet_glosy.set(j, komitet_glosy.get(j) + komitet_ileMandatowWTymOkregu.get(j));
			}
		}
		
		System.out.println("88.4 b): ");
		System.out.println(komitet_glosy);
	}
	void pp5() {}
}
