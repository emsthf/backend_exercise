package busanSns.post.controller;

import busanSns.member.model.Member;
import busanSns.member.service.MemberService;
import busanSns.post.dto.IPost;
import busanSns.post.medel.Post;
import busanSns.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private MemberService memberService;

    @PostMapping("/add")
    public Post add(@RequestBody IPost iPost) {   // 포린키인 멤버id를 처리하기 위해 DTO에 만든 아이포스트로 넣어준다
        // 아이포스트의 멤버id를 추출해서, 멤버서비스에 넣어 해당 id를 가진 멤버 row를 Post의 memberId자리에 넣음. 새로 만든 Post에 담았다
        return postService.addPost(
                new Post(
                        iPost.getPostName(),
                        iPost.getPostTitle(),
                        iPost.getPostText(),
                        iPost.getPostMainImg(),
                        memberService.getMember(iPost.getMemberId()).get(),   // Optional<Member>를 반환
                        iPost.getCreated(),
                        iPost.getUpdated()
                )
        );
    }

    @GetMapping("/getAll")
    public List<Post> getAll() {
        return postService.getAllPost();
    }

    @GetMapping("/get/{id}")
    public Optional<Post> getPost(@PathVariable("id") Long id) {
        return postService.getPost(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delPost(@PathVariable("id") Long id) {
        postService.delPost(id);
    }
}
