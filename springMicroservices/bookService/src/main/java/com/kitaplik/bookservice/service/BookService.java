package com.kitaplik.bookservice.service;

import com.kitaplik.bookservice.dto.BookDto;
import com.kitaplik.bookservice.dto.BookIdDto;
import com.kitaplik.bookservice.exception.BookNotFoundException;
import com.kitaplik.bookservice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

  private BookRepository bookRepository;

  @Autowired
  public BookService(final BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  public List<BookDto> getAllBooks() {
    return this.bookRepository.findAll().stream().map(BookDto::from).collect(Collectors.toList());
  }

  public BookIdDto findByIsbn(String isbn) {
    return this.bookRepository
        .getBookByIsbn(isbn)
        .map(book -> new BookIdDto(book.getId(), book.getIsbn()))
        .orElseThrow(() -> new BookNotFoundException("Book could not found by isbn: " + isbn));
  }

  public BookDto findBookDetailsById(String id) {
    return this.bookRepository
        .findById(id)
        .map(BookDto::from)
        .orElseThrow(() -> new BookNotFoundException("Book could not found by id : " + id));
  }
}
