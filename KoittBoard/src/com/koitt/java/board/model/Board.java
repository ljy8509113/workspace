package com.koitt.java.board.model;

import java.io.Serializable;
import java.util.Date;

// Java Bean �����
public class Board implements Serializable {
	private Integer id;		// �� ��ȣ
	private String title;	// �� ����
	private String content;	// �� ����
	private String writer;	// �ۼ���
	private Date regDate;	// �� ������
	
	// 1.
	private Date modiDate;	// �� ������ 
	
	// 1. �⺻ ������
	public Board() {}

	// 2. ������ (��� �ʵ� �ʱ�ȭ)														// 2.
	public Board(Integer id, String title, String content, String writer, Date regDate, Date modiDate) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.regDate = regDate;
		
		// 3.
		this.modiDate = modiDate;
	}

	// 3. getter, setter
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	// 4.
	public Date getModiDate() {
		return modiDate;
	}

	public void setModiDate(Date modiDate) {
		this.modiDate = modiDate;
	}

	// 4. hashCode
	@Override
	public int hashCode() {
		return this.id.hashCode() + this.content.hashCode() + this.title.hashCode() + 
				this.writer.hashCode() + this.regDate.hashCode() + /* 5. */this.modiDate.hashCode();
	}
	
	// 5. equals
	@Override
	public boolean equals(Object obj) {
		
		// 5-1. ��ü �ּ� ��
		if (this == obj) {
			return true;
		}
		
		// 5-2. Argument�� Board�� ��ӹ޾Ҵ��� �˻�
		if (!(obj instanceof Board)) {
			return false;
		}
		
		// 5-3. Argument �ٿ�ĳ����
		Board b = (Board) obj;
		if (this.id.equals(b.id)) {
			return true;
		}
		
		return false;
	}
	
	// 6. toString
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Board [id=");
		builder.append(id);
		builder.append(", title=");
		builder.append(title);
		builder.append(", content=");
		builder.append(content);
		builder.append(", writer=");
		builder.append(writer);
		builder.append(", regDate=");
		builder.append(regDate);
		builder.append(", modiDate=");
		builder.append(modiDate);
		builder.append("]");
		return builder.toString();
	}	
}
