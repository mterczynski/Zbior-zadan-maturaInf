package Zadania;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.function.BiConsumer;

public class Zadanie71 {

	ArrayList<ArrayList<Double>> funkcja_wspolczynniki = new ArrayList<ArrayList<Double>>();
	
	double funkcja(double x) {
		if(x >=0 && x<1) {
			return funkcja(0,x);
		} else if(x >=1 && x<2) {
			return funkcja(1,x);
		} else if(x >=2 && x<3) {
			return funkcja(2,x);
		} else if(x >=3 && x<4) {
			return funkcja(3,x);
		} else if(x >=4 && x<5) {
			return funkcja(4,x);
		}  
		throw new Error();
	}
	
	double funkcja(int idFunkcji, double x){
		ArrayList<Double> wsp = funkcja_wspolczynniki.get(idFunkcji);
		double a = wsp.get(3);
		double b = wsp.get(2);
		double c = wsp.get(1);
		double d = wsp.get(0);
		return a*x*x*x + b*x*x + c*x + d;
	}
	
	public Zadanie71() {
		
		try {
			Scanner sc = new Scanner(new File("Files/71/funkcja.txt"));
			sc.useLocale(Locale.US);
			ArrayList<Double> wspolczynniki = new ArrayList<Double>();
			for(int i=0; i<20; i+=4) {
				wspolczynniki.add(sc.nextDouble());
				wspolczynniki.add(sc.nextDouble());
				wspolczynniki.add(sc.nextDouble());
				wspolczynniki.add(sc.nextDouble());
				funkcja_wspolczynniki.add(wspolczynniki);
				wspolczynniki = new ArrayList<Double>(); 
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		pp1();
		pp2();
		pp3();
	}
	
	void pp1() {
		DecimalFormat df5 = new DecimalFormat("0.00000");
		System.out.println("71.1: " + df5.format(funkcja(1.5d)));
	}

	void pp2() {
		double maxX = 0;
		double maxWartosc = -6;
		for(double i=0; i<=5; i+=0.00001) {
			double wartosc = funkcja(i);
			if(wartosc > maxWartosc) {
				maxX = i;
				maxWartosc = wartosc;
			}
		}
		DecimalFormat d3 = new DecimalFormat("0.000");
		DecimalFormat d5 = new DecimalFormat("0.00000");
		System.out.println("71.2: ");
		System.out.println("Max wartoœæ: " + d5.format(maxWartosc));
		System.out.println("Dla x = " + d3.format(maxX));
	}

	void pp3() {
		System.out.println("71.3: ");
			
		// Z wykresu funkcji wiemy ¿e jedno miejsce zerowe maj¹ funkcje f1,f3,f4,f5, oraz znamy ich monotonicznoœæ
		
		// Korzystamy z metody divide and conquer:
		BiConsumer<Double, Boolean> miejsceZerowe = (x, czyMalejaca)->{
			DecimalFormat df5 = new DecimalFormat("0.00000");
			int idFunkcji = (int)Math.floor(x);
			double change = 0.5;
			if(czyMalejaca) {
				change = -0.5;
			}
			while(true) {
				double val = new Double(df5.format(funkcja(idFunkcji, x)).replace(",", "."));
				if(val>0) {
					x -= change;
				} else if(val<0) {
					x += change;
				} else {
					System.out.println(df5.format(x));
					break;
				}
				change /= 2;
			}
		};
		
		// f1 - rosn¹ca:
		miejsceZerowe.accept(0d, false);
		// f3 - malej¹ca:
		miejsceZerowe.accept(2d, true);
		// f4 - rosn¹ca:
		miejsceZerowe.accept(3d, false);
		// f5 - malej¹ca:
		miejsceZerowe.accept(4d, true);
	}
}
