package vo;

import java.io.Serializable;
import java.util.Date;

public class Book implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer isbn;	 			//글번호
	private String title;			//제목
	private String author;	//내용
	private String publicsher;		//작성자
	private Date regdate;		//작성일
	private int price;
	private String description;
	
	public Book() {
	}
	
	public Book(String title, String author, String publicsher, int price, String description) {
		this.title = title;
		this.author = author;
		this.publicsher = publicsher;
		this.price = price;
		this.description = description;				
	}

	public Integer getIsbn() {
		return isbn;
	}

	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublicsher() {
		return publicsher;
	}

	public void setPublicsher(String publicsher) {
		this.publicsher = publicsher;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + price;
		result = prime * result + ((publicsher == null) ? 0 : publicsher.hashCode());
		result = prime * result + ((regdate == null) ? 0 : regdate.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if(obj instanceof Book == false)
			return false;
		
		Book other = (Book) obj;
		if(other.getIsbn() == this.isbn)
			return true;
		
		return false;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Book [isbn=");
		builder.append(isbn);
		builder.append(", title=");
		builder.append(title);
		builder.append(", author=");
		builder.append(author);
		builder.append(", publicsher=");
		builder.append(publicsher);
		builder.append(", regdate=");
		builder.append(regdate);
		builder.append(", price=");
		builder.append(price);
		builder.append(", description=");
		builder.append(description);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
