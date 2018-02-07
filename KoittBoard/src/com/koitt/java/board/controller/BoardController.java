package com.koitt.java.board.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.koitt.java.board.exception.BoardException;
import com.koitt.java.board.model.Board;
import com.koitt.java.board.service.BoardService;

public class BoardController {
	
	private BoardService service;
	
	private Scanner input;
	List<Board> list = null;
	
	public BoardController() {
		this.service = new BoardService();
		this.input = new Scanner(System.in);
	}
	
	public static void main(String[] args) {
		BoardController controller = new BoardController();
		
		Scanner input = new Scanner(System.in);
		
		while (true) {
			System.out.println("=== KOITT �Խ��� ===");
			System.out.println("1. �Խñ� �߰�");
			System.out.println("2. �Խñ� ��ü��� ���");
			System.out.println("3. �Խñ� ����");
			System.out.println("4. �Խñ� ����");
			System.out.println("5. ���α׷� ����");
			System.out.print("�޴���ȣ �Է� > ");
			
			// 1.
			int menu = -1;	// try ���ʿ� �ִ� menu ������ �ٱ����� ����.
			try {
				menu = Integer.parseInt(input.nextLine());
			}
			catch (NumberFormatException e) {
				System.out.println("���ڸ� �Է��ϼ���.");
				continue;	// ���� �ݺ����� �ߴ����� �ʰ� �ٽ� ó������ ���ư���.
			}
			
			switch (menu) {
				case 1:
					controller.menuAdd();
					break;
					
				case 2:
					controller.menuRead();
					break;
					
				case 3:
					// 4.
					controller.menuRemove();
					break;
				
				case 4:
					// 4.
					controller.menuModify();
					break;
					
				case 5:
					// 1.
					System.out.println("�ȳ��� ������~");
					input.close();	// ǥ�� ����� ����
					System.exit(0);	// 0: ��������
					break;
					
				default:
					System.out.println("�޴���ȣ�� �ٽ� �Է����ּ���.");
			}
		}
	}

	public void menuAdd() {
		System.out.println("=== �Խñ� �߰� ===");
		
		System.out.print("�� ����: ");
		String title = this.input.nextLine();
		
		System.out.print("�� ����: ");
		String content = this.input.nextLine();
		
		System.out.print("�ۼ���: ");
		String writer = this.input.nextLine();
		
		/*
		 *  id�� null���� ������ Service���� id���� �����ϱ� ������
		 *  regDate�� null���� ������ Controller�� ȭ����� Ŭ�����̱� ������
		 *  regDate�� �ʱ�ȭ�� Service Ŭ������ �ñ��.
		 */															// 7.
		Board board = new Board(null, title, content, writer, null, null);
		
		// 4.
		try {
			// ������ ��ü�� service�� �����Ѵ�.
			this.service.add(board);
			System.out.println("�Է¿Ϸ�!");
			
		} catch (BoardException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println("insert() SQL�� ����");
		}
	}
	
	// 3.
	public void menuRead() {
		System.out.println("=== �Խñ� ��ü��� ��� ===");
		
		try {
			list = this.service.read();
			for (Board item : list) {
				System.out.println(item);
			}
		} catch (SQLException e) {
			System.out.println("selectAll() SQL�� ����");
		}
	}
	
	// 3.
	public void menuRemove() {
		System.out.println("=== �Խñ� ���� ===");
		
		System.out.print("������ �� ��ȣ�� �Է��ϼ���: ");
		
		// 1.
		Integer id = null;
		try {
			id = Integer.parseInt(this.input.nextLine());
		}
		catch (NumberFormatException e) {
			System.out.println("���ڸ� �Է��ϼ���.");
			return;
		}
		
		//Board board = new Board(id, null, null, null, null);
		Board board = new Board();
		board.setId(id);
		
		// 4.
		try {
			if(this.service.remove(board) == 1)
				System.out.println(board.getId() + "���� �Խñ��� �����Ǿ����ϴ�.");
			
		}
		catch (BoardException e) {
			System.out.println(e.getMessage());
		}
	}
	
	// 3.
	public void menuModify() {
		System.out.println("=== �Խñ� ���� ===");
		
		System.out.print("������ �� ��ȣ�� �Է��ϼ���: ");
		
		// 1.
		Integer id = null;
		try {
			id = Integer.parseInt(this.input.nextLine());
		}
		catch (NumberFormatException e) {
			System.out.println("���ڸ� �Է��ϼ���.");
			return;
		}
		
		// 4.
//		Board tempBoard = new Board(id, null, null, null, null, null);
		boolean isExist;
		try {
			isExist = this.service.isExist(id);
			
			if (!isExist) {
				System.out.println("�ش� ��ȣ�� �Խñ��� �������� �ʽ��ϴ�.");
				return;
			}
			
			System.out.print("�� ����: ");
			String title = this.input.nextLine();
			
			System.out.print("�� ����: ");
			String content = this.input.nextLine();
			
			/*
			 * writer: ������� �ʱ� ������ null
			 * regDate: ������� �ʱ� ������ null
			 */														// 8.
			Board board = new Board(id, title, content, null, null, null);
			
			// 4.
			try {
				this.service.modify(board);
				System.out.println(board.getId() + "�� ���� �����Ǿ����ϴ�.");
			}
			catch (BoardException e) {
				System.out.println(e.getMessage());
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
//			e1.printStackTrace();
			System.out.println(e1.getMessage());
		}
		
		
		
	}
}
