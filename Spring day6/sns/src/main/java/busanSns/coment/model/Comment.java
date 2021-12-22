package busanSns.coment.model;

import busanSns.member.model.Member;
import busanSns.post.medel.Post;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String commentTxt;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;   // 댓글을 쓴 사람은 누구인지
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;   // 어느 글에 달린 댓글인지

    public Post getPost() {
        return post;
    }

    public Member getMember() {
        return member;
    }

    @Builder
    public Comment(String commentTxt, Member member, Post post) {
        this.commentTxt = commentTxt;
        this.member = member;
        this.post = post;
    }
}
