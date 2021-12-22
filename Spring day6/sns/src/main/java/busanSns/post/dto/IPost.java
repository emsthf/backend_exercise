package busanSns.post.dto;

import lombok.Data;

@Data   // 생성자, 게터세터 자동 생성
public class IPost {

    private Long id;
    private String postName;
    private String postTitle;
    private String postText;
    private String postMainImg;
    private Long memberId;   // 멤버 id를 받아오기 위해 형을 Long으로 받고 이름을 memberId로
    private String created;
    private String updated;
}
