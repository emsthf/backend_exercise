package busanSns.coment.dto;

import lombok.Data;

@Data
public class IComment {

    private Long id;
    private String commentTxt;
    private Long memberId;
    private Long postId;
}
