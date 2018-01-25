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
	// 데이터베이스 대신 게시글을 저장하는 용도로 사용
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
				// 1. 기존 등록된 같은 번호의 게시글이 존재할 경우
				throw new BoardException("E01: 중복된 번호의 게시글입니다.");
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
		throw new BoardException("E02: 삭제할 게시글이 존재하지 않습니다.");
	}
	
	// 1.							// 2.
	public void update(Board board) throws BoardException {
		for (Board item : this.list) {
			if (item.equals(board)) {
				/*
				 * id: 검색 조건이기 때문에 변경 필요 없음
				 * writer: 기존 작성한 작성자와 동일하다고 가정해서 변경 필요 없음
				 * regDate: 글 생성일이기 때문에 일자를 변경 필요 없음
				 */
				item.setContent(board.getContent());
				item.setTitle(board.getTitle());
				item.setModiDate(board.getModiDate());
				saveToFile(this.list, DB_NAME);
				return;
			}
		}
		
		// 1.
		throw new BoardException("E03: 수정할 게시글이 존재하지 않습니다.");
	}
	
	// 1. 해당 글이 존재하는지 여부 확인 메소드
	public boolean isExist(Board board) {
		for (Board item : this.list) {
			if (item.equals(board)) {
				return true;	// 글이 존재할 경우 존재한다고 리턴
			}
		}
		
		return false;	// 다 찾아봤는데 없어서 false 리턴
	}
	
	private void saveToFile(List<Board> list, String fileName) {
		//list boardDao 에 있는 list 필드
		//fileName: list객체를 저장할 파일 이름
		
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
	 * fileName: list객체를 저장할 파일 이름
	 */
	private List<Board> loadFromFile(String fileName){
		//파일에서 불러온 list 객체를 리턴
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
