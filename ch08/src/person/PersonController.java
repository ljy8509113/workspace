package person;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class PersonController {
	
	private PersonService service;
	private Scanner input;
	
	public PersonController() {
		// Service ?‚¬?š©?„ ?œ„?•´ ê°ì²´ ?ƒ?„±
		this.service = new PersonService();
		
		// ?‚¬?Œ ? •ë³´ë?? ?…? ¥ë°›ê¸° ?œ„?•´ ê°ì²´ ?ƒ?„±
		this.input = new Scanner(System.in);
	}

	public static void main(String[] args) {
		PersonController controller = new PersonController();
		Scanner input = new Scanner(System.in);
		
		while (true) {
			System.out.println("=== ?¸? ?‚¬?•­ ê´?ë¦? ?”„ë¡œê·¸?¨ ===");
			System.out.println("1. ?¸? ?‚¬?•­ ?…? ¥");
			System.out.println("2. ?¸? ?‚¬?•­ ? „ì²´ì¶œ? ¥");
			System.out.println("3. ?¸? ?‚¬?•­ ?‚­? œ");
			System.out.println("4. ?¸? ?‚¬?•­ ?ˆ˜? •");
			System.out.println("5. ?”„ë¡œê·¸?¨ ì¢…ë£Œ");
			System.out.print("ë©”ë‰´ë²ˆí˜¸ ?…? ¥ > ");
			
			// ?…? ¥ë°›ì? ë©”ë‰´ë²ˆí˜¸
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
					System.out.println("?”„ë¡œê·¸?¨ ì¢…ë£Œ?•˜ê² ìŠµ?‹ˆ?‹¤. ?•ˆ?…•?ˆ ê³„ì„¸?š”~");
					System.exit(0);	// ?”„ë¡œê·¸?¨ ì¢…ë£Œ, 0: ? •?ƒì¢…ë£Œ, -1: ë¹„ì •?ƒì¢…ë£Œ
					// exit?˜ ?ˆ«??Š” ?š´?˜ì²´ì œê°? ?‚¬?š©
				default:
					System.out.println("ë©”ë‰´ ë²ˆí˜¸ë¥? ?˜ëª? ?…? ¥?•˜?…¨?Šµ?‹ˆ?‹¤.\n");	
			}
			}catch(InputMismatchException e) {
				System.out.println("?ˆ«?ë§? ?…? ¥?•´ì£¼ì„¸?š”.");
				
			}	catch(NumberFormatException e) {
				System.out.println("?ˆ«?ë§? ?…? ¥?•´ì£¼ì„¸?š”.");
			}
			
		}
	}
	
	public void menuAdd() {
		System.out.println("=== ?‚¬?Œ ? •ë³´ë?? ?…? ¥?•´ ì£¼ì„¸?š” (quit: ì¢…ë£Œ) ===");
		
		System.out.print("?´ë¦?: ");
		String name = this.input.nextLine();
		
		System.out.print("?‚˜?´: ");
		Integer age = null;
		try {
			age = Integer.parseInt(this.input.nextLine());
		}
		catch (InputMismatchException e) {
			System.out.println("?ˆ«?ë§? ?…? ¥?•´ì£¼ì„¸?š”.");
			return;
		}
		
		// ?…? ¥ë°›ì? ? •ë³´ë?? ê°ì²´?™”
		Person p = new Person(name, age);
		
		// Serviceë¡? ?…? ¥ë°›ì? ?‚¬?Œ ê°ì²´ë¥? ? „?‹¬ (ì¶”ê?)
		try {
			this.service.add(p);
			System.out.println("?…? ¥?™„ë£?!!");
		}
		catch (MyException e) {
			// Dao?—?„œ ë°œìƒ?•œ ?˜ˆ?™¸ë¥? serviceë¥? ê±°ì³ ?—¬ê¸°ê¹Œì§? ?˜¨ ?‹¤?Œ ì¶œë ¥
			System.out.println(e.getMessage());
		}
	}
	
	public void menuRead() {
		System.out.println("=== ?¸? ?‚¬?•­ ? „ì²? ëª©ë¡ ===");
		
		// Serviceë¥? ?†µ?•´ ?…? ¥?–ˆ?˜ ?¸? ?‚¬?•­ ëª¨ë‘ë¥? ë¶ˆëŸ¬?˜¤ê¸? 
		List<Person> list = this.service.read();
		
		// for-eachë¬¸ì„ ?†µ?•´ list?— ?‹´ê¸? ?¸? ?‚¬?•­ ?•˜?‚˜?•˜?‚˜ ì¶œë ¥?•˜ê¸?
		for (Person item : list) {
			System.out.println(item);
		}
	}
	
	public void menuRemove() {
		System.out.println("=== ?‚¬?Œ ? •ë³´ë?? ?…? ¥?•´ ì£¼ì„¸?š” (quit: ì¢…ë£Œ) ===");
		
		System.out.print("?´ë¦?: ");
		String name = this.input.nextLine();
		
		Person p = new Person(name, null);
		
		try {
			service.remove(p);
			System.out.println("?‚­? œ ?™„ë£?.");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void menuUpdate() {
		System.out.println("=== ?ˆ˜? •?•  ?‚¬?Œ ? •ë³´ë?? ?…? ¥?•´ ì£¼ì„¸?š” (quit: ì¢…ë£Œ) ===");
		
		System.out.print("?´ë¦?: ");
		String name = this.input.nextLine();
		
		System.out.print("?‚˜?´: ");
		Integer age = null;
		try {
			age = Integer.parseInt(this.input.nextLine());
		}
		catch (InputMismatchException e) {
			System.out.println("?ˆ«?ë§? ?…? ¥?•´ì£¼ì„¸?š”.");
			return;
		}
		
		// ?…? ¥ë°›ì? ? •ë³´ë?? ê°ì²´?™”
		Person p = new Person(name, age);
		
		try {
			service.update(p);
			System.out.println("?—…?°?´?Š¸ ?™„ë£?.");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
