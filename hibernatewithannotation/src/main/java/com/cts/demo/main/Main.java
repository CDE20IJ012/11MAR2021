package com.cts.demo.main;

import java.util.List;
import java.util.Scanner;

import com.cts.demo.dao.BookDAO;
import com.cts.demo.dao.BookDAOImpl;
import com.cts.demo.model.Book;

public class Main {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int ch=0;
		BookDAO bookDAO=new BookDAOImpl();
		while(true)
		{
		 System.out.println("1) ADD BOOKS \n 2) DISPLAY BOOKS\n 3)DELETE A BOOK \n 4) EXIT");
		 System.out.println("Enter your choice");
		 ch=scanner.nextInt();
		 switch(ch)
		 {
		 case 1 : Book book=new Book();
		System.out.println("Enter the book id");
		book.setBookId(scanner.nextInt());
		System.out.println("Enter the title");
		book.setTitle(scanner.next());
		System.out.println("Enter the author name");
		book.setAuthor(scanner.next());
		System.out.println("Enter the price");
		book.setPrice(scanner.nextFloat());
	
		bookDAO.insert(book);
		break;
		
		 case 2  : List list=bookDAO.displayBooks();
		           for(Object obj : list)
		           {
		        	   Book book1=(Book)obj;
		        	   System.out.println(book1.getBookId()+" "+book1.getTitle());
		           }
	
		 break;
		 case 3 : System.out.println("Enter the id of the book to be deleted");
		 int bookToBeDeleted=scanner.nextInt();
		 bookDAO.delete(bookToBeDeleted);
		 break;
		case 4 : System.exit(0);
		 }  // end of switch
		}  // end of while loop

		
	}

}
