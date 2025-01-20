package spring.library.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberRequest {

    private String name;
    private Long idNumber;
    private String feature;
    private String email;
    private String phoneNumber;

}
