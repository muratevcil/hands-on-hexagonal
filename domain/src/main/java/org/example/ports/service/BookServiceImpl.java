package org.example.ports.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.data.BookDto;
import org.example.ports.api.BookServicePort;
import org.example.ports.spi.BookPersistencePort;



import java.util.List;

@AllArgsConstructor
@NoArgsConstructor

public class BookServiceImpl implements BookServicePort {


    private BookPersistencePort bookPersistencePort;


    @Override
    public BookDto addBook(BookDto book) {
        return this.bookPersistencePort.addBook(book);
    }

    @Override
    public void deleteByBookId(Long id) {
        this.bookPersistencePort.deleteByBookId(id);
    }

    @Override
    public BookDto updateBook(BookDto book) {
        return this.bookPersistencePort.updateBook(book);
    }

    @Override
    public List<BookDto> getBooks() {
        return this.bookPersistencePort.getBooks();
    }

    @Override
    public BookDto getBookById(Long id) {
        return this.bookPersistencePort.getBookById(id);
    }
}
