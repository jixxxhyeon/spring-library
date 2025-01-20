package spring.library.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberUpdateRequest {

    private String name;
    private Long idNumber;
    private String feature;
    private String email;
    private String phoneNumber;

}
