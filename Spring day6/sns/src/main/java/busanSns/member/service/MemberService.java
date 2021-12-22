package busanSns.member.service;

import busanSns.member.model.Member;

import java.util.List;
import java.util.Optional;

public interface MemberService {
    Member addMember(Member member);
    List<Member> getAllMember();
    Optional<Member> getMember(Long id);
}
