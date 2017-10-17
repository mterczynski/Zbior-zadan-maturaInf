import java.io.BufferedReader;
import java.io.File;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
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
			
			System.out.println("Najniższy wynik stacji 1: " + Integer.toString(temperatury1Cp.get(0), 2));
			System.out.println("Najniższy wynik stacji 2: " + Integer.toString(temperatury2Cp.get(0), 2));
			System.out.println("Najniższy wynik stacji 3: " + Integer.toString(temperatury3Cp.get(0), 2));
		};
		Runnable pp2 = () -> {
			int ileBlednychWeWszystkich3 = 0;
			for(int i=0; i<czasy1.size(); i++) {
				if(czasy1.get(i) % 12 !=0 && czasy2.get(i) % 12 !=0 && czasy3.get(i) % 12 !=0) {
					ileBlednychWeWszystkich3++;
				}
			}
			System.out.println("Ilość błędnych pomiarów we wszystkich 3 stacjach w tym samym czasie: " + ileBlednychWeWszystkich3);
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
			System.out.println("Ilość dni rekordowych: " + ileDniRekordowych);
		};
		Runnable pp4 = () -> {
			for(int i=0; i<temperatury1.size(); i++) {
				for(int j=i; i<temperatury1.size(); j++) {
					
				}
			}
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
			printWriter.println("Ilo�� liczb maj�cych dok�adnie 3 r�ne nieparzyste czynniki pierwsze: " + ileLiczbSpelniajacychWarunki);
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
			printWriter.println("Ilo�� palindrom�w: " + ilePalindromow);
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
				printWriter.println("Ilo�� liczb o mocy: " + i +  " wynosi " + moc_liczby.get(i).size());
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
			printWriter.println("Ilo�� liczb mniejszych od 1000: " + ileMniejszychOd1000);
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
					printWriter.print("Najwi�ksza wzgl�dnie pierwsza liczba to: " + liczba);
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
			printWriter.println("Ilo�� ci�g�w arytmetycznych: " + ciagiArytmetyczne.size());
			printWriter.println("Maksymalna r�nica ci�gu arytmetycznego: " + maxRoznica);
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
		ArrayList<Integer> dziesietneInt = new ArrayList<Integer>();
		
		while(plik1.hasNext()) {
			String next = plik1.next();
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
			
			System.out.println("Min: " + min);
			System.out.println("Max: " + max);
		};
		Runnable pp2 = () -> {
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
			System.out.println("Ilosc wierszy w ktorych liczba1 jest większa: " + wierszeWKtorychLiczba1JestWieksza.size());
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
		};
		
		pp1.run();
		pp2.run();
		pp3.run();
		pp4.run();
		
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
	
	private static void test() throws Exception {
		// Streams example 1:
		
		List<String> stringi = new ArrayList<String>();
		Collections.addAll(stringi, "1", "2", "3");
		stringi.addAll(Arrays.asList("2","3","4444"));
		
		List<String> noweStringi = stringi.stream().map((String el)->{
			return el + " siema";
		}).collect(Collectors.toList());
		
		//System.out.println(noweStringi);
		
		// Streams example 2:
		
		List<Integer> liczby = new ArrayList<Integer>();
		
		for(int i=0; i<100; i++) {
			liczby.add(i);
		}
		
		List<Integer> filtered = liczby.stream().filter((Integer a)->{
			return (a >= 80 && a %2 == 0);
		}).collect(Collectors.toList());
		
		//System.out.println(filtered);
		
		// Streams example 3:
		
		List<BigInteger> duzeLiczby = new ArrayList<BigInteger>();
		
		for(int i=0; i<10; i++) {
			Random r = new Random();
			duzeLiczby.add(BigInteger.valueOf(r.nextInt(6) + 1));
		}
		
		List<BigInteger> duzeLiczbyResult = duzeLiczby.stream().sorted().distinct().collect(Collectors.toList());
		
		System.out.println(duzeLiczbyResult);
		
		person<String> adam = () -> {
			return "Hello Adam";
		};
		
	}
	
	@FunctionalInterface
	interface person<T>{
		T getData();
	}
	
	public static void main(String[] args) {
		try {
//			zadanie58();
//			zadanie59();
//			zadanie60();
//			zadanie61();
//			zadanie62();
//			zadanie63();
//			zadanie64();
			test();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

}