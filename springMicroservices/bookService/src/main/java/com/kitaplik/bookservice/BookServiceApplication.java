package com.kitaplik.bookservice;

import com.kitaplik.bookservice.model.Book;
import com.kitaplik.bookservice.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class BookServiceApplication implements CommandLineRunner {

  private BookRepository bookRepository;

  public BookServiceApplication(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  public static void main(String[] args) {
    SpringApplication.run(BookServiceApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {

    Book book = new Book("1", "abc", "2013", "author", "pressName", "isbn1");
    Book book2 = new Book("2", "abc", "2013", "author", "pressName", "isbn2");
    Book book3 = new Book("3", "abc", "2013", "author", "pressName", "isbn3");

    List<Book> books = this.bookRepository.saveAll(Arrays.asList(book, book2, book3));

    for (Book b : books) {
      System.out.println(b.getId() + " " + b.getIsbn());
    }
  }
}
