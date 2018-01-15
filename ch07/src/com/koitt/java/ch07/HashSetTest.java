package com.koitt.java.ch07;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.SortedMap;


public class HashSetTest {
	
	
	public static void main(String[] args) {
		HashSet<Integer> setA = new HashSet<Integer>();
		HashSet<Integer> setB = new HashSet<Integer>();
		
		
		setA.add(3);
		setA.add(5);
		setA.add(7);
		setA.add(8);
		setA.add(7);
		setA.add(9);
		
		System.out.println("A = " + setA);
		
		setB.add(5);
		setB.add(3);
		setB.add(2);
		setB.add(5);

		System.out.println("before B : " + setB);
		
		System.out.print("B = ");
		
		print(setB);
		System.out.println(" B : " + setB);
		
		boolean isChanged = setA.removeAll(setB);
		System.out.print("A - B = ");
		if(isChanged) System.out.println(setA);
	}
	
	public static void print(HashSet<Integer> s) {
		Iterator<Integer> i = s.iterator();
		while(i.hasNext())
			System.out.print(i.next());
	}
}
