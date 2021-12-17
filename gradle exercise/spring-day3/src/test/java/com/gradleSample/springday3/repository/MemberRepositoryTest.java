package com.gradleSample.springday3.repository;

import com.gradleSample.springday3.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MemberRepositoryTest {

    MemberRepository repository = new MemberRepositoryImpl();

    @AfterEach   // 다른것 실행 후에 이것부터 실행하라는 에노테이션
    public void afterEach() {
        repository.clearStore();   // 레포지토리에 있는 메모리를 날려주겠다
    }

    @Test
    void save() {
        Member member = new Member();
        member.setName("Union");

        repository.save(member);   // repository에 저장
        Member result = repository.findById(member.getId()).get();
        // 저장된 값을 id로 가져 온다. get()은 Optional로 되어 있는 것의 박스를 벗기는 것
        Assertions.assertThat(result).isEqualTo(member);
        // result에 저장된 값이 member와 같은지 확인
    }

    @Test
    void findAll() {
        Member member = new Member();
        member.setName("Union");
        repository.save(member);

        Member member1 = new Member();
        member1.setName("Busan");
        repository.save(member1);

        List<Member> result = repository.findAll();
        Assertions.assertThat(result.size()).isEqualTo(2);
        // result의 크기가 2인지 확인
    }

    @Test
    void findByName() {
        Member member = new Member();
        member.setName("오바마");
        repository.save(member);

        Member member1 = new Member();
        member1.setName("클린턴");
        repository.save(member1);

        Member result = repository.findByName("클린턴").get();
        Assertions.assertThat(result).isEqualTo(member1);
    }
}
