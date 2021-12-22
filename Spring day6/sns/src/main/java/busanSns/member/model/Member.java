package busanSns.member.model;

import busanSns.coment.model.Comment;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@Getter   // getter를 자동으로 만들어주는 롬복 어노테이션
//@Setter   // setter를 자동으로 만들어주는 롬복 어노테이션
//@ToString   // 필드 값을 String형식으로 출력할 수 있게 하는 ToString을 자동으로 만들어주는 롬복 어노테이션
//@NoArgsConstructor   // 생성자 자동생성 롬복 어노테이션
@Data   // 위의 모든 기능을 한번에 들고 있는 롬복 어노테이션
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;   // 앞으로는 대규모 서비스가 될 수도 있을 것을 가정해서 id를 int가 아닌 Long으로 사용하는게 좋다
    private String userName;   // 카멜케이스로 작성하면 2개의 단어라는 뜻. JPA가 DB에 컬럼을 생성할 때 _로 자동으로 띄워줌
    private String password;
    private String userEmail;   // 그냥 email로 컬럼명을 작성하면 백엔드와 DB가 충돌할 수도 있으므로
    private String created;
    private String updated;

//    @OneToMany(mappedBy = "member")   // Member와 Comment의 양방향 관계성
//    private List<Comment> commentList = new ArrayList<Comment>();

//     이번엔 관리자를 따로 두지 않겠지만 나중에 프로젝트를 할 때엔 소스코드를 건드릴 필요 없이
//     관리자 페이지가 있어서 따로 이 유저가 관리자인지 일반 유저인지 컨트롤 하고 알 수 있어야 해
}
