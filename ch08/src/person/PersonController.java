package person;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class PersonController {
	
	private PersonService service;
	private Scanner input;
	
	public PersonController() {
		// Service ?��?��?�� ?��?�� 객체 ?��?��
		this.service = new PersonService();
		
		// ?��?�� ?��보�?? ?��?��받기 ?��?�� 객체 ?��?��
		this.input = new Scanner(System.in);
	}

	public static void main(String[] args) {
		PersonController controller = new PersonController();
		Scanner input = new Scanner(System.in);
		
		while (true) {
			System.out.println("=== ?��?��?��?�� �?�? ?��로그?�� ===");
			System.out.println("1. ?��?��?��?�� ?��?��");
			System.out.println("2. ?��?��?��?�� ?��체출?��");
			System.out.println("3. ?��?��?��?�� ?��?��");
			System.out.println("4. ?��?��?��?�� ?��?��");
			System.out.println("5. ?��로그?�� 종료");
			System.out.print("메뉴번호 ?��?�� > ");
			
			// ?��?��받�? 메뉴번호
			try {
				int menu = Integer.parseInt(input.nextLine());
				
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
					System.out.println("?��로그?�� 종료?��겠습?��?��. ?��?��?�� 계세?��~");
					System.exit(0);	// ?��로그?�� 종료, 0: ?��?��종료, -1: 비정?��종료
					// exit?�� ?��?��?�� ?��?��체제�? ?��?��
				default:
					System.out.println("메뉴 번호�? ?���? ?��?��?��?��?��?��?��.\n");	
			}
			}catch(InputMismatchException e) {
				System.out.println("?��?���? ?��?��?��주세?��.");
				
			}	catch(NumberFormatException e) {
				System.out.println("?��?���? ?��?��?��주세?��.");
			}
			
		}
	}
	
	public void menuAdd() {
		System.out.println("=== ?��?�� ?��보�?? ?��?��?�� 주세?�� (quit: 종료) ===");
		
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
		
		// Service�? ?��?��받�? ?��?�� 객체�? ?��?�� (추�?)
		try {
			this.service.add(p);
			System.out.println("?��?��?���?!!");
		}
		catch (MyException e) {
			// Dao?��?�� 발생?�� ?��?���? service�? 거쳐 ?��기까�? ?�� ?��?�� 출력
			System.out.println(e.getMessage());
		}
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
	
}
