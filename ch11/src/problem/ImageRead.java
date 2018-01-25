package problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ImageRead {
	public static void main(String[] args) {
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream("Chrysanthemum.jpg");
			InputStreamReader is = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(is);
//			int a;
//			while((a = fis.read()) != -1) {
//				System.out.println("" + a);
//			}
			
			String data;
			while( (data = br.readLine()) != null) {
				System.out.println(data);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
