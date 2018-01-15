package com.koitt.java.board;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import person.MyException;
import person.Person;

public class BoardController {
	private BoardController service;
	private Scanner input;
	
	public BoardController() {
		service = new BoardController();
		input = new Scanner(System.in);
	}
	
	public void menuAdd() {
		System.out.println("=== 게시물 등록 (quit: 종료) ===");
		
		System.out.print("제목: ");
		String name = this.input.nextLine();
		
		System.out.print("내용: ");
		String contents = this.input.nextLine();
		
		System.out.print("작성자: ");
		String writer = this.input.nextLine();
		
//		// ?��?��받�? ?��보�?? 객체?��
//		Person p = new Person(name, age);
//		
//		// Service�? ?��?��받�? ?��?�� 객체�? ?��?�� (추�?)
//		try {
//			this.service.add(p);
//			System.out.println("?��?��?���?!!");
//		}
//		catch (MyException e) {
//			// Dao?��?�� 발생?�� ?��?���? service�? 거쳐 ?��기까�? ?�� ?��?�� 출력
//			System.out.println(e.getMessage());
//		}
	}
	
	public void menuRead() {
		System.out.println("=== ?��?��?��?�� ?���? 목록 ===");
		
		// Service�? ?��?�� ?��?��?��?�� ?��?��?��?�� 모두�? 불러?���? 
		List<Person> list = this.service.read();
		
		// for-each문을 ?��?�� list?�� ?���? ?��?��?��?�� ?��?��?��?�� 출력?���?
		for (Person item : list) {
			System.out.println(item);
		}
	}
	
	public void menuRemove() {
		System.out.println("=== ?��?�� ?��보�?? ?��?��?�� 주세?�� (quit: 종료) ===");
		
		System.out.print("?���?: ");
		String name = this.input.nextLine();
		
		Person p = new Person(name, null);
		
		try {
			service.remove(p);
			System.out.println("?��?�� ?���?.");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void menuUpdate() {
		System.out.println("=== ?��?��?�� ?��?�� ?��보�?? ?��?��?�� 주세?�� (quit: 종료) ===");
		
		System.out.print("?���?: ");
		String name = this.input.nextLine();
		
		System.out.print("?��?��: ");
		Integer age = null;
		try {
			age = Integer.parseInt(this.input.nextLine());
		}
		catch (InputMismatchException e) {
			System.out.println("?��?���? ?��?��?��주세?��.");
			return;
		}
		
		// ?��?��받�? ?��보�?? 객체?��
		Person p = new Person(name, age);
		
		try {
			service.update(p);
			System.out.println("?��?��?��?�� ?���?.");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		BoardController controller = new BoardController();
		
		while (true) {
			System.out.println("=== 게시판 메뉴 ===");
			System.out.println("1. 게시물 등록");
			System.out.println("2. 게시물 보기");
			System.out.println("3. 게시물 삭제");
			System.out.println("4. 게시물 수정");
			System.out.println("5. 종료");
			System.out.print("메뉴번호 를 입력하세요. > ");
			
			// ?��?��받�? 메뉴번호
			try {
				int menu = Integer.parseInt(controller.input.nextLine());
				
				switch (menu) {
				case 1:
					controller.menuAdd();
					break;
					
				case 2:
					controller.menuRead();
					break;
					
				case 3:
					controller.menuRemove();
					break;
				case 4:
					controller.menuUpdate();
					break;
				case 5 :
					System.out.println("종료합니다.");
					System.exit(0);	
				default:
					System.out.println("메뉴번호를 확인해주세요.\n");	
			}
			}catch(InputMismatchException e) {
				System.out.println("숫자만 입력 가능합니다.");
				
			}	catch(NumberFormatException e) {
				System.out.println("숫자만 입력 가능합니다.");
			}
			
		}
	}
}
