package problem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
	public static void main(String[] args) {
		if(args != null && args.length == 2) {
			File file = new File("./"+args[0]);
			
			if(file.exists()) {
				FileInputStream fis = null;
				FileOutputStream fos = null;
				try {
					fis = new FileInputStream(args[0]);
					fos = new FileOutputStream(args[1]);
					
					System.out.println("복사시작");
					int data = 0;
					while((data = fis.read()) != -1) {
						fos.write(data);
					}
					System.out.println("복사종료");
					
					fos.close();
					fis.close();
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
