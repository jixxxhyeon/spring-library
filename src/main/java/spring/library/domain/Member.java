package spring.library.domain;

import jakarta.persistence.*;
import lombok.*;
import spring.library.dto.MemberDto;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;
    private String name;
    private Long idNumber;
    private String feature;
    private String email;
    private String phoneNumber;

    @OneToMany(
            mappedBy = "member",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Book> books;

    public static Member from(MemberDto memberDto) {
        return Member.builder()
                .id(memberDto.getId())
                .name(memberDto.getName())
                .idNumber(memberDto.getIdNumber())
                .feature(memberDto.getFeature())
                .email(memberDto.getEmail())
                .phoneNumber(memberDto.getPhoneNumber())
                .build();
    }

    public void update(MemberDto memberDto) {
        this.id = memberDto.getId();
        this.name = memberDto.getName();
        this.idNumber = memberDto.getIdNumber();
        this.feature = memberDto.getFeature();
        this.email = memberDto.getEmail();
        this.phoneNumber = memberDto.getPhoneNumber();
    }


}
