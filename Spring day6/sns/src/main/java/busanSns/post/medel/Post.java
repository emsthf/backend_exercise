package busanSns.post.medel;

import busanSns.coment.model.Comment;
import busanSns.member.model.Member;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String postName;
    private String postTitle;
    private String postText;
    private String postMainImg;
    @ManyToOne   // JPA의 어노테이션. 多대1의 관계(포린키)를 만들어 준다
    @JoinColumn(name = "member_id")
    private Member member;
    private String created;
    private String updated;
//    @OneToMany(mappedBy = "post")   // Post와 Comment 양방향 관계성
//    private List<Comment> commentList = new ArrayList<Comment>();   // Comment을 리스트 형식으로 담는다

    public Member getMember() {
        return member;
    }

    @Builder
    public Post(String postName, String postTitle, String postText, String postMainImg, Member member, String created, String updated) {
        this.postName = postName;
        this.postTitle = postTitle;
        this.postText = postText;
        this.postMainImg = postMainImg;
        this.member = member;
        this.created = created;
        this.updated = updated;
    }
}
