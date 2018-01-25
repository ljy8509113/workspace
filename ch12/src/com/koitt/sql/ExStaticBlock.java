package com.koitt.sql;

public class ExStaticBlock {
	static int staticnum = 20;
	int num = 10;
	static {
		System.out.println("static " + staticnum);
	}
	
	public ExStaticBlock() {
		System.out.println("»ý¼ºÀÚ");
	}
	
	public static void main(String[] args) {
		try {
			ExStaticBlock block = new ExStaticBlock();
			Class.forName("com.koitt.sql.ExStaticBlock");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
