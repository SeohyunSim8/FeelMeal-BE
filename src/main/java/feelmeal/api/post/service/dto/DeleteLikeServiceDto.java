package feelmeal.api.post.service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DeleteLikeServiceDto {
    private Long memberId;
    private Long postId;

    @Builder
    public DeleteLikeServiceDto(Long memberId, Long postId) {
        this.memberId = memberId;
        this.postId = postId;
    }

    public static DeleteLikeServiceDto of (Long memberId, Long postId) {
        return DeleteLikeServiceDto.builder()
                .memberId(memberId)
                .postId(postId)
                .build();
    }
}