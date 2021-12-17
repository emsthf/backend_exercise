package com.gradleSample.springday3.repository;

import com.gradleSample.springday3.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemberRepositoryImpl implements MemberRepository {

    // 이 두개의 필드를 활용해서 기능을 만들 것
    private static Map<Integer, Member> store = new HashMap<>();
    private static int sequence = 0;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);   // 시퀀스를 1씩 더해서 id 값에 저장
        store.put(member.getId(), member);   // id 값과 멤버를 넣어서 메모리에 데이터가 들어감
        return member;   // 이렇게 저장한 멤버를 반환
    }

    @Override
    public Optional<Member> findById(int id) {   // id 값이 없을 때 처리하는 방법도 만들어 줘야 한다. 그것이 Optional<>
        return Optional.ofNullable(store.get(id));   // null이 아닐 때 id값으로 불러온 스토어를 넘겨주겠다는 뜻
    }

    @Override
    public Optional<Member> findByName(String name) {   // 이것 역시 값을 못찾아서 null 값을 반환할 때 처리하기 위해 Optional<>gud 사용
        return store.values().stream().filter(member -> member.getName().equals(name)).findAny();
        // 스토어의 벨류를 뽑을 건데 다 넘길 것은 아니고
        // stream().filter()로 필터링을 할 것. (스트림 필터는 두개 세트라고 인식하면 편함)
        // 필터링 조건은 스토어에 들어있는 member 전체에서 name이 파라미터로 받은 name과 같은 것
        // findAny()는 Optional<>의 기능. 못찾았을 때 터지는 오류를 막아줌
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());   // 스토어에 있는 값들들을 어레이리스트에 넣음
    }

    @Override
    public void clearStore() {
        store.clear();   // 메모리 단위에서 생성되는 스토어를 날려준다
    }
}
