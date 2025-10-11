package com.geek.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.geek.entity.Book;
import com.geek.entity.Genre;
public interface BookRepository extends JpaRepository<Book, Integer> {
	//findBy<<fieldname>>
	List<Book> findByBookName(String name);
	List<Book> findByGenre(Genre genre);
	//lets write a jpql for search books by authour id
	//select b from Book b where b.authour.authourId=?
	@Query(value = "select b from Book b where b.authour.authourId= :id")
	List<Book> getByAuthourId(@Param("id") int authourId);

}
