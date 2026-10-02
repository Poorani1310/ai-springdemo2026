package com.spring.model;

public class Book implements Comparable<Book>{
	
	private String title;
	private Integer bookId; 
	private String author;
	private String category;
	private Integer price;
	
	public Book() 
	{
		super();
	}

	public Book(String title, Integer bookId, String author, String category, Integer price) {
		super();
		this.title = title;
		this.bookId = bookId;
		this.author = author;
		this.category = category;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", bookId=" + bookId + ", author=" + author + ", category=" + category
				+ ", price=" + price + "]";
	}

	@Override
	public int compareTo(Book o) {
		return this.title.compareTo(o.getTitle());
	}
	
	
}
