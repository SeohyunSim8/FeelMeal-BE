package feelmeal.api.post.service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DeleteCommentServiceDto {
    private Long memberId;
    private Long postId;
    private Long commentId;

    @Builder
    public DeleteCommentServiceDto(Long memberId, Long postId, Long commentId) {
        this.memberId = memberId;
        this.postId = postId;
        this.commentId = commentId;
    }

    public static DeleteCommentServiceDto of (Long memberId, Long postId, Long commentId) {
        return DeleteCommentServiceDto.builder()
                .memberId(memberId)
                .postId(postId)
                .commentId(commentId)
                .build();
    }
}