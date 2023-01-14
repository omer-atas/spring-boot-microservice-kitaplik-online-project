package com.kitaplik.libraryservice.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "libraries")
public class Library {

  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(name = "library_id")
  private String id;

  @ElementCollection private List<String> userBookList = new ArrayList<>();

  public Library() {}

  public Library(String id, List<String> userBookList) {
    this.id = id;
    this.userBookList = userBookList;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public List<String> getUserBookList() {
    return userBookList;
  }

  public void setUserBookList(List<String> userBookList) {
    this.userBookList = userBookList;
  }
}
