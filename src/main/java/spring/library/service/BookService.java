package spring.library.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import spring.library.controller.request.BookAddRequest;
import spring.library.controller.request.BookRequest;
import spring.library.controller.request.BookUpdateRequest;
import spring.library.domain.Book;
import spring.library.dto.BookDto;
import spring.library.repository.BookRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class BookService {

    private BookRepository bookRepository;

    public BookDto save(BookAddRequest bookAddRequest) {
        BookDto bookDto = BookDto.from(bookRepository.save(Book.from(bookAddRequest)));
        return bookDto;
    }

    public BookDto findById(Long bookId) {
        Book book = bookRepository.findById(bookId).ofElseThrow(() -> new IllegalArgumentException("해당 책이 존재하지 않습니다."));
        return BookDto.from(book);
    }

    public List<BookDto> findAll() {
        List<Book> books = bookRepository.findAll();
        return books.stream().map(BookDto::from).toList();
    }

    public void deleteById(Long bookId) {

        bookRepository.deleteById(bookId);
    }

    @Transactional
    public BookDto update(Long bookId, BookUpdateRequest bookUpdateRequest) {
        Book book = bookRepository.findById(bookId).ofElseThrow(() -> new IllegalArgumentException("해당 책이 존재하지 않습니다."));
        book.update(BookDto.from(bookUpdateRequest));
        return BookDto.from(book);
    }
}
