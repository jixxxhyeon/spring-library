package spring.library.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.library.controller.request.MemberAddRequest;
import spring.library.controller.request.MemberRequest;
import spring.library.controller.request.MemberUpdateRequest;
import spring.library.controller.response.MemberResponse;
import spring.library.controller.response.MemberShowAllResponse;
import spring.library.dto.MemberDto;
import spring.library.service.MemberService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/members")    //response
    public ResponseEntity<MemberResponse> addMember(@RequestBody MemberAddRequest memberAddRequest) {
        MemberDto memberDto = memberService.save(memberAddRequest);
        return ResponseEntity.ok().body(MemberResponse.from(memberDto));
    }

    @GetMapping("/members")
    public ResponseEntity<List<MemberShowAllResponse>> showAllMembers() {
        List<MemberShowAllResponse> members = memberService.findAll().stream().map(MemberShowAllResponse::from).toList();
        return ResponseEntity.ok().body(members);
    }

    @PutMapping("/members/{memberId}")  //response
    public ResponseEntity<MemberResponse> updateMember(@PathVariable Long memberId, @RequestBody MemberUpdateRequest memberUpdateRequest) {
        MemberDto memberDto = memberService.update(memberId, memberUpdateRequest);
        return ResponseEntity.ok().body(MemberResponse.from(memberDto));
    }

    @DeleteMapping("/members/{memberId}")
    public ResponseEntity<MemberResponse> deleteMember(@PathVariable Long memberId) {
        memberService.deleteById(memberId);
        return ResponseEntity.ok().build();
    }
}
