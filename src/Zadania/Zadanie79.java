package Zadania;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


public class Zadanie79 {

	class Okrag{
		public double x, y, r;
		
		public Okrag(double x, double y, double r) {
			this.x = x;
			this.y = y;
			this.r = r;
		}
	}
	
	Scanner plik_okregi;
	
	List<Okrag> okregi = new ArrayList<Okrag>();
	
	public Zadanie79() {
		try {
			plik_okregi = new Scanner(new File("Files/79/okregi.txt"));
			plik_okregi.useLocale(Locale.US);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		for(int i=0; i<2000; i++) {
			Okrag okrag = new Okrag(plik_okregi.nextDouble(), plik_okregi.nextDouble(), plik_okregi.nextDouble());
			okregi.add(okrag);
		}
		
		pp1();
		pp2();
		pp3();
		pp4();
	}
	
	void pp1() {
		/* æwiartki:
			I: x>0, y>0
			II: x<0, y<0
			III: x<0, y<0
			IV: x>0, y<0 
		*/
		
		// liczniki dla æwiartek:
		int ile_cw1 = 0;
		int ile_cw2 = 0;
		int ile_cw3 = 0;
		int ile_cw4 = 0;
		int ile_zadna = 0;
		
		for(Okrag okrag: okregi) {
			
			boolean top = okrag.y + okrag.r > 0;
			boolean left = okrag.x - okrag.r > 0;
			boolean bottom = okrag.y - okrag.r > 0;
			boolean right = okrag.x + okrag.r > 0;
			
			if(bottom && left) {
				ile_cw1++;
			} else if(!right && bottom) {
				ile_cw2++;
			} else if(!top && !right) {
				ile_cw3++;
			} else if(left && !top) {
				ile_cw4++;
			} else {
				ile_zadna++;
			}
		}
		
		System.out.println();
		System.out.println("79.1: ");
		System.out.println("Iloœæ okrêgów znajduj¹cych siê w pe³ni w I æwiartce: " + ile_cw1);
		System.out.println("Iloœæ okrêgów znajduj¹cych siê w pe³ni w II æwiartce: " + ile_cw2);
		System.out.println("Iloœæ okrêgów znajduj¹cych siê w pe³ni w III æwiartce: " + ile_cw3);
		System.out.println("Iloœæ okrêgów znajduj¹cych siê w pe³ni w IV æwiartce: " + ile_cw4);
		System.out.println("Iloœæ okrêgów nie znajduj¹cych siê w pe³ni w jakiejkolwiek æwiartce: " + ile_zadna);
		System.out.println();
	}
	
	void pp2() {
		
	}

	void pp3() {
		
	}

	void pp4() {
		
	}

}
