package spring.library.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookAddRequest {

    private String title;
    private String author;
    private String publisher;
    private Long publicationYear;
    private String classification;
    private String status;
}
