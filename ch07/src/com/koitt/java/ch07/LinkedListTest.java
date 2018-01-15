package com.koitt.java.ch07;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListTest {
	
	public static void main(String[] args) {
//		LinkedList<Object> list = new LinkedList<>();
		ArrayList list = new ArrayList<>();
		list.add("pascal"); list.add(1);
		list.add("java"); list.add(3.4);
		list.add("algol"); list.add(0.87);
		list.add(3, null); list.add(5.8);
		
		Iterator<Object> it = list.iterator();
		print(it);
//		print(list.descendingIterator());
		
		for(Object e : list.toArray()) {
			System.out.print(e + " ");
		}
		System.out.println();
	}
	
	public static void print(Iterator<Object> it) {
		while(it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		System.out.println();
	}
}
