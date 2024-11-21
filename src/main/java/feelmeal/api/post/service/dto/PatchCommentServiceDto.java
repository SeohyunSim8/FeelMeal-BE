package feelmeal.api.post.service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PatchCommentServiceDto {
    private Long memberId;
    private Long postId;
    private Long commentId;
    private String content;

    @Builder
    public PatchCommentServiceDto(Long memberId, Long postId, Long commentId, String content) {
        this.memberId = memberId;
        this.postId = postId;
        this.commentId = commentId;
        this.content = content;
    }
}