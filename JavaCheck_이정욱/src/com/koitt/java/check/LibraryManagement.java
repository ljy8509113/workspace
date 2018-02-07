package com.koitt.java.check;

import java.util.ArrayList;
import java.util.List;

public class LibraryManagement implements ILibrary {

	private static LibraryManagement instance = null;
	List<Book> listBook;
	int bCount = 0;
	int mCount = 0;
	
	public static LibraryManagement getInstance() {
		if(instance == null)
			instance = new LibraryManagement();
		
		return instance;
	}
	
	public LibraryManagement() {	
		listBook = new ArrayList<Book>();
	}
	
	@Override
	public boolean addBook(Book book) {
		// TODO Auto-generated method stub
		String isbn;
		if(book instanceof Magazine) {
			isbn = "M" + String.format("%03d", ++mCount);
			System.out.println("magazine : " + isbn);
		}else {
			isbn = "B" + String.format("%03d", ++bCount);
			System.out.println("book :" + isbn);
		}
		
		book.setIsbn(isbn);
		listBook.add(book);
		
		return true;
	}

	@Override
	public boolean delBook(String isbn) {
		// TODO Auto-generated method stub
		for(int i=listBook.size()-1; i>=0; i--) {
			if(isbn.equals(listBook.get(i).getIsbn())) {
				if(listBook.get(i) instanceof Magazine) {
					mCount --;
				}else {
					bCount --;
				}
				listBook.remove(i);
				return true;
			}
		}		
		return false;
	}

	@Override
	public Book[] allBooks() {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public void showAll() {
		// TODO Auto-generated method stub
		for(Book b : listBook) {
			if(b instanceof Magazine) {
				Magazine m = (Magazine)b;
				System.out.printf("%s | %s | %s | %s | %d | %s | %d.%02d\n", m.getIsbn(), m.getTitle(), m.getAuthor(), m.getPublisher(), m.getPrice(), m.getDesc(), m.getYear(), m.getMonth());
			}else {
				System.out.printf("%s | %s | %s | %s | %d | %s\n", b.getIsbn(), b.getTitle(), b.getAuthor(), b.getPublisher(), b.getPrice(), b.getDesc());
			}
		}
	}

	@Override
	public void showAllBooks() {
		// TODO Auto-generated method stub
		List<Book> books = new ArrayList<Book>();
		for(Book b : listBook) {
			if( b instanceof Magazine == false) {
				books.add(b);
			}
		}
		
		System.out.println("***** 일반 도서 목록 ***** ");
//		B001 | C++ 기초 플러스 | 윤성일 | 성인당 | 30000 | C++ 기본문법
		for(Book b : books) {
			System.out.printf("%s | %s | %s | %s | %d | %s\n", b.getIsbn(), b.getTitle(), b.getAuthor(), b.getPublisher(), b.getPrice(), b.getDesc());
		}
	}

	@Override
	public void showAllMagazines() {
		// TODO Auto-generated method stub
		List<Magazine> books = new ArrayList<Magazine>();
		for(Book b : listBook) {
			if( b instanceof Magazine == true) {
				books.add((Magazine)b);
			}
		}
		
		System.out.println("***** 잡지 목록 ***** ");
//		B001 | C++ 기초 플러스 | 윤성일 | 성인당 | 30000 | C++ 기본문법
		for(Magazine m : books) {
			System.out.printf("%s | %s | %s | %s | %d | %s | %d.%02d\n", m.getIsbn(), m.getTitle(), m.getAuthor(), m.getPublisher(), m.getPrice(), m.getDesc(), m.getYear(), m.getMonth());
		}
	}

	@Override
	public int size(String type) {
		// TODO Auto-generated method stub
		return listBook.size();
	}

	@Override
	public Book getBook(String title) {
		// TODO Auto-generated method stub
		for(Book b : listBook) {
			if(b.getTitle().equals(title)) {
				return b;
			}
		}
		return null;
	}
	
	

}
