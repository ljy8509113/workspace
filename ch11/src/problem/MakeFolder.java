package problem;

import java.io.File;
import java.util.Scanner;

public class MakeFolder {
	public static void main(String[] args) {
		System.out.println("�������� �Է� : ");
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		
		File f = new File("./"+str);
		if(f.mkdir())
			System.out.println("���� ���� �Ϸ�.");
	}
}
