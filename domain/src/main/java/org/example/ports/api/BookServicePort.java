package org.example.ports.api;

import org.example.data.BookDto;


import java.util.List;



public interface BookServicePort {
    BookDto addBook(BookDto book);

    void deleteByBookId(Long id);

    BookDto updateBook(BookDto book);

    List<BookDto> getBooks();

    BookDto getBookById(Long id);


}
