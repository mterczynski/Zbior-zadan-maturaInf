package Zadania;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Zadanie80 {

	ArrayList<Integer> dane = new ArrayList<Integer>();
	
	public Zadanie80() {
		try {
			Scanner sc = new Scanner(new File("Files/80/dane_trojkaty.txt"));
			while(sc.hasNext()) {
				dane.add(sc.nextInt());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		pp1();
		pp2();
		pp3();
	}

	void pp1() {
		System.out.println("80.1: ");
		for(int i=2; i<dane.size(); i++) {
			ArrayList<Integer> boki = new ArrayList<Integer>();
			boki.add(dane.get(i-2));
			boki.add(dane.get(i-1));
			boki.add(dane.get(i));	
			Collections.sort(boki);
			
			if(Math.hypot(boki.get(0), boki.get(1)) == (double)boki.get(2)) {
				System.out.println("["+dane.get(i-2)+", "+dane.get(i-1)+", "+dane.get(i)+"]");
			}
		}
	}
	void pp2() {
		int maxObw = 0;
		for(int i=0; i<500; i++) {
			for(int j=i+1; j<500; j++) {
				for(int k=j+1; k<500; k++) {
					ArrayList<Integer> boki = new ArrayList<Integer>();
					boki.add(dane.get(i));
					boki.add(dane.get(j));
					boki.add(dane.get(k));
					Collections.sort(boki);
					if(boki.get(0) + boki.get(1) > boki.get(2)) {
						maxObw = Math.max(maxObw, boki.get(0) + boki.get(1) + boki.get(2));
					}
				}
			}
		}
		
		System.out.println("80.2: " + maxObw);
	}
	void pp3() {
		HashSet<ArrayList<Integer>> trojkaty = new HashSet<ArrayList<Integer>>();
		int ileNieprzystajacych = 0;
		for(int i=0; i<500; i++) {
			for(int j=i+1; j<500; j++) {
				for(int k=j+1; k<500; k++) {
					ArrayList<Integer> boki = new ArrayList<Integer>();
					boki.add(dane.get(i));
					boki.add(dane.get(j));
					boki.add(dane.get(k));
					Collections.sort(boki);
					if(boki.get(0) + boki.get(1) > boki.get(2)) {
						trojkaty.add(boki);
					}
				}
			}
		}
		System.out.println("80.3: " + trojkaty.size());
	}
}
