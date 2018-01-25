package com.koitt.java.board.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.prefs.Preferences;

import com.koitt.java.board.model.Board;

public class FileManager {
	
//	private void saveToFile(List<Board> list, String fileName) {
//		//list boardDao 에 있는 list 필드
//		//fileName: list객체를 저장할 파일 이름
//		
//		FileOutputStream fos = null;
//		ObjectOutputStream oos = null;
//		
//		try {
//			fos = new FileOutputStream(DB_NAME);
//			oos = new ObjectOutputStream(fos);
//			oos.writeObject(list);
////			oos.writeObject(index);
//			if(prefs != null)
//				prefs.putInt("number", index);
//			
//			fos.close();
//			oos.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//	}
//	
//	/*
//	 * fileName: list객체를 저장할 파일 이름
//	 */
//	private List<Board> loadFromFile(String fileName){
//		//파일에서 불러온 list 객체를 리턴
//		FileInputStream fis = null;
//		ObjectInputStream ois = null;
//		List<Board> list = new ArrayList<>();
//		
//		File f = new File(DB_NAME);
//		if(f.exists()) {
//			try {
//				fis = new FileInputStream(DB_NAME);
//				ois = new ObjectInputStream(fis);
//				
//				list = (List<Board>)ois.readObject();
////				index = Integer.parseInt(ois.readObject().toString()); 
//				prefs = Preferences.userRoot().node(this.getClass().getName());
//				index = prefs.getInt("number", 1);
//				
//				return list;
//				
//			} catch (FileNotFoundException e) {
//				//e.printStackTrace();
//				return list;
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (ClassNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}finally {
//				try {
//					if(fis != null)
//						fis.close();
//					if(ois != null)
//						ois.close();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}			
//			}
//		}
//			
//		return list;
//	}
	
}
