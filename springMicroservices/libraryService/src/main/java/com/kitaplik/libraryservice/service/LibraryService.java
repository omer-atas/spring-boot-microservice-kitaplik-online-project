package com.kitaplik.libraryservice.service;

import com.kitaplik.libraryservice.client.BookServiceClient;
import com.kitaplik.libraryservice.dto.AddBookRequest;
import com.kitaplik.libraryservice.dto.BookDto;
import com.kitaplik.libraryservice.dto.BookIdDto;
import com.kitaplik.libraryservice.dto.LibraryDto;
import com.kitaplik.libraryservice.exception.LibraryNotFoundException;
import com.kitaplik.libraryservice.model.Library;
import com.kitaplik.libraryservice.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibraryService {

  private LibraryRepository libraryRepository;

  private BookServiceClient bookServiceClient;

  @Autowired
  public LibraryService(LibraryRepository libraryRepository, BookServiceClient bookServiceClient) {
    this.libraryRepository = libraryRepository;
    this.bookServiceClient = bookServiceClient;
  }

  public LibraryDto getAllBooksInLibraryById(String id) {

    Library library =
        this.libraryRepository
            .findById(id)
            .orElseThrow(
                () -> new LibraryNotFoundException("Library could not found by id : " + id));

    List<BookDto> collectUserBookList =
        library.getUserBookList().stream()
            .map(book -> this.bookServiceClient.getBookById(book).getBody())
            .collect(Collectors.toList());

    LibraryDto libraryDto = new LibraryDto(library.getId(), collectUserBookList);

    return libraryDto;
  }

  public LibraryDto createLibrary() {
    Library newLibrary = this.libraryRepository.save(new Library());
    return new LibraryDto(newLibrary.getId());
  }

  public void addBookToLibrary(AddBookRequest request) {

    ResponseEntity<BookIdDto> bookByIsbn = this.bookServiceClient.getBookByIsbn(request.getIsbn());
    String bookId = bookByIsbn.getBody().getBookId();

    Library library =
        libraryRepository
            .findById(request.getId())
            .orElseThrow(
                () ->
                    new LibraryNotFoundException(
                        "Library could not found by id: " + request.getId()));

    library.getUserBookList().add(bookId);

    libraryRepository.save(library);
  }

    public List<String> getAllLibraries() {
    return this.libraryRepository.findAll().stream()
            .map(library -> library.getId())
            .collect(Collectors.toList());
    }
}
