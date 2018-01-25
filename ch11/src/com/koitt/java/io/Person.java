package com.koitt.java.io;

import java.io.Serializable;

public class Person implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String address;
	private int age;
	
	public Person(String name, String address, int age) {
		this.name = name;
		this.address = address;
		this.age = age;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Person [name=");
		builder.append(name);
		builder.append(", address=");
		builder.append(address);
		builder.append(", age=");
		builder.append(age);
		builder.append("]");
		return builder.toString();
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public int getAge() {
		return age;
	}
	
	
	
}
