package spring.library.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.library.controller.request.BookAddRequest;
import spring.library.controller.request.BookRequest;
import spring.library.controller.request.BookUpdateRequest;
import spring.library.domain.Book;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDto {

    private Long id;
    private String title;
    private String author;
    private String publisher;
    private Long publicationYear;
    private String classification;
    private String status;

    public static BookDto from(BookAddRequest bookAddRequest) {
        return BookDto.builder()
                .title(bookAddRequest.getTitle())
                .author(bookAddRequest.getAuthor())
                .publisher(bookAddRequest.getPublisher())
                .publicationYear(bookAddRequest.getPublicationYear())
                .classification(bookAddRequest.getClassification())
                .status(bookAddRequest.getStatus())
                .build();
    }

    public static BookDto from(BookUpdateRequest bookUpdateRequest) {
        return BookDto.builder()
                .title(bookUpdateRequest.getTitle())
                .author(bookUpdateRequest.getAuthor())
                .publisher(bookUpdateRequest.getPublisher())
                .publicationYear(bookUpdateRequest.getPublicationYear())
                .classification(bookUpdateRequest.getClassification())
                .status(bookUpdateRequest.getStatus())
                .build();
    }

    public static BookDto from(Book book) {
        return BookDto.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .publisher(book.getPublisher())
                .publicationYear(book.getPublicationYear())
                .classification(book.getClassification())
                .status(book.getStatus())
                .build();
    }
}
