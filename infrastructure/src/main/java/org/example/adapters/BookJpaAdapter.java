package org.example.adapters;

import org.example.data.BookDto;
import org.example.entity.Book;
import org.example.mapper.BookMapper;
import org.example.ports.spi.BookPersistencePort;
import org.example.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BookJpaAdapter implements BookPersistencePort {

    private BookRepository bookRepository;
    @Override
    public BookDto addBook(BookDto bookDto) {

        Book book = BookMapper.INSTANCE.bookDtoToBook(bookDto);
        Book savedBook = bookRepository.save(book);
        return BookMapper.INSTANCE.bookToBookDto(savedBook);

    }

    @Override
    public void deleteByBookId(Long id) {

        bookRepository.deleteById(id);

    }

    @Override
    public BookDto updateBook(BookDto bookDto) {
        return addBook(bookDto);
    }

    @Override
    public List<BookDto> getBooks() {

        List<Book> bookList = this.bookRepository.findAll();

        return BookMapper.INSTANCE.bookListToBookDtoList(bookList);


    }

    @Override
    public BookDto getBookById(Long id) {
        Optional<Book> foundBook = bookRepository.findById(id);
        if(foundBook.isPresent()){
            return BookMapper.INSTANCE.bookToBookDto(foundBook.get());
        }
        return null;
    }
}
