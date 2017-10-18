import java.awt.Point;
<<<<<<< HEAD
<<<<<<< HEAD
import java.io.File;
import java.io.PrintWriter;
=======
import java.io.BufferedReader;
import java.io.File;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
>>>>>>> 796735776b7b0b5938bc970d14f609453df925ba
=======
import java.io.BufferedReader;
import java.io.File;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
>>>>>>> 796735776b7b0b5938bc970d14f609453df925ba
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
<<<<<<< HEAD
<<<<<<< HEAD
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.function.BiFunction;
import java.util.function.Consumer;
=======
import java.util.Random;
import java.util.Scanner;
>>>>>>> 796735776b7b0b5938bc970d14f609453df925ba
=======
import java.util.Random;
import java.util.Scanner;
>>>>>>> 796735776b7b0b5938bc970d14f609453df925ba
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {

	private static void zadanie58() throws Exception {
		
		Scanner plik_dane1 = new Scanner(new File("Files/58/dane_systemy1.txt"));
		Scanner plik_dane2 = new Scanner(new File("Files/58/dane_systemy2.txt"));
		Scanner plik_dane3 = new Scanner(new File("Files/58/dane_systemy3.txt"));
		
		ArrayList<Integer> temperatury1 = new ArrayList<Integer>();
		ArrayList<Integer> temperatury2 = new ArrayList<Integer>();
		ArrayList<Integer> temperatury3 = new ArrayList<Integer>();
		
		ArrayList<Integer> czasy1 = new ArrayList<Integer>();
		ArrayList<Integer> czasy2 = new ArrayList<Integer>();
		ArrayList<Integer> czasy3 = new ArrayList<Integer>();
		
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
		
		double d = 1d/60d;
		int a = (int) (300 * d);
		int b = (int) (-300 * d);
		
		
		System.out.println(d);
		System.out.println(a);
		System.out.println(b);
		
		Runnable pp1 = () -> {
			ArrayList<Integer> temperatury1Cp = new ArrayList<Integer>(temperatury1);
			ArrayList<Integer> temperatury2Cp = new ArrayList<Integer>(temperatury2);
			ArrayList<Integer> temperatury3Cp = new ArrayList<Integer>(temperatury3);
			
			Collections.sort(temperatury1Cp);
			Collections.sort(temperatury2Cp);
			Collections.sort(temperatury3Cp);
			
			System.out.println("NajniÅ¼szy wynik stacji 1: " + Integer.toString(temperatury1Cp.get(0), 2));
			System.out.println("NajniÅ¼szy wynik stacji 2: " + Integer.toString(temperatury2Cp.get(0), 2));
			System.out.println("NajniÅ¼szy wynik stacji 3: " + Integer.toString(temperatury3Cp.get(0), 2));
		};
		Runnable pp2 = () -> {
			int ileBlednychWeWszystkich3 = 0;
			for(int i=0; i<czasy1.size(); i++) {
				if(czasy1.get(i) % 12 !=0 && czasy2.get(i) % 12 !=0 && czasy3.get(i) % 12 !=0) {
					ileBlednychWeWszystkich3++;
				}
			}
			System.out.println("IloÅ›Ä‡ bÅ‚Ä™dnych pomiarÃ³w we wszystkich 3 stacjach w tym samym czasie: " + ileBlednychWeWszystkich3);
		};
		Runnable pp3 = () -> {
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
			System.out.println("IloÅ›Ä‡ dni rekordowych: " + ileDniRekordowych);
		};
		Runnable pp4 = () -> {
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
			
			System.out.println("Zadanie 58.4: Max. skok temperatury to " + maxSkok);
		};
		
		pp1.run();
		pp2.run();
		pp3.run();
		pp4.run();
		
	}
	private static void zadanie59() throws Exception {
		
		Scanner plikLiczby = new Scanner(new File("Files/59/liczby.txt"));
		
		PrintWriter printWriter = new PrintWriter(new File("rozwiazania/59.txt"));
		
		ArrayList<Integer> liczby = new ArrayList<Integer>();
		
		while(plikLiczby.hasNext()) {
			liczby.add(plikLiczby.nextInt());
		}
		
		Runnable pp1 = () ->{
			int ileLiczbSpelniajacychWarunki = 0;
			
			for(Integer liczba : liczby) {
				int liczbaCp = liczba;
				ArrayList<Integer> czynnikiPierwsze = new ArrayList<Integer>();
				
				for(int i=2; i<=Math.round(Math.sqrt(liczba)); i++) {
					if(liczbaCp % i == 0) {
						czynnikiPierwsze.add(i);
						liczbaCp /= i;
						i=1; // will be 2 after i++
					}
				}
				if(liczbaCp>1) {
					czynnikiPierwsze.add(liczbaCp);
				}	
				
				HashSet<Integer> rozneCzynnikiPierwsze = new HashSet<Integer>(czynnikiPierwsze);
				
				boolean czyMaParzystyDzielnik = false;
				for (Iterator<Integer> i = rozneCzynnikiPierwsze.iterator(); i.hasNext();) {
				    Integer element = i.next();
				    if (element % 2 == 0) {
				        // liczba nie spelnia warunku
				    	czyMaParzystyDzielnik = true;
				    	break;
				    }
				}
				
				if(rozneCzynnikiPierwsze.size() == 3 && !czyMaParzystyDzielnik) {
					ileLiczbSpelniajacychWarunki++;
				}
			}
			printWriter.println("podpunkt 1:");
			printWriter.println("Iloï¿½ï¿½ liczb majï¿½cych dokï¿½adnie 3 rï¿½ne nieparzyste czynniki pierwsze: " + ileLiczbSpelniajacychWarunki);
			printWriter.flush();
		};
		Runnable pp2 = () -> {
			int ilePalindromow = 0;
			for(int i=0; i<liczby.size(); i++) {
				int liczba = liczby.get(i);
				int odwrocona = Integer.parseInt(new StringBuilder(liczby.get(i).toString()).reverse().toString());
				String suma = String.valueOf(odwrocona + liczba);
				if(suma.equals(new StringBuilder(suma).reverse().toString())) {
					ilePalindromow++;
				}
			}
			printWriter.println();
			printWriter.println("podpunkt 2:");
			printWriter.println("Iloï¿½ï¿½ palindromï¿½w: " + ilePalindromow);
			printWriter.flush();
		};
		Runnable pp3 = () ->{
			HashMap<Integer, ArrayList<Integer>> moc_liczby = new HashMap<Integer, ArrayList<Integer>>();
			
			for(int i=1; i<=8; i++) {
				moc_liczby.put(i, new ArrayList<Integer>());
			}
		
			for(int i=0; i<liczby.size(); i++) {
				String liczbaString = liczby.get(i).toString();
				int iloczyn = Character.getNumericValue(liczbaString.charAt(0));
				for(int j=1; j<liczbaString.length(); j++) {;
					iloczyn *= Character.getNumericValue(liczbaString.charAt(j));
				}
				int moc = 1;
				while(iloczyn > 9) {
					String iloczynString = String.valueOf(iloczyn);
					iloczyn = Character.getNumericValue(iloczynString.charAt(0));
					for(int j=1; j<iloczynString.length(); j++) {
						iloczyn *= Character.getNumericValue(iloczynString.charAt(j));
					}
					moc++;
				}
				moc_liczby.get(moc).add(liczby.get(i));
			}
			
			printWriter.println();
			printWriter.println("podpunkt 3:");
			for(int i=1; i<=8; i++) {
				printWriter.println("Iloï¿½ï¿½ liczb o mocy: " + i +  " wynosi " + moc_liczby.get(i).size());
			}
			printWriter.println("Minimalna liczba o mocy 1: " + Collections.min(moc_liczby.get(1)));
			printWriter.print("Maksymalna liczba o mocy 1: " + Collections.max(moc_liczby.get(1)));
			printWriter.flush();
			
		};
			
		pp1.run();
		pp2.run();
		pp3.run();
	}
	private static void zadanie60() throws Exception{
		Scanner plikLiczby = new Scanner(new File("Files/60/liczby.txt"));
		PrintWriter printWriter = new PrintWriter(new File("rozwiazania/60.txt"));
		
		ArrayList<Integer> liczby = new ArrayList<Integer>();
		
		while(plikLiczby.hasNext()) {
			liczby.add(plikLiczby.nextInt());
		}
		
		Runnable pp1 = () ->{
			int ileMniejszychOd1000 = 0;
			int przedostatnia = 0;
			int ostatnia = 0;
			for(int i=0; i<liczby.size(); i++) {
				if(liczby.get(i) < 1000) {
					ileMniejszychOd1000++;
					przedostatnia = ostatnia;
					ostatnia = liczby.get(i);
				}
			}
			printWriter.println("Podpunkt 1: ");
			printWriter.println("Iloï¿½ï¿½ liczb mniejszych od 1000: " + ileMniejszychOd1000);
			printWriter.println("Dwie ostatnie liczby: " + przedostatnia + ", " + ostatnia);
			printWriter.flush();
			
		};
		Runnable pp2 = () ->{
			printWriter.println();
			printWriter.println("Podpunkt 2: ");
			for(int i=0; i<liczby.size(); i++) {
				int liczba = liczby.get(i);
				ArrayList<Integer> dzielniki = new ArrayList<Integer>();
				for(int j=1; j<=liczba; j++) {
					if(liczba % j == 0) {
						dzielniki.add(j);
					}
				}
				
				if(dzielniki.size() == 18) {
					printWriter.println(liczba);
					printWriter.println(dzielniki);
				}
			}
			printWriter.flush();
		};
		Runnable pp3 = () ->{
			printWriter.println();
			Collections.sort(liczby);
			Collections.reverse(liczby);
			
			for(int i=0; i<liczby.size(); i++) {
				int liczba = liczby.get(i);
				ArrayList<Integer> dzielnikiPoza1 = new ArrayList<Integer>();
				for(int j=2; j<=liczba; j++) {
					if(liczba % j == 0) {
						dzielnikiPoza1.add(j);
					}
				}
				
				boolean czyJestWzgledniePierwsza = true;
				for(int j=i+1; j<liczby.size()-i-1; j++) {
					czyJestWzgledniePierwsza = true;
					for(int k=0; k<dzielnikiPoza1.size(); k++) {
						if(liczby.get(j) % dzielnikiPoza1.get(k) == 0) {
							// liczba nie jest wzglednie pierwsza;
							czyJestWzgledniePierwsza = false;
							j = 100000;
							break;
						}
					}	
				}
				if(czyJestWzgledniePierwsza) {
					printWriter.println();
					printWriter.println("Podpunkt 3: ");
					printWriter.print("Najwiï¿½ksza wzglï¿½dnie pierwsza liczba to: " + liczba);
					printWriter.flush();
					break;
				}	
			}
		};
		
		pp1.run();
		pp2.run();
		pp3.run();
	}
	private static void zadanie61() throws Exception{
		PrintWriter printWriter = new PrintWriter(new File("rozwiazania/61.txt"));
		
		Scanner plikCiagi = new Scanner(new File("Files/61/ciagi.txt"));
		Scanner plikBledne = new Scanner(new File("Files/61/bledne.txt"));
		
		ArrayList<ArrayList<Integer>> ciagi = new ArrayList<ArrayList<Integer>>();
		
		while(plikCiagi.hasNext()) {
			int dlugoscCiagu = plikCiagi.nextInt();
			ArrayList<Integer> aktualnyCiag = new ArrayList<Integer>();
			
			for(int i=0; i<dlugoscCiagu; i++) {
				aktualnyCiag.add(plikCiagi.nextInt());
			}
			ciagi.add(aktualnyCiag);
		}
		Runnable pp1 = () ->{
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
			
			printWriter.println("Podpunkt 1:");
			printWriter.println("Iloï¿½ï¿½ ciï¿½gï¿½w arytmetycznych: " + ciagiArytmetyczne.size());
			printWriter.println("Maksymalna rï¿½nica ciï¿½gu arytmetycznego: " + maxRoznica);
			printWriter.flush();
		};
		Runnable pp2 = () ->{
			printWriter.println();
			printWriter.println("Podpunkt 2:");
			for(int i=0; i<ciagi.size(); i++) {
			}
			printWriter.flush();
		};
		Runnable pp3 = () ->{
			
		};
		
		pp1.run();
		pp2.run();
		pp3.run();
	}
	private static void zadanie62() throws Exception {
		Scanner plik1 = new Scanner(new File("Files/62/liczby1.txt"));
		Scanner plik2 = new Scanner(new File("Files/62/liczby2.txt"));
		
		ArrayList<String> osemkowe = new ArrayList<String>();
		ArrayList<Integer> osemkoweInt = new ArrayList<Integer>();
<<<<<<< HEAD
<<<<<<< HEAD
		ArrayList<String> dziesietne = new ArrayList<String>();
=======
>>>>>>> 796735776b7b0b5938bc970d14f609453df925ba
=======
>>>>>>> 796735776b7b0b5938bc970d14f609453df925ba
		ArrayList<Integer> dziesietneInt = new ArrayList<Integer>();
		
		while(plik1.hasNext()) {
			String next = plik1.next();
<<<<<<< HEAD
<<<<<<< HEAD
			Integer osemkowaInt = 0;
			for(int i=next.length()-1; i>0; i--) {
				osemkowaInt += (int)(Math.pow(8, i)) * Integer.parseInt(next.charAt(i) + "");
			}
			osemkoweInt.add(osemkowaInt);
			
			osemkowe.add(plik1.next());
		}
		while(plik2.hasNext()) {
			String next = plik2.next();
			dziesietne.add(next);
			dziesietneInt.add(Integer.parseInt(next));
		}
		
		Runnable pp1 = () -> {
			Collections.sort(osemkowe);
			int max = osemkoweInt.get(0);
			int min = osemkoweInt.get(osemkoweInt.size() - 1);
=======
=======
>>>>>>> 796735776b7b0b5938bc970d14f609453df925ba
			osemkoweInt.add(Integer.parseInt(next, 8));
			osemkowe.add(next);
		}
		while(plik2.hasNext()) {
			dziesietneInt.add(Integer.parseInt(plik2.next()));
		}
		 
		Runnable pp1 = () -> {
			Collections.sort(osemkoweInt);
			String max = Integer.toString(osemkoweInt.get(osemkoweInt.size() - 1), 8);
			String min = Integer.toString(osemkoweInt.get(0), 8);
<<<<<<< HEAD
>>>>>>> 796735776b7b0b5938bc970d14f609453df925ba
=======
>>>>>>> 796735776b7b0b5938bc970d14f609453df925ba
			
			System.out.println("Min: " + min);
			System.out.println("Max: " + max);
		};
		Runnable pp2 = () -> {
<<<<<<< HEAD
<<<<<<< HEAD
//			int maxDlugoscCiagu = 0;
//			ArrayList<Integer> najdluzszyCiagMalejacy = new ArrayList<Integer>();
//			ArrayList<Integer> ciagMalejacy = new ArrayList<Integer>();
//			for(int i=0; i<dziesietneInt.size(); i++) {
//				if(ciagMalejacy.size() == 0) {
//					ciagMalejacy.add(dziesietneInt.get(i));
//				} else if(dziesietneInt.get(i) < ciagMalejacy.get(ciagMalejacy.size() - 1)) {
//					ciagMalejacy.add(dziesietneInt.get(i));
//				} else {
//					ciagMalejacy = new ArrayList<Integer>();
//					ciagMalejacy.add(dziesietneInt.get(i));
//				}
//				if(ciagMalejacy.size() > maxDlugoscCiagu) {
//					najdluzszyCiagMalejacy = (ArrayList<Integer>) ciagMalejacy.clone();
//					maxDlugoscCiagu = ciagMalejacy.size();
//				}
//			}
			
//			System.out.println(najdluzszyCiagMalejacy);
//			
//			System.out.println("Max d³ugoœæ ci¹gu: " + maxDlugoscCiagu);
		};
		Runnable pp3 = () -> {
			
		};
		Runnable pp4 = () -> {
			int ile6 = 0;
			int ile6w8 = 0;
			for(int liczba: dziesietneInt) {
				int liczba8 = 0;
				
			}
=======
=======
>>>>>>> 796735776b7b0b5938bc970d14f609453df925ba
			ArrayList<ArrayList<Integer>> ciagiMalejace = new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> aktualnyCiagMalejacy = new ArrayList<Integer>();
			
			aktualnyCiagMalejacy.add(dziesietneInt.get(0));
			
			for(int i=1; i<dziesietneInt.size(); i++) {
				int liczba = dziesietneInt.get(i);
				if(aktualnyCiagMalejacy.size() == 0 || liczba >= aktualnyCiagMalejacy.get(aktualnyCiagMalejacy.size()-1)) {
					aktualnyCiagMalejacy.add(liczba);
				} else { // koniec ciagu
					ciagiMalejace.add(aktualnyCiagMalejacy);
					aktualnyCiagMalejacy = new ArrayList<Integer>(); 
					aktualnyCiagMalejacy.add(liczba);
				}
			}
			// znalezienie najdluzszego ciagu:
			ArrayList<Integer> najdluzszyCiagMalejacy = ciagiMalejace.get(0);
			for(int i=0; i<ciagiMalejace.size(); i++) {
				if(ciagiMalejace.get(i).size() > najdluzszyCiagMalejacy.size()) {
					najdluzszyCiagMalejacy = ciagiMalejace.get(i);
				}
			}
			
			System.out.println(najdluzszyCiagMalejacy);
		};
		Runnable pp3 = () -> {
			ArrayList<Integer> wierszeWKtorychLiczbySaTakieSame = new ArrayList<Integer>();
			ArrayList<Integer> wierszeWKtorychLiczba1JestWieksza = new ArrayList<Integer>();
			
			for(int i=0; i<dziesietneInt.size(); i++) {
				int osemkowaInt = Integer.parseInt(osemkowe.get(i), 8);
				int dziesietnaInt = dziesietneInt.get(i);
				if(osemkowaInt == dziesietnaInt) {
					wierszeWKtorychLiczbySaTakieSame.add(i + 1);
				} else if(dziesietnaInt > osemkowaInt) {
					wierszeWKtorychLiczba1JestWieksza.add(i + 1);
				}
			}
			System.out.println("Ilosc wierszy w ktorych liczby sa takie same: " + wierszeWKtorychLiczbySaTakieSame.size());
			System.out.println("Ilosc wierszy w ktorych liczba1 jest wiÄ™ksza: " + wierszeWKtorychLiczba1JestWieksza.size());
		};
		Runnable pp4 = () -> {
			int ileRazy6 = 0;
			int ileRazy6wZapisie8 = 0;
			for(int i=0; i<1000; i++) {
				String liczba = dziesietneInt.get(i) + "";
				ileRazy6 += liczba.length() - liczba.replaceAll("6", "").length();
				String liczba8 = Integer.toString(dziesietneInt.get(i), 8);
				ileRazy6wZapisie8 += liczba8.length() - liczba8.replaceAll("6", "").length();
			}
			System.out.println("Ilosc 6: " + ileRazy6);
			System.out.println("Ilosc 6 gdy zapiszemy liczby osemkowo: " + ileRazy6wZapisie8);
<<<<<<< HEAD
>>>>>>> 796735776b7b0b5938bc970d14f609453df925ba
=======
>>>>>>> 796735776b7b0b5938bc970d14f609453df925ba
		};
		
		pp1.run();
		pp2.run();
		pp3.run();
		pp4.run();
<<<<<<< HEAD
<<<<<<< HEAD
		consumer.accept("d");
		runnable.run();
		Swimmable<String> swimService = (String a) -> {
			// do something
		};
		
		swimService.swim("Hi");
		
		BiFunction<String,String,String> addStrings = (String a, String b) -> {
			return a + b;
		};
		
		String result = addStrings.apply("Hi ", "Mark");
	}
	static Consumer<String> consumer = (String b)->{
		
	};
	static Runnable runnable = () ->{
		
	};
	
	@FunctionalInterface
	interface Swimmable<T> {
		void swim(T t);
	}
	
	
	public static void zadanie69() throws Exception {
		Scanner plik_geny = new Scanner(new File("Files/69/dane_geny.txt"));
		
		ArrayList<String> genotypy = new ArrayList<String>();
		
		while(plik_geny.hasNext()) {
			genotypy.add(plik_geny.next());
		}
		
		Runnable pp1 = () ->{
//			TreeMap<String, Integer> genotyp_ilosc = new TreeMap<String, Integer>();
//			for(int i=0; i<genotypy.size(); i++) {
//				String genotyp = genotypy.get(i);
//				Integer iloscZGatunku = genotyp_ilosc.get(genotyp);
//				if(iloscZGatunku == null){
//					genotyp_ilosc.put(genotyp, 0);
//				} else {
//					genotyp_ilosc.put(genotyp, iloscZGatunku+1);
//				}
//			}
//			int max = 0;
//			for(Map.Entry<String, Integer> entry : genotyp_ilosc.entrySet()) {
//				if(entry.getValue() > max) {
//					max = entry.getValue();
//				}
//			}
//			System.out.println("Iloœæ gatunków: " + genotyp_ilosc.size());
//			System.out.println("Max iloœæ  osobników w jednym gatunku: " + max);
			
			for(int i=0; i<genotypy.size(); i++) {
				
				
				String genotyp = genotypy.get(i);
				Stack<String> obecnyGen = new Stack<String>();
				for(int j=0; j<genotyp.length(); j++) {
					
				}
			}
			
			
		};
		Runnable pp2 = () ->{
			
		};
		Runnable pp3 = () ->{
			
		};
		Runnable pp4 = () ->{
			
		};
		
		pp1.run();
		pp2.run();
		pp3.run();
		pp3.run();
		pp4.run();
	}
	public static void zadanie70() throws Exception {
		
	}
	public static void zadanie81() throws Exception { // Czworok¹ty
		
		Scanner plik_dane = new Scanner(new File("Files/81/wspolrzedne.txt"));
		Scanner plik_daneTR = new Scanner(new File("Files/81/wspolrzedneTR.txt"));
		
		ArrayList<ArrayList<Point>> dane_wiersze = new ArrayList<ArrayList<Point>>();		
		ArrayList<ArrayList<Point>> dane_wierszeTR = new ArrayList<ArrayList<Point>>();		
		
		
=======
=======
>>>>>>> 796735776b7b0b5938bc970d14f609453df925ba
		
	}
	private static void zadanie63() throws Exception {
		Scanner plikCiagi = new Scanner(new File("Files/63/ciagi.txt"));
		ArrayList<String> ciagi = new ArrayList<String>();		
		
		while(plikCiagi.hasNext()) {
			ciagi.add(plikCiagi.next());
		}
		
		Runnable pp1 = () -> {
			ArrayList<String> ciagiDwucykliczne = new ArrayList<String>();	
			for(String ciag: ciagi) {
				if(ciag.length() % 2 == 0) {
					if(ciag.substring(0, ciag.length()/2).equals(ciag.substring(ciag.length()/2, ciag.length()))) {
						ciagiDwucykliczne.add(ciag);
					}
				}
			}
			System.out.println(ciagiDwucykliczne);
		};
		Runnable pp2 = () -> {
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
			System.out.println(ileBezDwochJedynekObokSiebie);
		};
		Runnable pp3 = () -> {
			
		};
		pp1.run();
		pp2.run();
		pp3.run();
	}
	private static void zadanie64() throws Exception {
		BufferedReader plik_obrazki = Files.newBufferedReader(Paths.get("Files/64/dane_obrazki.txt"));
		ArrayList<ArrayList<Integer>> obrazki = new ArrayList<ArrayList<Integer>>();
		
		List<String> lines = plik_obrazki.lines().collect(Collectors.toList());
//		while(plik_obrazki.hasNext()) {
//			ArrayList<Integer> obrazek = new ArrayList<Integer>();
////			for(int i=0; i<36; i++) {
////				obrazek.add(plik_obrazki.nextInt());
////			}
//		}
		
		Runnable pp1 = () -> {
			
		};
		Runnable pp2 = () -> {
			
		};
		Runnable pp3 = () -> {
			
		};
		pp1.run();
		pp2.run();
		pp3.run();
	}

	public static void zadanie81() throws Exception { // CzworokÄ…ty

		Scanner plik_dane = new Scanner(new File("Files/81/wspolrzedne.txt"));
		Scanner plik_daneTR = new Scanner(new File("Files/81/wspolrzedneTR.txt"));

		ArrayList<ArrayList<Point>> dane_wiersze = new ArrayList<ArrayList<Point>>();		
		ArrayList<ArrayList<Point>> dane_wierszeTR = new ArrayList<ArrayList<Point>>();		


<<<<<<< HEAD
>>>>>>> 796735776b7b0b5938bc970d14f609453df925ba
=======
>>>>>>> 796735776b7b0b5938bc970d14f609453df925ba
		while(plik_dane.hasNext()) {	
			ArrayList<Point> linia = new ArrayList<Point>();
			for(int i=0; i<3; i++) {
				linia.add(new Point(plik_dane.nextInt(), plik_dane.nextInt()));
			}
			dane_wiersze.add(linia);
		}
<<<<<<< HEAD
<<<<<<< HEAD
		
=======

>>>>>>> 796735776b7b0b5938bc970d14f609453df925ba
=======

>>>>>>> 796735776b7b0b5938bc970d14f609453df925ba
		while(plik_daneTR.hasNext()) {
			ArrayList<Point> linia = new ArrayList<Point>();
			for(int i=0; i<3; i++) {
				linia.add(new Point(plik_daneTR.nextInt(), plik_daneTR.nextInt()));
			}
			dane_wierszeTR.add(linia);
		}
<<<<<<< HEAD
<<<<<<< HEAD
		
		Runnable pp1 = () -> {
			int ileWierszy = 0;
			
=======
=======
>>>>>>> 796735776b7b0b5938bc970d14f609453df925ba

		Runnable pp1 = () -> {
			int ileWierszy = 0;

<<<<<<< HEAD
>>>>>>> 796735776b7b0b5938bc970d14f609453df925ba
=======
>>>>>>> 796735776b7b0b5938bc970d14f609453df925ba
			for(int i=0; i<dane_wiersze.size(); i++) {
				boolean czyWierszWCwiartce = true;		
				for(int j=0; j<3; j++) {
					Point punkt = dane_wiersze.get(i).get(j);
					if(!(punkt.getX() > 0 && punkt.getY() > 0)) {
						czyWierszWCwiartce = false;
					}
				}
				if(czyWierszWCwiartce) {
					ileWierszy++;
				}
			}
<<<<<<< HEAD
<<<<<<< HEAD
			
			System.out.println("Zadanie 81.1: " + ileWierszy);
		};
		Runnable pp2 = () -> {
			
			int ileProstych = 0;
			
=======
=======
>>>>>>> 796735776b7b0b5938bc970d14f609453df925ba

			System.out.println("Zadanie 81.1: " + ileWierszy);
		};
		Runnable pp2 = () -> {

			int ileProstych = 0;

<<<<<<< HEAD
>>>>>>> 796735776b7b0b5938bc970d14f609453df925ba
=======
>>>>>>> 796735776b7b0b5938bc970d14f609453df925ba
			for(int i=0; i<dane_wiersze.size(); i++) {
				Point a = dane_wiersze.get(i).get(0);
				Point b = dane_wiersze.get(i).get(1);
				Point c = dane_wiersze.get(i).get(2);
<<<<<<< HEAD
<<<<<<< HEAD
				
				double tgAB = Math.abs((a.getY() - b.getY()) / (a.getX() - b.getX()));
				double tgAC = Math.abs((a.getY() - c.getY()) / (a.getX() - c.getX()));
				
=======
=======
>>>>>>> 796735776b7b0b5938bc970d14f609453df925ba

				double tgAB = Math.abs((a.getY() - b.getY()) / (a.getX() - b.getX()));
				double tgAC = Math.abs((a.getY() - c.getY()) / (a.getX() - c.getX()));

<<<<<<< HEAD
>>>>>>> 796735776b7b0b5938bc970d14f609453df925ba
=======
>>>>>>> 796735776b7b0b5938bc970d14f609453df925ba
				if(tgAB == tgAC) {
					ileProstych++;
				}
			}
<<<<<<< HEAD
<<<<<<< HEAD
			
=======

>>>>>>> 796735776b7b0b5938bc970d14f609453df925ba
=======

>>>>>>> 796735776b7b0b5938bc970d14f609453df925ba
			System.out.println("Zadanie 81.2: " + ileProstych);
		};
		Runnable pp3 = () -> {
			double maxObw = 0d;
			Point maxA = new Point();
			Point maxB = new Point();
			Point maxC = new Point();
			for(int i=0; i<dane_wierszeTR.size(); i++) {
<<<<<<< HEAD
<<<<<<< HEAD
				
				Point a = dane_wierszeTR.get(i).get(0);
				Point b = dane_wierszeTR.get(i).get(1);
				Point c = dane_wierszeTR.get(i).get(2);
				
=======
=======
>>>>>>> 796735776b7b0b5938bc970d14f609453df925ba

				Point a = dane_wierszeTR.get(i).get(0);
				Point b = dane_wierszeTR.get(i).get(1);
				Point c = dane_wierszeTR.get(i).get(2);

<<<<<<< HEAD
>>>>>>> 796735776b7b0b5938bc970d14f609453df925ba
=======
>>>>>>> 796735776b7b0b5938bc970d14f609453df925ba
				double obw = a.distance(b) + a.distance(c) + b.distance(c);
				if(obw > maxObw) {
					maxObw = obw;
					maxA = a;
					maxB = b;
					maxC = c;
				}
				//int obwod = Math.hypot(a.get, y) 
			}
<<<<<<< HEAD
<<<<<<< HEAD
			
			Function<Point, String> formatPoint = (Point a) ->{
				return "(" + (int)a.getX() + "," + (int)a.getY() + ")";
			};
			
			new DecimalFormat("#.");
			Pattern a;
			System.out.println("Zadanie 81.3: ");
			System.out.println("Max obwód: " + String.format("%.2f", maxObw));
			System.out.println("Max obwód: " + new DecimalFormat("#.##").format(maxObw));
			
			System.out.println("Trójk¹t: " + formatPoint.apply(maxA) + ", " + formatPoint.apply(maxB) + ", " + formatPoint.apply(maxC));
		};
		Runnable pp4 = () -> {
			int ileProst = 0;
			
=======
=======
>>>>>>> 796735776b7b0b5938bc970d14f609453df925ba

			Function<Point, String> formatPoint = (Point a) ->{
				return "(" + (int)a.getX() + "," + (int)a.getY() + ")";
			};

			new DecimalFormat("#.");
			Pattern a;
			System.out.println("Zadanie 81.3: ");
			System.out.println("Max obwÃ³d: " + String.format("%.2f", maxObw));
			System.out.println("Max obwÃ³d: " + new DecimalFormat("#.##").format(maxObw));

			System.out.println("TrÃ³jkÄ…t: " + formatPoint.apply(maxA) + ", " + formatPoint.apply(maxB) + ", " + formatPoint.apply(maxC));
		};
		Runnable pp4 = () -> {
			int ileProst = 0;

<<<<<<< HEAD
>>>>>>> 796735776b7b0b5938bc970d14f609453df925ba
=======
>>>>>>> 796735776b7b0b5938bc970d14f609453df925ba
			for(int i=0; i<dane_wierszeTR.size(); i++) {
				ArrayList<Point> wiersz = dane_wierszeTR.get(i);
				//if(wiersz.get(0))
				double bokA = wiersz.get(0).distance(wiersz.get(1));
				double bokB = wiersz.get(0).distance(wiersz.get(2));
				double bokC = wiersz.get(1).distance(wiersz.get(2));
<<<<<<< HEAD
<<<<<<< HEAD
				
				
=======


>>>>>>> 796735776b7b0b5938bc970d14f609453df925ba
=======


>>>>>>> 796735776b7b0b5938bc970d14f609453df925ba
				boolean czyProst = false;
				if(bokA * bokA + bokB * bokB == bokC * bokC) {
					czyProst = true;
				} else if(bokA * bokA + bokB * bokB == bokC * bokC) {
					czyProst = true;
				} else if(bokA * bokA + bokB * bokB == bokC * bokC) {
					czyProst = true;
				}
				if(czyProst) {
					ileProst++;
				}
<<<<<<< HEAD
<<<<<<< HEAD
				
			}
			
			System.out.println("Zadanie 81.4: " + ileProst);
		};
		Runnable pp5 = () -> {
			
		};
		
=======
=======
>>>>>>> 796735776b7b0b5938bc970d14f609453df925ba

			}

			System.out.println("Zadanie 81.4: " + ileProst);
		};
		Runnable pp5 = () -> {

		};

<<<<<<< HEAD
>>>>>>> 796735776b7b0b5938bc970d14f609453df925ba
=======
>>>>>>> 796735776b7b0b5938bc970d14f609453df925ba
		pp1.run();
		pp2.run();
		pp3.run();
		pp4.run();
		pp5.run();
	}
<<<<<<< HEAD
<<<<<<< HEAD
	public static void test() throws Exception {
		List<String> list = new ArrayList<String>();
		Collections.addAll(list,"1", "2", "3");
		
		List<Point> points = new ArrayList<Point>();
		
		points.add(new Point(3,3));
		points.add(new Point(3,3));
		points.add(new Point(4,5));

		Point doSkopiowania = new Point(0,0);
		
		points.add(doSkopiowania);
		points.add(doSkopiowania);
		points.add(doSkopiowania);
		
		points = points.stream().distinct().collect(Collectors.toList());
		
		System.out.println(points);
		
		list = list.stream().map((String el)->{
			return el + " hello";
		}).collect(Collectors.toList());
		
		
		// distinct 2: listy z unikatow¹ zawartoœci¹
		
		ArrayList<ArrayList<Integer>> listOfLists = new ArrayList<ArrayList<Integer>>();
		
		ArrayList<Integer> lista1 = new ArrayList<Integer>();
		ArrayList<Integer> lista2 = new ArrayList<Integer>();
		ArrayList<Integer> lista3 = new ArrayList<Integer>();
		
		Collections.addAll(lista1, 1,2,3);
		Collections.addAll(lista2, 1,2,3);
		Collections.addAll(lista3, 2,3,4);
		
		Collections.addAll(listOfLists, lista1, lista2, lista3);
		
		List<ArrayList<Integer>> newListOfLists = listOfLists.stream().distinct().collect(Collectors.toList());
		
		System.out.println(listOfLists);
		System.out.println(newListOfLists);
		
		Set<Integer> a = new HashSet<Integer>();
		
		a.add(1);
		a.add(1);
		a.add(2);
		
		System.out.println(a);
		
//		a.add(new ArrayList<Integer>()){
//			
//		}
		
	}
	
	//a.accept("ddd");
=======
	
	private static void test() throws Exception {
	}
>>>>>>> 796735776b7b0b5938bc970d14f609453df925ba
	
=======
	
	private static void test() throws Exception {
	}
	
>>>>>>> 796735776b7b0b5938bc970d14f609453df925ba
	

	public static void main(String[] args) {
		try {
			zadanie58();
//			zadanie59();
//			zadanie60();
//			zadanie61();
//			zadanie62();
<<<<<<< HEAD
<<<<<<< HEAD
//			zadanie69();
//			zadanie70();
			zadanie81();
			//test();
						
=======
//			zadanie63();
//			zadanie64();
			test();
>>>>>>> 796735776b7b0b5938bc970d14f609453df925ba
=======
//			zadanie63();
//			zadanie64();
			test();
>>>>>>> 796735776b7b0b5938bc970d14f609453df925ba
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

}