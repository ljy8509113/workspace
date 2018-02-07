package com.koitt.java.check;

import java.util.Scanner;

public class TestDrive {
	Scanner in;
	public TestDrive(Scanner in) {
		this.in = in;
	}
	
	void menuAdd(boolean isBook) {
		if(isBook) {
			System.out.println(" === ���� �߰� ===");
			System.out.print("���� : ");
			String title = in.nextLine();
			System.out.print("�۰� : ");
			String auther = in.nextLine();
			System.out.print("���ǻ� : ");
			String publisher = in.nextLine();
			int price;
			while(true) {
				try {
					System.out.print("���� : ");
					price = Integer.parseInt(in.nextLine());
					break;
				}catch(Exception e) {
					System.out.println("���ڸ� �Է� �����մϴ�.");
				}
			}
			System.out.print("�з� : ");
			String desc = in.nextLine();
			
			Book book = new Book(title, auther, publisher, price, desc);
			LibraryManagement.getInstance().addBook(book);
		}else { 
			System.out.println(" === ���� �߰� ===");
			System.out.print("���� : ");
			String title = in.nextLine();
			System.out.print("�۰� : ");
			String auther = in.nextLine();
			System.out.print("���ǻ� : ");
			String publisher = in.nextLine();
			int price;
			while(true) {
				try {
					System.out.print("���� : ");
					price = Integer.parseInt(in.nextLine());
					break;
				}catch(Exception e) {
					System.out.println("���ڸ� �Է� �����մϴ�.");
				}
			}
			System.out.print("�з� : ");
			String desc = in.nextLine();
			
			int year;
			while(true) {
				try {
					System.out.print("�⵵ : ");
					year = Integer.parseInt(in.nextLine());
					break;
				}catch(Exception e) {
					System.out.println("���ڸ� �Է� �����մϴ�.");
				}
			}
			
			int month;
			while(true) {
				try {
					System.out.print("�� : ");
					month = Integer.parseInt(in.nextLine());
					break;
				}catch(Exception e) {
					System.out.println("���ڸ� �Է� �����մϴ�.");
				}
			}
			
			Magazine book = new Magazine(title, auther, publisher, price, desc, year, month);
			LibraryManagement.getInstance().addBook(book);
		}
	}
	
	void menuShowAll() {
		LibraryManagement.getInstance().showAll();
	}
	
	void menuShowBook() {
		LibraryManagement.getInstance().showAllBooks();
	}
	
	void menuShowMagazine() {
		LibraryManagement.getInstance().showAllMagazines();
	}
	
	void menuSearch() {
		System.out.print("�˻��� ������ : ");
		String title = in.nextLine();
		Book b = LibraryManagement.getInstance().getBook(title); 
		if(b == null) {
			System.out.println("�ش� ������ �������� �ʽ��ϴ�.");
		}else {
			
		}
	}
	
	void menuDelete() {
		System.out.println("=== ���� ===");
		System.out.print("������ ���� ID�� �Է� : ");
		String isbn = in.nextLine();
		if(LibraryManagement.getInstance().delBook(isbn)) {
			System.out.println("�ش� ������ �����Ǿ����ϴ�.");
		}else {
			System.out.println("�ش� ������ �������� �ʽ��ϴ�.");
		}
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		TestDrive controller = new TestDrive(input);
		
		while (true) {
			System.out.println("=== �����Է� ���α׷� ===");
			System.out.println("1. ���� �Է�");
			System.out.println("2. ���� �Է�");
			System.out.println("3. ��� ������Ϻ���");
			System.out.println("4. ���� ��� ����");
			System.out.println("5. ���� ��� ����");
			System.out.println("6. ���� ����");
			System.out.println("7. ���� �˻�");
			System.out.println("8. ���α׷� ����");
			System.out.print("�޴���ȣ �Է� > ");
			
			// 1.
			int menu = -1;	// try ���ʿ� �ִ� menu ������ �ٱ����� ����.
			try {
				menu = Integer.parseInt(input.nextLine());
			}
			catch (NumberFormatException e) {
				System.out.println("���ڸ� �Է��ϼ���.");
				continue;	// ���� �ݺ����� �ߴ����� �ʰ� �ٽ� ó������ ���ư���.
			}
			
			switch (menu) {
				case 1:
					controller.menuAdd(true);
					break;
				case 2:
					controller.menuAdd(false);
					break;
				case 3:
					controller.menuShowAll();
					break;
					
				case 4:
					// 4.
					controller.menuShowBook();
					break;
				
				case 5:
					// 4.
					controller.menuShowMagazine();
					break;
				case 6:
					controller.menuDelete();
					break;
				case 7:
					controller.menuSearch();
					break;
				case 8:
					// 1.
					System.out.println("�ȳ��� ������~");
					input.close();	// ǥ�� ����� ����
					System.exit(0);	// 0: ��������
					break;
					
				default:
					System.out.println("�޴���ȣ�� �ٽ� �Է����ּ���.");
			}
		}
	}
}
