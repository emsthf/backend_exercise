package com.gradleSample.springday3.controller;

import com.gradleSample.springday3.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller   // 톰캣이 이런 컴포넌트 에노테이션을 우선 적으로 읽어서 메모리에 등록시킴
public class MemberController {
    private final MemberService memberService;   // final로 선언을 해주고

    // 필드에 final이 있기 때문에 생성자를 통해서만 접근이 가능
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
