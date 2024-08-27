package com.restApi.RestApi.Repo;

import org.springframework.data.repository.CrudRepository;

import com.restApi.RestApi.BookEntity.Book;

public interface BookRepo extends CrudRepository<Book, Integer>{
	
	public Book findById(int id);
	

}
