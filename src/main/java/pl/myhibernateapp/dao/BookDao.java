package pl.myhibernateapp.dao;

import pl.myhibernateapp.model.Book;

public interface BookDao {
	public void save(Book book);
	public Book get(Long id);

}
