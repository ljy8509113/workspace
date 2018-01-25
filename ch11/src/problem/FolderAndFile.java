package problem;

import java.io.File;

public class FolderAndFile {
	public static void main(String[] args) {
		
		File f = new File("C:\\git\\work_java\\workspace\\ch11");
		if(f.exists()) {
			
			File [] list = f.listFiles();
			
			for(File file : list) {
				if(file.isDirectory())
					System.out.println("폴더 : " + file.getName());
				else
					System.out.println("파일 : " + file.getName());
			}
			
		}
	}
}
