package com.gradleSample.springday3.service;

import com.gradleSample.springday3.domain.Member;
import com.gradleSample.springday3.repository.MemberRepository;
import com.gradleSample.springday3.repository.MemberRepositoryImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;   // 선언만 해두고
    MemberRepository memberRepository;   // 선언만 해두고

    @BeforeEach  // 다른 것이 작동하기 전에 작동
    public void beforeEach() {
        memberRepository = new MemberRepositoryImpl();   // 멤버리포지토리를 생성하고
        memberService = new MemberService(memberRepository);   // 멤버리포지토리를 멤버서비스에 넣어서 memberService를 생성해준다
    }

    @AfterEach   // 다른 것이 작동한 후에에
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void join() throws Exception {   // 예외처리를 넣어준다
        Member member = new Member();
        member.setName("바이든");

        int saveId = memberService.join(member);
        Member result = memberRepository.findById(saveId).get();

        Assertions.assertEquals(member.getName(), result.getName());
    }

    @Test
    void findMemberAll() {
        Member member = new Member();
        member.setName("바이든");
        memberService.join(member);

        Member member1 = new Member();
        member1.setName("팀쿡");
        memberService.join(member1);

        Member member2 = new Member();
        member2.setName("아이폰");
        memberService.join(member2);

        memberService.findMembers();
    }

    @Test
    void findMemberOne() {
        Member member = new Member();
        member.setName("바이든");
        memberService.join(member);

        Member member1 = new Member();
        member1.setName("팀쿡");
        memberService.join(member1);

        Member member2 = new Member();
        member2.setName("아이폰");
        memberService.join(member2);

        memberService.findOne(member.getId());
    }
}
