package com.kitaplik.libraryservice.controller;

import com.kitaplik.libraryservice.dto.AddBookRequest;
import com.kitaplik.libraryservice.dto.LibraryDto;
import com.kitaplik.libraryservice.service.LibraryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/library")
public class LibraryController {

  Logger logger = LoggerFactory.getLogger(LibraryController.class);

  private LibraryService libraryService;

  private Environment environment;

  @Autowired
  public LibraryController(LibraryService libraryService,Environment environment) {
    this.libraryService = libraryService;
    this.environment = environment;
  }

  @GetMapping("/{id}")
  public ResponseEntity<LibraryDto> getLibraryById(@PathVariable String id) {
    return ResponseEntity.ok(this.libraryService.getAllBooksInLibraryById(id));
  }

  @PostMapping()
  public ResponseEntity<LibraryDto> createLibrary() {
    logger.info("Library created on port number " + environment.getProperty("local.server.port"));

    return ResponseEntity.ok(libraryService.createLibrary());
  }

  @PutMapping("/addBookToLibrary")
  public ResponseEntity<Void> addBookToLibrary(@RequestBody AddBookRequest request) {
    this.libraryService.addBookToLibrary(request);
    return ResponseEntity.ok().build();
  }

  @GetMapping
  public ResponseEntity<List<String>> getAllLibraries() {
    return ResponseEntity.ok(libraryService.getAllLibraries());
  }
}