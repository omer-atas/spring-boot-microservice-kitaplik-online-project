package com.kitaplik.bookservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "books")
public class Book {

  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  private String id;

  private String title;

  private String bookYear;

  private String author;

  private String pressName;

  private String isbn;

  public Book() {}

  public Book(
      final String id,
      final String title,
      final String bookYear,
      final String author,
      final String pressName,
      final String isbn) {
    this.id = id;
    this.title = title;
    this.bookYear = bookYear;
    this.author = author;
    this.pressName = pressName;
    this.isbn = isbn;
  }

  public String getId() {
    return id;
  }

  public void setId(final String id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(final String title) {
    this.title = title;
  }

  public String getBookYear() {
    return bookYear;
  }

  public void setBookYear(final String bookYear) {
    this.bookYear = bookYear;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(final String author) {
    this.author = author;
  }

  public String getPressName() {
    return pressName;
  }

  public void setPressName(final String pressName) {
    this.pressName = pressName;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(final String isbn) {
    this.isbn = isbn;
  }
}
