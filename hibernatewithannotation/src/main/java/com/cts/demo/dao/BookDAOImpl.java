package com.cts.demo.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cts.demo.dbutil.DBUtil;
import com.cts.demo.model.Book;

public class BookDAOImpl implements BookDAO {

	private Session session;
	private Transaction transaction;
	
	public void insert(Book book) {
		try {
		  session=DBUtil.getSessionFactory().openSession(); 
          transaction=session.beginTransaction();
          session.save(book);
          transaction.commit();
        
		}catch(HibernateException ex)
		{
			if(transaction!=null)
			{
				transaction.rollback();
			}
		}finally {
		 session.close();	
		}
		
	
	}

	public List displayBooks() {
		session=DBUtil.getSessionFactory().openSession(); 
	   List bookList=session.createQuery("FROM Book").list();
	   return bookList;
	}

	public void delete(int id) {
		try {
		session=DBUtil.getSessionFactory().openSession(); 
	   	transaction=session.beginTransaction();
		Book booktoDelete=(Book)session.get(Book.class, id);
		session.delete(booktoDelete);
		transaction.commit();
		session.close();
		 
		}catch(HibernateException ex)
		{
			if(transaction!=null)
			{
				transaction.rollback();
			}
		}finally {
		 session.close();	
		}
		
	}

}
