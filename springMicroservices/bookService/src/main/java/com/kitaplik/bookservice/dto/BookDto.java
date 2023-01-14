package com.kitaplik.bookservice.dto;

import com.kitaplik.bookservice.model.Book;

public class BookDto {

  private BookIdDto id;

  private String title;

  private String bookYear;

  private String author;

  private String pressName;

  public BookDto() {}

  public BookDto(BookIdDto id, String title, String bookYear, String author, String pressName) {
    this.id = id;
    this.title = title;
    this.bookYear = bookYear;
    this.author = author;
    this.pressName = pressName;
  }

  public static BookDto from(Book book) {
    BookDto bookDto = new BookDto();

    BookIdDto id = new BookIdDto();
    id.setBookId(book.getId());
    id.setIsbn(book.getIsbn());

    bookDto.setId(id);
    bookDto.setTitle(book.getTitle());
    bookDto.setBookYear(book.getBookYear());
    bookDto.setAuthor(book.getAuthor());
    bookDto.setPressName(book.getPressName());

    return bookDto;
  }

  public BookIdDto getId() {
    return id;
  }

  public void setId(BookIdDto id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getBookYear() {
    return bookYear;
  }

  public void setBookYear(String bookYear) {
    this.bookYear = bookYear;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getPressName() {
    return pressName;
  }

  public void setPressName(String pressName) {
    this.pressName = pressName;
  }
}
