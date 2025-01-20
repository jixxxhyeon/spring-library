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
public class BookShowAllResponse {

    private String title;
    private String author;
    private String publisher;
    private Long publicationYear;
    private String classification;
    private String status;

    public BookShowAllResponse from(BookDto bookDto) {
        return BookShowAllResponse.builder()
                .title(bookDto.getTitle())
                .author(bookDto.getAuthor())
                .publisher(bookDto.getPublisher())
                .publicationYear(bookDto.getPublicationYear())
                .classification(bookDto.getClassification())
                .status(bookDto.getStatus())
                .build();
    }
}
