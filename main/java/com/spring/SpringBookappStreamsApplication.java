package com.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.service.IBookService;

@SpringBootApplication
public class SpringBookappStreamsApplication implements CommandLineRunner{

	
	private IBookService iBookService;
	
	@Autowired
	public void setiBookService(IBookService iBookService) {
		this.iBookService = iBookService;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBookappStreamsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		iBookService.getAll().forEach(System.out::println);
		
		System.out.println("Book by Id - 4");
		System.out.println(iBookService.getById(4));
		
		System.out.println("Books by title contains Java");
		iBookService.getByTitleContains("Java").forEach(System.out::println);
		
		System.out.println("getByAuthCategory");
		iBookService.getByAuthCategory("joe", "selfhelp").forEach(System.out::println);
		
		System.out.println("getByLesserPrice");
		iBookService.getByLesserPrice(1000).forEach(System.out::println);
	}

	
}
