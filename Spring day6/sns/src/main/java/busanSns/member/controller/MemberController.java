package busanSns.member.controller;

import busanSns.member.model.Member;
import busanSns.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController   // REST API를 쓸 수 있는 컨트롤러
@RequestMapping("/member")   // 주소를 불러올 때 '/member'가 붙으면 이쪽으로 넘긴다
public class MemberController {

    @Autowired
    private MemberService memberService;

    // 이렇게 모델, 레포지토리, 서비스, 컨트롤러 기능을 분리를 해둬야만 해당 기능에 대한 api만 계속 추가하면 되기 때문. 분업도 쉬워지고

    @PostMapping("/add")   // 주소가 '/member/add'라는 게 오면 이쪽으로 넘긴다
    public Member add(@RequestBody Member member) {   // 데이터로 넘어온 JSON을 받아야 해. 이 멤버는 JSON 어디에 나와있는지 알 수 없어. 그래서 어노테이션으로 리퀘스트로 받는 JSON의 바디 부분에 있는 데이터를 멤버 파라미터로 받겠다는 뜻
        return memberService.addMember(member);   // 파라미터의 멤버에 null 값이 넘어올 수도 있는데 이것은 프론트가 막도록 처리하게 해야 한다
    }

    @GetMapping("/getAll")
    public List<Member> getAllUser() {
        return memberService.getAllMember();
    }

    @GetMapping("/get/{id}")
    public Optional<Member> getMember(@PathVariable("id") Long id) {
        return memberService.getMember(id);
    }
}
