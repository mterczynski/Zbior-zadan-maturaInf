package Zadania;

import java.math.BigInteger;
import java.util.ArrayList;

public class Zadanie67 {

	long fib(int n) {
		if(n == 1 || n== 2) {
			return 1;
		} else {
			return fib(n-1) + fib(n-2);
		}
	}
	
	public Zadanie67() {
		System.out.println("67.1:");
		System.out.println(fib(10));
		System.out.println(fib(20));
		System.out.println(fib(30));
		System.out.println(fib(40));
		pp2();
		pp4();
	}
	
	void pp2() {
		ArrayList<Long> pierwsze = new ArrayList<Long> ();
		for(int i=1; i<=40; i++) {
			long wartosc = fib(i);
			if(new BigInteger(wartosc+"").isProbablePrime(10000)) {
				pierwsze.add(wartosc);
			}
		}
		System.out.println("67.2: " + pierwsze);
	}
	
	void pp4() {
		ArrayList<String> z6jedynkami = new ArrayList<String> ();
		for(int i=1; i<=40; i++) {
			long wartosc = fib(i);
			String bin = Long.toBinaryString(wartosc);
			if(bin.replaceAll("0", "").length() == 6){
				z6jedynkami.add(bin);
			}
			
		}
		System.out.println("67.4: " + z6jedynkami);
	}

}
