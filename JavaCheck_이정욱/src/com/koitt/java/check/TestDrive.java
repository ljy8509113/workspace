package com.koitt.java.check;

import java.util.Scanner;

public class TestDrive {
	Scanner in;
	public TestDrive(Scanner in) {
		this.in = in;
	}
	
	void menuAdd(boolean isBook) {
		if(isBook) {
			System.out.println(" === 도서 추가 ===");
			System.out.print("제목 : ");
			String title = in.nextLine();
			System.out.print("작가 : ");
			String auther = in.nextLine();
			System.out.print("출판사 : ");
			String publisher = in.nextLine();
			int price;
			while(true) {
				try {
					System.out.print("가격 : ");
					price = Integer.parseInt(in.nextLine());
					break;
				}catch(Exception e) {
					System.out.println("숫자만 입력 가능합니다.");
				}
			}
			System.out.print("분류 : ");
			String desc = in.nextLine();
			
			Book book = new Book(title, auther, publisher, price, desc);
			LibraryManagement.getInstance().addBook(book);
		}else { 
			System.out.println(" === 잡지 추가 ===");
			System.out.print("제목 : ");
			String title = in.nextLine();
			System.out.print("작가 : ");
			String auther = in.nextLine();
			System.out.print("출판사 : ");
			String publisher = in.nextLine();
			int price;
			while(true) {
				try {
					System.out.print("가격 : ");
					price = Integer.parseInt(in.nextLine());
					break;
				}catch(Exception e) {
					System.out.println("숫자만 입력 가능합니다.");
				}
			}
			System.out.print("분류 : ");
			String desc = in.nextLine();
			
			int year;
			while(true) {
				try {
					System.out.print("년도 : ");
					year = Integer.parseInt(in.nextLine());
					break;
				}catch(Exception e) {
					System.out.println("숫자만 입력 가능합니다.");
				}
			}
			
			int month;
			while(true) {
				try {
					System.out.print("월 : ");
					month = Integer.parseInt(in.nextLine());
					break;
				}catch(Exception e) {
					System.out.println("숫자만 입력 가능합니다.");
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
		System.out.print("검색할 도서명 : ");
		String title = in.nextLine();
		Book b = LibraryManagement.getInstance().getBook(title); 
		if(b == null) {
			System.out.println("해당 도서가 존재하지 않습니다.");
		}else {
			
		}
	}
	
	void menuDelete() {
		System.out.println("=== 삭제 ===");
		System.out.print("삭제할 도서 ID를 입력 : ");
		String isbn = in.nextLine();
		if(LibraryManagement.getInstance().delBook(isbn)) {
			System.out.println("해당 도서가 삭제되었습니다.");
		}else {
			System.out.println("해당 도서가 존재하지 않습니다.");
		}
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		TestDrive controller = new TestDrive(input);
		
		while (true) {
			System.out.println("=== 도서입력 프로그램 ===");
			System.out.println("1. 도서 입력");
			System.out.println("2. 잡지 입력");
			System.out.println("3. 모든 도서목록보기");
			System.out.println("4. 도서 목록 보기");
			System.out.println("5. 잡지 목록 보기");
			System.out.println("6. 도서 삭제");
			System.out.println("7. 도서 검색");
			System.out.println("8. 프로그램 종료");
			System.out.print("메뉴번호 입력 > ");
			
			// 1.
			int menu = -1;	// try 안쪽에 있던 menu 변수를 바깥으로 뺐다.
			try {
				menu = Integer.parseInt(input.nextLine());
			}
			catch (NumberFormatException e) {
				System.out.println("숫자만 입력하세요.");
				continue;	// 현재 반복문을 중단하지 않고 다시 처음으로 돌아간다.
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
					System.out.println("안녕히 가세요~");
					input.close();	// 표준 입출력 종료
					System.exit(0);	// 0: 정상종료
					break;
					
				default:
					System.out.println("메뉴번호를 다시 입력해주세요.");
			}
		}
	}
}
