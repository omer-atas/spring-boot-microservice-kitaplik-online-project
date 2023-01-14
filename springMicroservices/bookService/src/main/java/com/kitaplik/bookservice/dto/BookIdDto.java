package com.kitaplik.bookservice.dto;

import com.kitaplik.bookservice.model.Book;

public class BookIdDto {

  private String bookId;

  private String isbn;

  public BookIdDto() {}

  public BookIdDto(final String bookId, final String isbn) {
    this.bookId = bookId;
    this.isbn = isbn;
  }

  public static BookIdDto from(Book book) {
    BookIdDto bookIdDto = new BookIdDto();

    bookIdDto.setBookId(book.getId());
    bookIdDto.setIsbn(book.getIsbn());

    return bookIdDto;
  }

  public String getBookId() {
    return bookId;
  }

  public void setBookId(String bookId) {
    this.bookId = bookId;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }
}
