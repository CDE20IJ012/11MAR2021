package com.cts.demo.dao;

import java.util.List;

import com.cts.demo.model.Book;

public interface BookDAO {
   void insert(Book book);
   List displayBooks();
   void delete(int id);
}
