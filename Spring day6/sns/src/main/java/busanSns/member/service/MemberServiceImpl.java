package busanSns.member.service;

import busanSns.member.model.Member;
import busanSns.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;   // 메모리가 아니기 때문에 생성할 필요 없이 붙기만 하면 된다

    @Override
    public Member addMember(Member member) {
        return memberRepository.save(member);   // 레포지토리를 찾아서 JPA에 있는 save로 member를 저장한다
    }

    @Override
    public List<Member> getAllMember() {
        return memberRepository.findAll();
    }

    @Override
    public Optional<Member> getMember(Long id) {
        return Optional.ofNullable(memberRepository.findById(id).get());
    }
}
