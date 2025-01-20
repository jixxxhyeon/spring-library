package spring.library.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.library.dto.BookDto;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookResponse {

    private Long bookId;
    private String title;
    private String author;
    private String publisher;
    private Long publicationYear;
    private String classification;
    private String status;
    private Long amount;

    public static BookResponse from(BookDto bookDto) {
        return BookResponse.builder()
                .bookId(bookDto.getId())
                .title(bookDto.getTitle())
                .author(bookDto.getAuthor())
                .publisher(bookDto.getPublisher())
                .classification(bookDto.getClassification())
                .status(bookDto.getStatus())
                .build();
    }
}
