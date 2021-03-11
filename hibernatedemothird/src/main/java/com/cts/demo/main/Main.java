package com.cts.demo.main;

import java.util.Scanner;

import com.cts.demo.dao.BookDAO;
import com.cts.demo.dao.BookDAOImpl;
import com.cts.demo.model.Book;

public class Main {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		Book book=new Book();
		System.out.println("Enter the book id");
		book.setBookId(scanner.nextInt());
		System.out.println("Enter the title");
		book.setTitle(scanner.next());
		System.out.println("Enter the author name");
		book.setAuthor(scanner.next());
		System.out.println("Enter the price");
		book.setPrice(scanner.nextFloat());
		BookDAO bookDAO=new BookDAOImpl();
		bookDAO.insert(book);
		

	}

}
