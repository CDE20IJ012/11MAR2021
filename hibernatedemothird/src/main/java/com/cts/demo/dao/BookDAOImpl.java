package com.cts.demo.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cts.demo.dbutil.DBUtil;
import com.cts.demo.model.Book;

public class BookDAOImpl implements BookDAO {

	private Session session;
	private Transaction transaction;
	
	public void insert(Book book) {
		  session=DBUtil.getSessionFactory().openSession(); 
          transaction=session.beginTransaction();
          session.save(book);
          transaction.commit();
          session.close();
	}

}
