package problem;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.net.Socket;

import javax.activation.FileDataSource;

public class Client {
	
	public static void main(String[] args) {
		FileOutputStream fos;
		DataOutputStream dos;
		String fname = "./copyMyClass.txt";
		FileWriter f = new FileWriter(fname);
		try {
			fos = new FileOutputStream(fname);
			dos = new DataOutputStream(fos);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
