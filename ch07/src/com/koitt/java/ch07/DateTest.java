package com.koitt.java.ch07;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class DateTest {
	
	public static void main(String[] args) {
		Date now = new Date();
		System.out.println(now);
		System.out.println(now.getTime());
		
		DateFormat format = DateFormat.getDateInstance(DateFormat.LONG, Locale.KOREA);
		System.out.println(format.format(now));
		System.out.println();
		Date when = new Date(100_000_000_000L);
		System.out.println(when + " == " + (Date)when.clone());
		System.out.println(when.before(now));
				System.out.println(when.equals(now));
						System.out.println(when.compareTo(now));
	}
}
