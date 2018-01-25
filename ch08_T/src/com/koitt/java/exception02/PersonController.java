package com.koitt.java.exception02;

import java.util.List;
import java.util.Scanner;

public class PersonController {
	
	private PersonService service;
	private Scanner input;
	
	public PersonController() {
		// Service 사용을 위해 객체 생성
		this.service = new PersonService();
		
		// 사람 정보를 입력받기 위해 객체 생성
		this.input = new Scanner(System.in);
	}

	public static void main(String[] args) {
		PersonController controller = new PersonController();
		Scanner input = new Scanner(System.in);
		
		while (true) {
			System.out.println("=== 인적사항 관리 프로그램 ===");
			System.out.println("1. 인적사항 입력");
			System.out.println("2. 인적사항 전체출력");
			System.out.println("3. 인적사항 삭제");
			System.out.println("4. 인적사항 수정");
			System.out.println("5. 프로그램 종료");
			System.out.print("메뉴번호 입력 > ");
			
			// 입력받은 메뉴번호
			int menu = -1;
			try {
				menu = Integer.parseInt(input.nextLine()); // 한 줄 단위로 입력받음(String 타입)
			}
			catch (NumberFormatException e) {
				System.out.println("메뉴는 숫자로만 입력하세요.");
				continue;
			}
			
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
					controller.menuModify();
					break;
					
				case 5:
					System.out.println("프로그램 종료하겠습니다. 안녕히 계세요~");
					System.exit(0);	// 프로그램 종료, 0: 정상종료, -1: 비정상종료
					// exit의 숫자는 운영체제가 사용
					break;
					
				default:
					System.out.println("메뉴 번호를 잘못 입력하셨습니다.");	
			}
		}
	}
	
	public void menuAdd() {
		System.out.println("=== 사람 정보를 입력해 주세요 (quit: 종료) ===");
		
		System.out.print("이름: ");
		String name = this.input.nextLine();	// 한 줄 입력받음
		
		System.out.print("나이: ");
		Integer age = null;
		try {
			age = Integer.parseInt(this.input.nextLine());	// 한 줄 입력받음
		}
		catch (NumberFormatException e) {
			System.out.println("숫자만 입력해주세요.");
			return;
		}
		catch (Exception e) {
			System.out.println("알 수 없는 예외발생");
			return;
		}
		
		// 입력받은 정보를 객체화
		Person p = new Person(name, age);
		
		// Service로 입력받은 사람 객체를 전달 (추가)
		try {
			this.service.add(p);
			System.out.println("입력완료!!");
		}
		catch (MyException e) {
			// Dao에서 발생한 예외를 service를 거쳐 여기까지 온 다음 출력
			System.out.println(e.getMessage());
		}
	}
	
	public void menuRead() {
		System.out.println("=== 인적사항 전체 목록 ===");
		
		// Service를 통해 입력했던 인적사항 모두를 불러오기 
		List<Person> list = this.service.read();
		
		// for-each문을 통해 list에 담긴 인적사항 하나하나 출력하기
		for (Person item : list) {
			System.out.println(item);
		}
	}
	
	public void menuRemove() {
		System.out.println("=== 삭제할 사람 정보를 입력해 주세요 ===");
		
		System.out.print("이름: ");
		String name = this.input.nextLine();	// 한 줄 입력받음
		
		Person p = new Person(name, null);
		
		try {
			service.remove(p);
			System.out.println(p.getName() + "님이 삭제 되었습니다.");
		}
		catch (MyException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void menuModify() {
		System.out.println("=== 수정할 사람 정보를 입력해 주세요 ===");
		
		System.out.print("이름: ");
		String name = this.input.nextLine();
		
		System.out.print("나이: ");
		Integer age = Integer.parseInt(this.input.nextLine());
		
		Person p = new Person(name, age);
		
		try {
			service.modify(p);
			System.out.println(p.getName() + "님의 정보가 수정되었습니다.");
		}
		catch (MyException e) {
			System.out.println(e.getMessage());
		}
	}
}
