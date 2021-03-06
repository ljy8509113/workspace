package person;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class PersonController {
	
	private PersonService service;
	private Scanner input;
	
	public PersonController() {
		// Service ?¬?©? ??΄ κ°μ²΄ ??±
		this.service = new PersonService();
		
		// ?¬? ? λ³΄λ?? ?? ₯λ°κΈ° ??΄ κ°μ²΄ ??±
		this.input = new Scanner(System.in);
	}

	public static void main(String[] args) {
		PersonController controller = new PersonController();
		Scanner input = new Scanner(System.in);
		
		while (true) {
			System.out.println("=== ?Έ? ?¬?­ κ΄?λ¦? ?λ‘κ·Έ?¨ ===");
			System.out.println("1. ?Έ? ?¬?­ ?? ₯");
			System.out.println("2. ?Έ? ?¬?­ ? μ²΄μΆ? ₯");
			System.out.println("3. ?Έ? ?¬?­ ?­? ");
			System.out.println("4. ?Έ? ?¬?­ ?? ");
			System.out.println("5. ?λ‘κ·Έ?¨ μ’λ£");
			System.out.print("λ©λ΄λ²νΈ ?? ₯ > ");
			
			// ?? ₯λ°μ? λ©λ΄λ²νΈ
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
					System.out.println("?λ‘κ·Έ?¨ μ’λ£?κ² μ΅??€. ??? κ³μΈ?~");
					System.exit(0);	// ?λ‘κ·Έ?¨ μ’λ£, 0: ? ?μ’λ£, -1: λΉμ ?μ’λ£
					// exit? ?«?? ?΄?μ²΄μ κ°? ?¬?©
				default:
					System.out.println("λ©λ΄ λ²νΈλ₯? ?λͺ? ?? ₯??¨?΅??€.\n");	
			}
			}catch(InputMismatchException e) {
				System.out.println("?«?λ§? ?? ₯?΄μ£ΌμΈ?.");
				
			}	catch(NumberFormatException e) {
				System.out.println("?«?λ§? ?? ₯?΄μ£ΌμΈ?.");
			}
			
		}
	}
	
	public void menuAdd() {
		System.out.println("=== ?¬? ? λ³΄λ?? ?? ₯?΄ μ£ΌμΈ? (quit: μ’λ£) ===");
		
		System.out.print("?΄λ¦?: ");
		String name = this.input.nextLine();
		
		System.out.print("??΄: ");
		Integer age = null;
		try {
			age = Integer.parseInt(this.input.nextLine());
		}
		catch (InputMismatchException e) {
			System.out.println("?«?λ§? ?? ₯?΄μ£ΌμΈ?.");
			return;
		}
		
		// ?? ₯λ°μ? ? λ³΄λ?? κ°μ²΄?
		Person p = new Person(name, age);
		
		// Serviceλ‘? ?? ₯λ°μ? ?¬? κ°μ²΄λ₯? ? ?¬ (μΆκ?)
		try {
			this.service.add(p);
			System.out.println("?? ₯?λ£?!!");
		}
		catch (MyException e) {
			// Dao?? λ°μ? ??Έλ₯? serviceλ₯? κ±°μ³ ?¬κΈ°κΉμ§? ?¨ ?€? μΆλ ₯
			System.out.println(e.getMessage());
		}
	}
	
	public void menuRead() {
		System.out.println("=== ?Έ? ?¬?­ ? μ²? λͺ©λ‘ ===");
		
		// Serviceλ₯? ?΅?΄ ?? ₯?? ?Έ? ?¬?­ λͺ¨λλ₯? λΆλ¬?€κΈ? 
		List<Person> list = this.service.read();
		
		// for-eachλ¬Έμ ?΅?΄ list? ?΄κΈ? ?Έ? ?¬?­ ???? μΆλ ₯?κΈ?
		for (Person item : list) {
			System.out.println(item);
		}
	}
	
	public void menuRemove() {
		System.out.println("=== ?¬? ? λ³΄λ?? ?? ₯?΄ μ£ΌμΈ? (quit: μ’λ£) ===");
		
		System.out.print("?΄λ¦?: ");
		String name = this.input.nextLine();
		
		Person p = new Person(name, null);
		
		try {
			service.remove(p);
			System.out.println("?­?  ?λ£?.");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void menuUpdate() {
		System.out.println("=== ?? ?  ?¬? ? λ³΄λ?? ?? ₯?΄ μ£ΌμΈ? (quit: μ’λ£) ===");
		
		System.out.print("?΄λ¦?: ");
		String name = this.input.nextLine();
		
		System.out.print("??΄: ");
		Integer age = null;
		try {
			age = Integer.parseInt(this.input.nextLine());
		}
		catch (InputMismatchException e) {
			System.out.println("?«?λ§? ?? ₯?΄μ£ΌμΈ?.");
			return;
		}
		
		// ?? ₯λ°μ? ? λ³΄λ?? κ°μ²΄?
		Person p = new Person(name, age);
		
		try {
			service.update(p);
			System.out.println("??°?΄?Έ ?λ£?.");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
