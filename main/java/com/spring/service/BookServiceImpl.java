package com.spring.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.exception.BookNotFoundException;
import com.spring.model.Book;
import com.spring.util.BookDetails;

@Service
public class BookServiceImpl implements IBookService{

	private BookDetails bookdetails;
	private List<Book> books;
	
	@Autowired
	public void setBookdetails(BookDetails bookdetails) {
		this.bookdetails = bookdetails;
	}

	@Override
	public List<Book> getAll() 
	{
		books = bookdetails.showBooks();
		if (books.isEmpty()) 
		{
			throw new BookNotFoundException("No Books available");
		}
		//this will order the list by ID
		return books.stream().sorted(Comparator.comparing(Book::getBookId)).toList();
//		will order the list by title
//		return books.stream().sorted().toList(); 
	}

	@Override
	public Book getById(int bookId) throws BookNotFoundException 
	{
		books = bookdetails.showBooks();
		
		for (Book book : books) 
		{
			if (book.getBookId() == bookId)
				return book;
		}
		throw new BookNotFoundException("Invalid Book id");
	}

	@Override
	public List<Book> getByTitleContains(String title) throws BookNotFoundException 
	{
		books = bookdetails.showBooks();
		List<Book> booksByTitle = new ArrayList<>();
		for (Book book : books) {
			if (book.getTitle().contains(title))  
				booksByTitle.add(book);
		}
		if(booksByTitle.isEmpty()) {
			throw new BookNotFoundException("Book containing the title does not exist");
		 }
		return booksByTitle.stream().sorted().toList();
	}

	@Override
	public List<Book> getByAuthCategory(String author, String category) throws BookNotFoundException 
	{
		books = bookdetails.showBooks();
		List<Book> booksByAuth = new ArrayList<>();
		for (Book book : books) {
			if (book.getAuthor().equalsIgnoreCase(author) && book.getCategory().equalsIgnoreCase(category))  
				booksByAuth.add(book);
		}
					
		if(booksByAuth.isEmpty()) {
			throw new BookNotFoundException("book with this auth in category does not exist");
		 }
		return booksByAuth.stream().sorted().toList();
	}

	@Override
	public List<Book> getByLesserPrice(double price) throws BookNotFoundException 
	{
		books = bookdetails.showBooks();
		List<Book> booksByLesserPrice = new ArrayList<>();
		for (Book book : books) {
			if (book.getPrice()<price)  
				booksByLesserPrice.add(book);
		}
		if(booksByLesserPrice.isEmpty()) {
			throw new BookNotFoundException("book with this auth in category does not exist");
		 }
		return booksByLesserPrice.stream().sorted(Comparator.comparing(Book::getPrice)).toList();
	}
}
