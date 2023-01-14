package com.kitaplik.bookservice.controller;

import com.kitaplik.bookservice.dto.BookDto;
import com.kitaplik.bookservice.dto.BookIdDto;
import com.kitaplik.bookservice.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@RestController
@RequestMapping("/v1/book")
public class BookController {

  Logger logger = LoggerFactory.getLogger(BookController.class);

  private BookService bookService;

  @Autowired
  public BookController(final BookService bookService) {
    this.bookService = bookService;
  }

  @GetMapping("/getAllBook")
  public ResponseEntity<List<BookDto>> getAllBook() {
    return ResponseEntity.ok(this.bookService.getAllBooks());
  }

  @GetMapping("/getBookByIsbn/{isbn}")
  public ResponseEntity<BookIdDto> getBookByIsbn(
      @PathVariable(value = "isbn") @NotEmpty String isbn) {
    logger.info("Book requested by isbn: " + isbn );
    return ResponseEntity.ok(this.bookService.findByIsbn(isbn));
  }

  @GetMapping("/book/{id}")
  public ResponseEntity<BookDto> getBookById(@PathVariable @NotEmpty String id) {
    return ResponseEntity.ok(this.bookService.findBookDetailsById(id));
  }
}
