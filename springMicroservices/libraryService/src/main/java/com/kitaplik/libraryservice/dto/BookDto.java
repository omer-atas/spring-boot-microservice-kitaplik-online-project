package com.kitaplik.libraryservice.dto;

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

  public BookDto(BookIdDto id) {
    this.id = id;
    this.title = "default-title";
    this.bookYear = "default-bookYear";
    this.author = "default-author";
    this.pressName = "default-pressName";
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
