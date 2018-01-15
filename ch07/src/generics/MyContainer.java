package generics;

import java.util.ArrayList;

public class MyContainer<E> {
	private ArrayList<E> list;
	
	public MyContainer() {
		list = new ArrayList<E>();
	}
	
	public E get(int index) {
		return list.get(index);
	}
	
	public void add(E element) {
		list.add(element);		
	}
	
	public <T> T get(T[]array, int index){
		return array[index];
	}
	
	public static void main(String[] args) {
		MyContainer<String> pl = new MyContainer<String>();
		pl.add("algol");
		pl.add("C");
		pl.add("java");
		
		System.out.println(pl.get(0) + "");
		System.out.println(pl.get(1) + "");
		String [] array = {"a", "b"};
		System.out.println(pl.get(array, 1) + "");
		
		
	}
}
