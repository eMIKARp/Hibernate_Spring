package pl.myhibernateapp;


import org.springframework.context.annotation.*;
import pl.myhibernateapp.dao.BookDao;
import pl.myhibernateapp.dao.BookDaoImpl;
import pl.myhibernateapp.model.Book;

@Configuration
@ComponentScan
public class SpringJpaApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringJpaApplication.class);
		BookDao bookDao = ctx.getBean(BookDao.class);
		Book book = new Book("1234567890468", "Spring is so cool", "Javastart");
        bookDao.save(book);
        Book bookGet = bookDao.get(1L);
        System.out.println(bookGet);
        ctx.close();
		
	}
	
}
