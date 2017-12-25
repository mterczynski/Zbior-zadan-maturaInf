package Zadania;

import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Function;
import java.util.regex.Pattern;

public class Zadanie81 {

	Scanner plik_dane;
	Scanner plik_daneTR;

	ArrayList<ArrayList<Point>> dane_wiersze = new ArrayList<ArrayList<Point>>();		
	ArrayList<ArrayList<Point>> dane_wierszeTR = new ArrayList<ArrayList<Point>>();	
	
	public Zadanie81() {
			
		try {
			plik_dane = new Scanner(new File("Files/81/wspolrzedne.txt"));
			plik_daneTR = new Scanner(new File("Files/81/wspolrzedneTR.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		while(plik_dane.hasNext()) {	
			ArrayList<Point> linia = new ArrayList<Point>();
			for(int i=0; i<3; i++) {
				linia.add(new Point(plik_dane.nextInt(), plik_dane.nextInt()));
			}
			dane_wiersze.add(linia);
		}

		while(plik_daneTR.hasNext()) {
			ArrayList<Point> linia = new ArrayList<Point>();
			for(int i=0; i<3; i++) {
				linia.add(new Point(plik_daneTR.nextInt(), plik_daneTR.nextInt()));
			}
			dane_wierszeTR.add(linia);
		}
		
		pp1();
		pp2();
		pp3();
		pp4();
		pp5();
	}

	private void pp1() {
		int ileWierszy = 0;

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

		System.out.println("Zadanie 81.1: " + ileWierszy);
	}
	private void pp2() {
		int ileProstych = 0;

		for(int i=0; i<dane_wiersze.size(); i++) {
			Point a = dane_wiersze.get(i).get(0);
			Point b = dane_wiersze.get(i).get(1);
			Point c = dane_wiersze.get(i).get(2);

			double tgAB = Math.abs((a.getY() - b.getY()) / (a.getX() - b.getX()));
			double tgAC = Math.abs((a.getY() - c.getY()) / (a.getX() - c.getX()));

			if(tgAB == tgAC) {
				ileProstych++;
			}
		}

		System.out.println("Zadanie 81.2: " + ileProstych);
	}
	private void pp3() {
		double maxObw = 0d;
		Point maxA = new Point();
		Point maxB = new Point();
		Point maxC = new Point();
		for(int i=0; i<dane_wierszeTR.size(); i++) {

			Point a = dane_wierszeTR.get(i).get(0);
			Point b = dane_wierszeTR.get(i).get(1);
			Point c = dane_wierszeTR.get(i).get(2);

			double obw = a.distance(b) + a.distance(c) + b.distance(c);
			if(obw > maxObw) {
				maxObw = obw;
				maxA = a;
				maxB = b;
				maxC = c;
			}
			//int obwod = Math.hypot(a.get, y) 
		}

		Function<Point, String> formatPoint = (Point a) ->{
			return "(" + (int)a.getX() + "," + (int)a.getY() + ")";
		};
		Pattern a;
		System.out.println("Zadanie 81.3: ");
		System.out.println("Max obwód: " + String.format("%.2f", maxObw));
		System.out.println("Max obwód: " + new DecimalFormat("#.##").format(maxObw));

		System.out.println("Trójk¹t: " + formatPoint.apply(maxA) + ", " + formatPoint.apply(maxB) + ", " + formatPoint.apply(maxC));
	}
	private void pp4() {
		int ileProst = 0;

		for(int i=0; i<dane_wierszeTR.size(); i++) {
			ArrayList<Point> wiersz = dane_wierszeTR.get(i);
			//if(wiersz.get(0))
			double bokA = wiersz.get(0).distance(wiersz.get(1));
			double bokB = wiersz.get(0).distance(wiersz.get(2));
			double bokC = wiersz.get(1).distance(wiersz.get(2));


		new DecimalFormat("#.");

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

		}

		System.out.println("Zadanie 81.4: " + ileProst);
	}
	private void pp5() {}
}
