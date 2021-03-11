package com.cts.demo.application;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.cts.demo.model.Book;

public class Main {

	public static void main(String[] args) {
		 // TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
Configuration configuration = new Configuration(); 
// If the configuration file is hibernate.cfg.xml , even 
// we need not pass the name within the configure method
		
		configuration.configure();
// It is receiving the configuration information from hibernate.cfg.xml
		
		ServiceRegistry  serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();        
		SessionFactory  sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		  
		 Session session=sessionFactory.openSession();
		 Transaction transaction=session.beginTransaction();
	  	  Book book=new Book();
	  	System.out.println("Enter the book id");
		book.setBookId(scanner.nextInt());
		System.out.println("Enter the title");
		book.setTitle(scanner.next());
		System.out.println("Enter the author name");
		book.setAuthor(scanner.next());
		System.out.println("Enter the price");
		book.setPrice(scanner.nextFloat());
		session.save(book);
          transaction.commit(); 
           session.close();
	}

}
