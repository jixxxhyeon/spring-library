package spring.library.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookRequest {

    private String title;
    private String author;
    private String publisher;
    private Long publicationYear;
    private String classification;
    private String status;
    private Long amount;

}
