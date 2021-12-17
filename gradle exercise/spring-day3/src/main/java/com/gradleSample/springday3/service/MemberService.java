package com.gradleSample.springday3.service;

import com.gradleSample.springday3.domain.Member;
import com.gradleSample.springday3.repository.MemberRepository;
import com.gradleSample.springday3.repository.MemberRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

//    private MemberRepository memberRepository = new MemberRepositoryImpl();  // new로 인스턴스 하게되면 클래스가 생성 될 때마다 레포지토리를 계속 생성하게 되서 안좋다
    private final MemberRepository memberRepository;  // final을 붙여서 생성자를 통해서만 사용하게됨

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 회원 등록
    public int join(Member member) {   // join 메소드는 Member형 파라미터를 받고 int형으로 리턴한다
        validateDuplicateMember(member);   // 아래에서 만든 중복 이름 검사 메소드를 실행하고 같은 이름이 없으면
        memberRepository.save(member);     // 레포지토리에 저장하는 과정 실행
        return member.getId();
    }

    // 전체 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    // id로 조회
    public Optional<Member> findOne(int memberId) {
        return memberRepository.findById(memberId);
    }

    // 같은 이름이 있는지 검사
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())   // findByName은 반환형이 Optional<>형이라서 null값이라도 null 자체를 리턴 해줌(즉, 무조건 리턴 값이 있음)
                .ifPresent(member1 -> {
                // ifPresent()는 null이 아닐 때 하위 코드 작동 시키는 메소드
                // 값이 있는데 null일 때는 하위 코드 작동 하지 않고 그냥 통과

                    // 예외 처리. 값이 있는데 null이 아닐 때 동작
                    throw new IllegalStateException("이미 존재 합니다.");
                    // throw로 인해 중복 이름이 있으면 오류 메시지 띄우면서 실행 끝
                });
        // 입력받은 이름으로 같은 이름이 있는지 조회
    }
}
