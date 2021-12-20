package com.gradleSample.springday3.controller;

import com.gradleSample.springday3.domain.Member;
import com.gradleSample.springday3.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller   // 톰캣이 이런 컴포넌트 에노테이션을 우선 적으로 읽어서 메모리에 등록시킴
public class MemberController {
    private final MemberService memberService;   // final로 선언을 해주고

    // 필드에 final이 있기 때문에 생성자를 통해서만 접근이 가능
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping(value = "/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping(value = "/members/new")
    public String create(MemberForm memberForm) {
        System.out.println("Create");
        System.out.println("memberForm.getName : " + memberForm.getName());
        Member member = new Member();
        member.setName(memberForm.getName());

        memberService.addMember(member);   // 멤버서비스에 정의된 addMember 메소드를 사용해서 저장

        return "redirect:/";   // rest API의 기본 기능능
    }

    @GetMapping(value = "/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();   // 전체 조회
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
