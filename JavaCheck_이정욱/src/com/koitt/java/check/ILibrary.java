package com.koitt.java.check;

public interface ILibrary {
	
	public boolean addBook(Book book);
	
	public boolean delBook(String isbn);
	
	public Book[] allBooks();
	
	public void showAll();
	
	public void showAllBooks();
	
	public void showAllMagazines();
	
	public int size(String type);
	
	public Book getBook(String title);

}
