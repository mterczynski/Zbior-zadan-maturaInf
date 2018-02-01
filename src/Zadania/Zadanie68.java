package Zadania;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

class Para {
	public Para(String first, String second) {
		this.first = first;
		this.second = second;
	}
	
	String first;
	String second;
}

public class Zadanie68 {
	Scanner plik_napisy;
	
	ArrayList<Para> pary = new ArrayList<Para>();
	
	public Zadanie68() {
		try {
			plik_napisy = new Scanner(new File("Files/68/dane_napisy.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while(plik_napisy.hasNext()) {
			pary.add(new Para(plik_napisy.next(), plik_napisy.next()));
		}
		
		pp1();
		pp2();
		pp3();
	}
	
	void pp1() {
		int ilePar = 0;
		for(Para para : pary) {
			if(para.first.replaceAll(para.first.charAt(0)+"", "").length() > 0) {
				continue;
			}
			if(para.second.replaceAll(para.second.charAt(0)+"", "").length() > 0) {
				continue;
			}
			if(!para.first.equals(para.second)) {
				continue;
			}
			ilePar++;
		}
		
		System.out.println("68.1: " + ilePar);
	}
	
	void pp2() {
		int ilePar = 0;
		for(Para para : pary) {
			if(para.first.length() != para.second.length()) {
				continue;
			}
			
			HashMap<String, Integer> znak_ileWPierwszym = new HashMap<String, Integer>();
			HashMap<String, Integer> znak_ileWDrugim = new HashMap<String, Integer>();
			
			// pobranie ilosci znakow:
			
			for(int i=0; i<para.first.length(); i++) {
				if(znak_ileWPierwszym.get(para.first.charAt(i)+"") == null) {
					znak_ileWPierwszym.put(para.first.charAt(i)+"", 1); 
				} else {
					znak_ileWPierwszym.put(para.first.charAt(i)+"", znak_ileWPierwszym.get(para.first.charAt(i)+"") + 1); 
				}
				
				if(znak_ileWDrugim.get(para.second.charAt(i)+"") == null) {
					znak_ileWDrugim.put(para.second.charAt(i)+"", 1); 
				} else {
					znak_ileWDrugim.put(para.second.charAt(i)+"", znak_ileWDrugim.get(para.second.charAt(i)+"") + 1); 
				}
			}
			
			boolean czyAnagram = true;
			
			for(Entry entry : znak_ileWPierwszym.entrySet()) {
				if(entry.getValue() != znak_ileWDrugim.get(entry.getKey())) {
					czyAnagram = false;
					break;
				}
			}
			
			if(czyAnagram) {
				ilePar++;
			}
		}
		
		System.out.println("68.2: " + ilePar);
	}
	
	void pp3() {
		HashMap<String, Integer> anagram_ile = new HashMap<String, Integer>();
		
		for(Para para : pary) {
			TreeMap<String, Integer> znak_ileWPierwszym = new TreeMap<String, Integer>();
			TreeMap<String, Integer> znak_ileWDrugim = new TreeMap<String, Integer>();
			
			// pobranie ilosci znakow:
			
			for(int i=0; i<para.first.length(); i++) {
				if(znak_ileWPierwszym.get(para.first.charAt(i)+"") == null) {
					znak_ileWPierwszym.put(para.first.charAt(i)+"", 1); 
				} else {
					znak_ileWPierwszym.put(para.first.charAt(i)+"", znak_ileWPierwszym.get(para.first.charAt(i)+"") + 1); 
				}
			}
			
			for(int i=0; i<para.second.length(); i++) {
				if(znak_ileWDrugim.get(para.second.charAt(i)+"") == null) {
					znak_ileWDrugim.put(para.second.charAt(i)+"", 1); 
				} else {
					znak_ileWDrugim.put(para.second.charAt(i)+"", znak_ileWDrugim.get(para.second.charAt(i)+"") + 1); 
				}
			}
			
			String anagram1 = "";
			String anagram2 = "";
			
			for(Entry litera: znak_ileWPierwszym.entrySet()) {
				for(int i=0; i<(int)litera.getValue(); i++) {
					anagram1 += litera.getKey();
				}
			}
			
			for(Entry litera: znak_ileWDrugim.entrySet()) {
				for(int i=0; i<(int)litera.getValue(); i++) {
					anagram2 += litera.getKey();
				}
			}
			
			if(!anagram_ile.containsKey(anagram1)) {
				anagram_ile.put(anagram1, 0);
			}
			
			if(!anagram_ile.containsKey(anagram2)) {
				anagram_ile.put(anagram2, 0);
			}
			
			anagram_ile.put(anagram1, anagram_ile.get(anagram1) + 1);
			anagram_ile.put(anagram2, anagram_ile.get(anagram2) + 1);	
		}
		
		int maxVal = 0;
		
		for(Entry entry : anagram_ile.entrySet()) {
			maxVal = Math.max(maxVal, (int)entry.getValue());
		}	
		
		System.out.println("68.3: " + maxVal);
	}
}
