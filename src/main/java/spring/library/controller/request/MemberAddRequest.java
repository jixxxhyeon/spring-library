package spring.library.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberAddRequest {

    private String name;
    private Long idNumber;
    private String feature;
    private String email;
    private String phoneNumber;
}
