package spring.library.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import spring.library.controller.request.MemberAddRequest;
import spring.library.controller.request.MemberRequest;
import spring.library.controller.request.MemberUpdateRequest;
import spring.library.domain.Member;
import spring.library.dto.MemberDto;
import spring.library.repository.MemberRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class MemberService {

    private MemberRepository memberRepository;

    public MemberDto save(MemberAddRequest memberAddRequest) {
        Member member = memberRepository.save(Member.from(memberAddRequest));
        return MemberDto.from(member);
    }

    public MemberDto findById(Long memberId) {
        Member member = memberRepository.findById(memberId).ofElseThrow(() -> new IllegalArgumentException("해당 회원이 존재하지 않습니다."));
        return MemberDto.from(member);
    }

    public List<MemberDto> findAll() {
        List<Member> members = memberRepository.findAll();
        return members.stream().map(MemberDto::from).toList();
    }

    public void deleteById(Long memberId) {
        memberRepository.deleteById(memberId);
    }

    @Transactional
    public MemberDto update(Long memberId, MemberUpdateRequest memberUpdateRequest) {
        Member member = memberRepository.findById(memberId).ofElseThrow(() -> new IllegalArgumentException("해당 회원이 존재하지 않습니다."));
        member.update(MemberDto.from(memberUpdateRequest));
        return MemberDto.from(member);
    }
}
