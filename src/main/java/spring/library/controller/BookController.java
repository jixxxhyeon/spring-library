package spring.library.controller;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.library.controller.request.BookAddRequest;
import spring.library.controller.request.BookRequest;
import spring.library.controller.request.BookUpdateRequest;
import spring.library.controller.response.BookResponse;
import spring.library.controller.response.BookShowAllResponse;
import spring.library.controller.response.MemberResponse;
import spring.library.controller.response.MemberShowAllResponse;
import spring.library.dto.BookDto;
import spring.library.service.BookService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping("/books")  //response
    public ResponseEntity<BookResponse> addBook(@RequestBody BookAddRequest bookAddRequest) {
        BookDto bookDto = bookService.save(bookAddRequest);
        return ResponseEntity.ok().body(BookResponse.from(bookDto));
    }

    @GetMapping("/books")
    public ResponseEntity<List<BookShowAllResponse>> showAllBooks() {
        List<BookShowAllResponse> books = bookService.findAll().stream().map(MemberShowAllResponse::from).toList();
        return ResponseEntity.ok().body(books);
    }

    @PutMapping("/books/{bookId}")  //response
    public ResponseEntity<BookResponse> updateBook(@PathVariable Long bookId, @RequestBody BookUpdateRequest bookUpdateRequest) {
        BookDto bookDto = bookService.update(bookId, bookUpdateRequest);
        return ResponseEntity.ok().body(BookResponse.from(bookDto));
    }

    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<BookResponse> deleteBook(@PathVariable Long bookId) {
        bookService.deleteById(bookId);
        return ResponseEntity.ok().build();
    }

}
