package spring.library.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.library.controller.request.MemberAddRequest;
import spring.library.controller.request.MemberRequest;
import spring.library.controller.request.MemberUpdateRequest;
import spring.library.domain.Member;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberDto {

    private Long id;
    private String name;
    private Long idNumber;
    private String feature;
    private String email;
    private String phoneNumber;

    public static MemberDto from(MemberAddRequest memberAddRequest) {
        return MemberDto.builder()
                .name(memberAddRequest.getName())
                .idNumber(memberAddRequest.getIdNumber())
                .feature(memberAddRequest.getFeature())
                .email(memberAddRequest.getEmail())
                .phoneNumber(memberAddRequest.getPhoneNumber())
                .build();
    }

    public static MemberDto from(MemberUpdateRequest memberUpdateRequest) {
        return MemberDto.builder()
                .name(memberUpdateRequest.getName())
                .idNumber(memberUpdateRequest.getIdNumber())
                .feature(memberUpdateRequest.getFeature())
                .email(memberUpdateRequest.getEmail())
                .phoneNumber(memberUpdateRequest.getPhoneNumber())
                .build();
    }

    public static MemberDto from(Member member) {
        return MemberDto.builder()
                .id(member.getId())
                .name(member.getName())
                .idNumber(member.getIdNumber())
                .feature(member.getFeature())
                .email(member.getEmail())
                .phoneNumber(member.getPhoneNumber())
                .build();
    }
}
