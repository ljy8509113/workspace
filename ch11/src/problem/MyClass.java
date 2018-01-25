package problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;

public class MyClass {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			fis = new FileInputStream("src/problem/MyClass.java");
			fos = new FileOutputStream("MyClass.num");
			InputStreamReader is = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(is);
			String data;
			
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			int index = 1;
			while((data = br.readLine()) != null) {
				oos.writeObject(index+". " + data);
				index++;
			}
			
			br.close();
			oos.close();
			fos.close();
			fis.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		FileInputStream resultFis = null;
		try {
			resultFis = new FileInputStream("MyClass.num");
			InputStreamReader is = new InputStreamReader(resultFis);
			BufferedReader br = new BufferedReader(is);
			
			String str = null;
			while((str = br.readLine()) != null) {
				System.out.println(str);
			}
			
			br.close();
			is.close();
			resultFis.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
