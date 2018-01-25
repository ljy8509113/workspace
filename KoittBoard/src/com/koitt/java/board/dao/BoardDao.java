package com.koitt.java.board.dao;

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

import com.koitt.java.board.exception.BoardException;
import com.koitt.java.board.model.Board;

public class BoardDao {
	public static final String DB_NAME = "db.bat";
	// �����ͺ��̽� ��� �Խñ��� �����ϴ� �뵵�� ���
	private List<Board> list;
	private int index = 0;
	Preferences prefs;
	
	public BoardDao() {
//		this.list = new ArrayList<Board>();
		this.list = loadFromFile(DB_NAME);
	}
									// 2.
	public void insert(Board board) throws BoardException {
		for (Board item : this.list) {
			if (item.equals(board)) {
				// 1. ���� ��ϵ� ���� ��ȣ�� �Խñ��� ������ ���
				throw new BoardException("E01: �ߺ��� ��ȣ�� �Խñ��Դϴ�.");
			}
		}
		
		list.add(board);
		saveToFile(this.list, DB_NAME);
	}
	
	// 1.
	public List<Board> selectAll() {
		return this.list;
	}
	
	// 1.							// 2.
	public void delete(Board board) throws BoardException {
		for (int i = 0; i < this.list.size(); i++) {
			if (this.list.get(i).equals(board)) {
				this.list.remove(this.list.get(i));
				saveToFile(this.list, DB_NAME);
				return;
			}
		}
		
		// 1.
		throw new BoardException("E02: ������ �Խñ��� �������� �ʽ��ϴ�.");
	}
	
	// 1.							// 2.
	public void update(Board board) throws BoardException {
		for (Board item : this.list) {
			if (item.equals(board)) {
				/*
				 * id: �˻� �����̱� ������ ���� �ʿ� ����
				 * writer: ���� �ۼ��� �ۼ��ڿ� �����ϴٰ� �����ؼ� ���� �ʿ� ����
				 * regDate: �� �������̱� ������ ���ڸ� ���� �ʿ� ����
				 */
				item.setContent(board.getContent());
				item.setTitle(board.getTitle());
				item.setModiDate(board.getModiDate());
				saveToFile(this.list, DB_NAME);
				return;
			}
		}
		
		// 1.
		throw new BoardException("E03: ������ �Խñ��� �������� �ʽ��ϴ�.");
	}
	
	// 1. �ش� ���� �����ϴ��� ���� Ȯ�� �޼ҵ�
	public boolean isExist(Board board) {
		for (Board item : this.list) {
			if (item.equals(board)) {
				return true;	// ���� ������ ��� �����Ѵٰ� ����
			}
		}
		
		return false;	// �� ã�ƺôµ� ��� false ����
	}
	
	private void saveToFile(List<Board> list, String fileName) {
		//list boardDao �� �ִ� list �ʵ�
		//fileName: list��ü�� ������ ���� �̸�
		
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try {
			fos = new FileOutputStream(DB_NAME);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(list);
//			oos.writeObject(index);
			if(prefs != null)
				prefs.putInt("number", index);
			
			fos.close();
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	/*
	 * fileName: list��ü�� ������ ���� �̸�
	 */
	private List<Board> loadFromFile(String fileName){
		//���Ͽ��� �ҷ��� list ��ü�� ����
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		List<Board> list = new ArrayList<>();
		
		File f = new File(DB_NAME);
		if(f.exists()) {
			try {
				fis = new FileInputStream(DB_NAME);
				ois = new ObjectInputStream(fis);
				
				list = (List<Board>)ois.readObject();
//				index = Integer.parseInt(ois.readObject().toString()); 
				prefs = Preferences.userNodeForPackage(BoardDao.class);
				index = prefs.getInt("number", 1);
				
				return list;
				
			} catch (FileNotFoundException e) {
				//e.printStackTrace();
				return list;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					if(fis != null)
						fis.close();
					if(ois != null)
						ois.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
			}
		}
			
		return list;
	}
	
	public int makeIndex() {
		return index += 1;
	}
}
