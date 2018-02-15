package Zadania;

import java.awt.geom.Point2D;
import java.text.DecimalFormat;

public class Zadanie70 {

	double f(double x) {
//		BigDecimal big = new BigDecimal(x*x*x*x/500 - x*x/200 - 3/250 + "");
//		return big.doubleValue();
		return x*x*x*x/500 - x*x/200 - 3/250;
	}
	
	double g(double x) {
		return -x*x*x/30 +x/20 + 1/6;
	}
	
	double poleProstokata = 8*(19 + 61/125 + 32 + 2/3);
	
	public Zadanie70() {
		pp1();
		pp2();
		pp3();
	}

	void pp1() {
		double pole = 0;
		double inc = 0.0001;
		for(double i=2; i<=10; i+=inc) {
			pole += inc*(f(i)-g(i));
		}
		DecimalFormat df5 = new DecimalFormat("0.000");
		System.out.println("70.1: " + df5.format(pole));
	}
	
	void pp2() {
		double dlugoscZaslony = 19 + 61/125 + 32 + 2/3 + 2*8;
		for(double i=2; i<=10-0.008; i+=0.008) {
			Point2D.Double f1 = new Point2D.Double(i, f(i));
			Point2D.Double f2 = new Point2D.Double(i+0.008, f(i+0.008));
			Point2D.Double g1 = new Point2D.Double(i, g(i));
			Point2D.Double g2 = new Point2D.Double(i+0.008, g(i+0.008));
			dlugoscZaslony += f1.distance(f2);
			dlugoscZaslony += g1.distance(g2);
		}
		System.out.println("70.2: " + (int)Math.ceil(dlugoscZaslony));
	}
	
	void pp3() {
		int lacznadlugoscPasow = 0;
		for(double i=9.75; i>2; i-=0.25) {
			lacznadlugoscPasow += Math.abs(f(i) - g(i));
		}
		System.out.println("70.3: " + lacznadlugoscPasow);
	}
}
