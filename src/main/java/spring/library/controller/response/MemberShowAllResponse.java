package spring.library.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.library.dto.MemberDto;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberShowAllResponse {

    private Long memberId;
    private String name;
    private Long idNumber;
    private String feature;
    private String email;
    private String phoneNumber;

    public MemberShowAllResponse from(MemberDto memberDto) {
        return MemberShowAllResponse.builder()
                .memberId(memberDto.getId())
                .name(memberDto.getName())
                .idNumber(memberDto.getIdNumber())
                .feature(memberDto.getFeature())
                .email(memberDto.getEmail())
                .phoneNumber(memberDto.getPhoneNumber())
                .build();
    }
}
