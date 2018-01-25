package com.koitt.java.board;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class BoardController {
	private BoardService service;
	private Scanner input;

	public BoardController() {
		service = new BoardService();
		input = new Scanner(System.in);
	}

	public void menuAdd() {
		System.out.println(Common.MSG_TITLE_ADD);
		Board b = inputData(null);
		try {
			this.service.add(b);
			System.out.println(Common.MSG_ADD_SUCCESS);
		}catch(BoardException e) {
			System.out.println(e.getMessage());
		}
	}

	public void menuList() {
		System.out.println(Common.MSG_TITLE_LIST);
		System.out.printf("%s %20s %10s %30s\n", Common.MSG_ID, Common.MSG_TITLE, Common.MSG_WRITER, Common.MSG_DATE);
		try {
			Map<Integer, Board> map = this.service.selectAll();
			Iterator<Integer> iterator = map.keySet().iterator();
			while (iterator.hasNext()) {
				Board item = map.get(iterator.next());
				System.out.printf("%d %20s %10s %30s\n", item.getId(), item.getTitle(), item.getWriter(), getTimeString(item.getRegDate()));
			}

			menuDetail();
		}catch(BoardException e) {
			System.out.println(e.getMessage());
		}		
	}

	public void menuDetail() {
		try {
			System.out.println(Common.MSG_TITLE_DETAIL);
			Integer index = Integer.parseInt(this.input.nextLine());
			Board item = service.select(index);

			System.out.println(Common.MSG_TITLE + " : " + item.getTitle());
			System.out.printf("%s: %s  |  %s\n", Common.MSG_WRITER, item.getWriter(), getTimeString(item.getRegDate()));
			System.out.println(item.getContent());
		}catch(Exception e) {
			System.out.println(Common.MSG_NUMBER_INPUT);
		}	
	}

	public void menuRemove() {
		System.out.println(Common.MSG_TITLE_REMOVE);
		System.out.print(Common.MSG_ID + " : ");

		try {
			Integer index = Integer.parseInt(this.input.nextLine());
			service.remove(index);
			System.out.println(Common.MSG_REMOVE_SUCCESS);
		}catch(BoardException e) {
			System.out.println(e.getMessage());
		}

	}

	public void menuModify() {
		System.out.println(Common.MSG_TITLE_MODIFY);

		try {
			System.out.print(Common.MSG_ID + ": ");
			Integer id = Integer.parseInt(this.input.nextLine());
			Board item = service.select(id);

			item = inputData(item);
			try {
				this.service.modify(item);
				System.out.println(Common.MSG_MODIFY_SUCCESS);
			}catch(BoardException e) {
				System.out.println(e.getMessage());
			}
		}catch(InputMismatchException e) {
			System.out.println(Common.MSG_NUMBER_INPUT);
		}catch(BoardException e) {
			System.out.println(e.getMessage());
		}
	}
	
	Board inputData(Board b) {
		System.out.print(Common.MSG_TITLE + ": ");
		String title = this.input.nextLine();
		if(title.contains("quit"))
			return null;
		
		System.out.print(Common.MSG_CONTENT + Common.MSG_WRITE_END + ": ");
		StringBuffer contents = new StringBuffer();

		while(true) {
			String str = this.input.nextLine(); 
			if(str.contains("quit")) {
				break;
			}else {
				contents.append(str+"\n");
			}			
		}
		
		Date now = new Date();
		if(b == null) {
			System.out.print(Common.MSG_WRITER + ": ");
			String writer = this.input.nextLine();
			if(writer.contains("quit"))
				return null;
			return new Board(title, contents.toString(), writer, now);
		}else {
			b.setTitle(title);
			b.setContent(contents.toString());
//			b.setRegDate(now);
			return b;
		}			
	}
	
	String getTimeString(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("YY-M-D h:m");
		return format.format(date);
	}
	
	public static void main(String[] args) {
		BoardController controller = new BoardController();

		while (true) {
			System.out.println(Common.MSG_TITLE_BOARD);
			System.out.println(Common.MSG_MENU_LIST);
			System.out.println(Common.MSG_MENU_ADD);
			System.out.println(Common.MSG_MENU_MODIFY);
			System.out.println(Common.MSG_MENU_REMOVE);
			
			System.out.println(Common.MSG_MENU_CHOICE);

			try {
				int menu = Integer.parseInt(controller.input.nextLine());

				switch (menu) {
				case 1:
					controller.menuList();
					break;

				case 2:
					controller.menuAdd();
					break;

				case 3:
					controller.menuModify();
					break;
				case 4:
					controller.menuRemove();
					break;
				case 5 :
					System.out.println(Common.MSG_QUIT);
					System.exit(0);	
				default:
					System.out.println(Common.MSG_MENU_FAIL);	
				}
			}catch(InputMismatchException e) {
				System.out.println(Common.MSG_NUMBER_INPUT);

			}catch(NumberFormatException e) {
				System.out.println();
			}
			
			System.out.println();
		}
	}
}
