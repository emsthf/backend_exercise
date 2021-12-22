package busanSns.coment.controller;

import busanSns.coment.dto.IComment;
import busanSns.coment.model.Comment;
import busanSns.coment.service.CommentService;
import busanSns.member.service.MemberService;
import busanSns.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private PostService postService;

    @PostMapping("/add")
    public Comment add(@RequestBody IComment iComment) {
        return commentService.addComment(
                new Comment(
                        iComment.getCommentTxt(),
                        memberService.getMember(iComment.getMemberId()).get(),
                        postService.getPost(iComment.getPostId()).get()
                )
        );
    }

    @GetMapping("/getAll")
    public List<Comment> getAll() {
        return commentService.getAllComment();
    }

    @GetMapping("/get/{id}")
    public Optional<Comment> getComment(@PathVariable("id") Long id) {
        return commentService.getComment(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delComment(@PathVariable("id") Long id) {
        commentService.delComment(id);
    }
}
