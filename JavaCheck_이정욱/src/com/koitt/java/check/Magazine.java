package com.koitt.java.check;

public class Magazine extends Book {
	int year;
	int month;
	
	public Magazine( String title, String author, String publisher, int price, String desc, int year, int month) {
		super(title, author, publisher, price, desc);
		this.year = year;
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}
	
}
