package problem;

import java.io.File;
import java.util.Scanner;

public class Rename {
	public static void main(String[] args) {
		if(args != null && args.length == 2) {
			File [] files = new File("./").listFiles();
			
			File file = new File("./"+args[0]);
			
			if(file != null && file.exists()) {
				file.renameTo(new File("./" + args[1]));
				System.out.println("���� �Ϸ�.");
			}else {
				System.out.println("������ �������� �ʽ��ϴ�.");
			}
		}else {
			System.out.println("�Է� ���� ���� !");
		}
		
		
	}
}
