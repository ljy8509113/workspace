package com.koitt.java.ch07;

import java.util.StringTokenizer;

public class StringTokenizerTest {
	public static void main(String[] args) {

		String str = "public static void main(String[] args) {";
		StringTokenizer st1 = new StringTokenizer(str);
		printToken(st1);
		StringTokenizer st2 = new StringTokenizer(str, " ()");
		printToken(st2);
		StringTokenizer st3 = new StringTokenizer(str, " ()[]{");
		printToken(st3);
		StringTokenizer st4 = new StringTokenizer(str, " ()[]{", true);
		printToken(st4);
		StringTokenizer st5 = new StringTokenizer(str);
		printToken(st5, "()");
		
		
	}
	
	public static void printToken(StringTokenizer st) {
		System.out.println("토큰 수 :"+st.countTokens());
		int cnt = 0;
		while(st.hasMoreTokens()) {
			System.out.print(++cnt + "."+st.nextToken() + " ");
		}
		System.out.println();
	}
	
	public static void printToken(StringTokenizer st, String delim) {
		int cnt = 0;
		while(st.hasMoreTokens()) {
			System.out.print(++cnt + "."+st.nextToken(delim) + " ");
		}
		System.out.println();
	}
}
