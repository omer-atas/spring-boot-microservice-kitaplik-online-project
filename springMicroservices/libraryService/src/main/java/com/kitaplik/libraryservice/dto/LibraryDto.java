package com.kitaplik.libraryservice.dto;

import java.util.List;

public class LibraryDto {

  private String id;

  private List<BookDto> userBookList;

  public LibraryDto() {}

  public LibraryDto(String id, List<BookDto> userBookList) {
    this.id = id;
    this.userBookList = userBookList;
  }

  public LibraryDto(String id) {
    this.id = id;
    this.userBookList = null;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public List<BookDto> getUserBookList() {
    return userBookList;
  }

  public void setUserBookList(List<BookDto> userBookList) {
    this.userBookList = userBookList;
  }
}
